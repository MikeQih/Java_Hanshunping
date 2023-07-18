package com.hspedu.jdbc.resultset_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.Properties;
import java.sql.Statement;
/**
 * 演示select语句，返回ResultSet，并取出结果
 */
public class ResultSet_ {
    public static void main(String[] args) throws Exception {
        //通过Properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("/Users/hengchangqi/c_vscode/Java_Hanshunping/p821_Jdbc/src/mysql.properties"));
        //获取相关的值
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String user = properties.getProperty("user");
        String driver = properties.getProperty("driver");

        //1.注册驱动
        Class.forName(driver); //建议写上
        //2.得到连接
        Connection connection = DriverManager.getConnection(url,user,password); //connect就相当于网络连接
        //3.得到statement
        Statement statement = connection.createStatement();
        //4.组织sql
        String sql = "select id,name,sex,borndate from actor";
        //执行给定的SQL语句，该语句返回单个ResultSet对象
        ResultSet resultSet = statement.executeQuery(sql);

        //5.使用while循环取出数据
        while(resultSet.next()){ //让光标向后移动，如果没有更多行，则返回false
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            System.out.println(id+"\t"+name+"\t"+sex+"\t"+date);
        }
        //6.关闭连接
        resultSet.close();
        statement.close();
        connection.close();

         



    }


        
}
