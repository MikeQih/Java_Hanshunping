package com.hspedu.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 该类演示如何使用JDBCUtils工具类，完成dml和select
 */

public class JDBCUtils_Use {
    public static void main(String[] args) {
        // testDML();
        selectDML();
    }

    public static void selectDML(){
        //1.得到连接
        Connection connection = null;

        //2.组织一个sql
        String sql = "select * from actor"; //还可以测试delete和insert语句
        PreparedStatement preparedStatement = null;
        ResultSet set = null;

        //3.创建PreparedStatement对象
        try {
            connection = JDBCUtils.getConnection();
            System.out.println(connection.getClass()); //输出运行类型：class com.mysql.cj.jdbc.ConnectionImpl
            preparedStatement = connection.prepareStatement(sql);
            //执行
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while(set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                String borndate = set.getString("borndate");
                String phone = set.getString("phone");
                System.out.println(id+"\t"+name+"\t"+sex+"\t"+borndate+"\t"+phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //关闭资源
            JDBCUtils.close(set,preparedStatement,connection);
        }
    }
    public static void testDML(){ //insert,update,delete
        //1.得到连接
        Connection connection = null;

        //2.组织一个sql
        String sql = "update actor set name = ? where id = ?"; //还可以测试delete和insert语句
        PreparedStatement preparedStatement = null;

        //3.创建PreparedStatement对象
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1, "周星驰"); //第1个问号，“周星驰”
            preparedStatement.setInt(2, 3); //第2个问号，id=3
            //执行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //关闭资源
            JDBCUtils.close(null,preparedStatement,connection);
        }

        
    }
}
