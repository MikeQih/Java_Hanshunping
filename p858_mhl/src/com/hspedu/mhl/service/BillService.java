package com.hspedu.mhl.service;

import java.util.List;
import java.util.UUID;

import com.hspedu.mhl.dao.BillDAO;
import com.hspedu.mhl.dao.MultiTableDAO;
import com.hspedu.mhl.domain.Bill;
import com.hspedu.mhl.domain.MultiTableBean;

/**
 * 处理和账单相关的业务逻辑
 */
public class BillService {
    //定义一个BillDao对象
    private BillDAO billDAO = new BillDAO();
    //定义MenuService属性
    private MenuService menuService = new MenuService();
    //定义DiningTableService属性
    private DiningTableService diningTableService = new DiningTableService();
    private MultiTableDAO multiTableDAO = new MultiTableDAO();
    /*
    编写点餐的方法
    1.生成账单
    2.需更新对应餐桌的状态
    3.如果成功，返回true，否则返回false 
    */
    public boolean orderMenu(int menuId, int nums, int diningTableId){
        //生成一个账单号，UUID(Universally Unique Identifier, 通用唯一识别码)
        String billId = UUID.randomUUID().toString(); //返回随机字符串，避免重复

        //把账单生成到数据库 bill表，需要直接算出账单金额
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billId,menuId,nums,menuService.getMenuById(menuId).getPrice()*nums,diningTableId);
    
        if(update <= 0){
            return false;
        }

        //需更新对应餐桌的状态
        return diningTableService.updateDiningTableState(diningTableId, "就餐中");
    }

    //返回所有账单，提供给View调用
    public List<Bill> list(){
        return billDAO.queryMulti("select * from bill", Bill.class);
    }

    //返回所有账单并带有菜品名，提供给View调用
    public List<MultiTableBean> list2(){
        return multiTableDAO.queryMulti("select bill.*,name,price from bill,menu where bill.menuId=menu.id", MultiTableBean.class);
    }

    //查看某个餐桌是否有未结账的账单
    public boolean hasPayBillByDiningTableId(int diningTableId){
        Bill bill = billDAO.querySingle("select * from bill where diningTableId=? and state='未结账' limit 0,1",Bill.class,diningTableId);
        return bill != null; //不等于空就是有
    }

    //完成结账 (如果餐桌存在，并且该餐桌有未结账的账单)
    public boolean payBill(int diningTableId,String payMode){
        //如果使用事务，需要用ThreadLocal来解决，框架中比如mybatis提供了事务支持
        //1.修改bill表
        int update = billDAO.update("update bill set state=? where diningTableId=? and state='未结账'", payMode,diningTableId);
        if(update<=0){
            return false;
        }

        //2.修改diningTable表
        //调用DiningTableService的方法，体现各司其职
        if(!diningTableService.updateDiningTableToFree(diningTableId, "空")){
            return false;
        }

        return true;
    }
    
}
