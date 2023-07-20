package com.hspedu.mhl.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        //测试Utility工具类
        System.out.println("请输入一个整数：");
        int i = Utility.readInt();
        System.out.println("i = "+i);

        //测试JDBCUtilsByDruid
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection);
    }
}
