package com.hspedu.mhl.service;

import java.util.List;

import com.hspedu.mhl.dao.DiningTableDAO;
import com.hspedu.mhl.domain.DiningTable;

public class DiningTableService {
    //定义一个DiningTableDao对象
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    //返回所有餐桌的信息
    public List<DiningTable> list(){
        return diningTableDAO.queryMulti("select id,state from diningTable", DiningTable.class);
    }

    //根据id，查询对应的餐桌DiningTable对象，如果返回null，表示id编号对应的餐桌不存在
    public DiningTable getDiningTableById(int id){
        return diningTableDAO.querySingle("select * from diningTable where id = ?", DiningTable.class, id);
    }

    //如果餐桌可以预定，调用方法，对其状态进行更新(包括预定人名字和电话)
    public boolean orderDiningTable(int id,String orderName,String orderTel){
        int update = diningTableDAO.update("update diningTable set state = '已被预定',orderName = ?, orderTel = ? where id = ?",orderName,orderTel,id);
        return update>0;
    }

    //需提供一个 更新餐桌状态 的方法
    public boolean updateDiningTableState(int id,String state){
        int update = diningTableDAO.update("update diningTable set state = ? where id = ?", state,id);
        return update > 0;
    }

    //提供方法，将指定的餐桌设置为空闲状态
    public boolean updateDiningTableToFree(int id,String state){
        int update = diningTableDAO.update("update diningTable set state = ?, orderName='', orderTel='' where id = ?", state,id);
        return update > 0;
    }

}
