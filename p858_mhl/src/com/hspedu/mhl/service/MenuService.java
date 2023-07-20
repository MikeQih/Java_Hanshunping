package com.hspedu.mhl.service;

import java.util.List;

import com.hspedu.mhl.dao.MenuDAO;
import com.hspedu.mhl.domain.Menu;

/**
 * 完成对Menu表的各种操作（通过调用MenuDAO）
 */
public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();

    //返回所有菜品
    public List<Menu> list(){
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }

    //需要方法，根据id，返回Menu对象
    public Menu getMenuById(int id){
        return menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
    }
}
