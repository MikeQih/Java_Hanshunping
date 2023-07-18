package com.hspedu.jdbc.transaction_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hspedu.jdbc.utils.JDBCUtils;

/**
 * 演示jdbc中 如何使用事务
 */
@SuppressWarnings({"all"})
public class Transaction_ {
    public static void main(String[] args) {
        // noTransaction();
        useTransaction();
    }
    public static void noTransaction(){
        //1.得到连接
        Connection connection = null;

        //2.组织一个sql
        String sql = "update account_shiwu set balance = balance - 100 where id = 1";
        String sql2 = "update account_shiwu set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;

        //3.创建PreparedStatement对象
        try {
            connection = JDBCUtils.getConnection(); //默认情况下，connection是默认自动提交
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();//执行第一条sql
            
            int i = 1/0; //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();//执行第二条sql

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{

            //关闭资源
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }

    public static void useTransaction(){
        //1.得到连接
        Connection connection = null;

        //2.组织一个sql
        String sql = "update account_shiwu set balance = balance - 100 where id = 1";
        String sql2 = "update account_shiwu set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;

        //3.创建PreparedStatement对象
        try {
            connection = JDBCUtils.getConnection(); //默认情况下，connection是默认自动提交
            //将connection设置为不自动提交
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();//执行第一条sql
            
            // int i = 1/0; //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();//执行第二条sql

            //这里提交事务
            connection.commit();

        } catch (SQLException e) {
            //这里可以进行回滚，撤销执行的sql
            //默认回滚到事务开始的状态
            System.out.println("执行发生了异常，撤销执行的sql");
            try {
                connection.rollback(null);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally{

            //关闭资源
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
}
