package com.hspedu.jdbc.statement_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

/**
 * 演示statement的注入问题
 */
public class Statement_ {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //让用户输入管理员名和密码
        System.out.println("请输入管理员的名字："); //next():当接收到 空格 或者 ' 就表示结束
        String admin_name = scanner.nextLine(); //如果希望看到sql注入，就需要用nextLine() (nextLine回车才算结束)
        System.out.println("请输入管理员的密码：");
        String admin_pwd = scanner.nextLine();


        Properties properties = new Properties();
        properties.load(new FileInputStream("/Users/hengchangqi/c_vscode/Java_Hanshunping/p821_Jdbc/src/mysql.properties"));
        //获取相关的值
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String user = properties.getProperty("user");
        String driver = properties.getProperty("driver");

        //1.注册驱动
        // Class.forName(driver); //建议写上

        //2.得到连接
        Connection connection = DriverManager.getConnection(url,user,password); //connect就相当于网络连接
        //3.得到statement
        Statement statement = connection.createStatement();
        //4.组织sql (就是拼接)
        String sql = "select name,pwd from admin where name = '"
            + admin_name + "' and pwd = '" + admin_pwd + "' ";
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){ //如果查询到一条记录，说明该管理存在
            System.out.println("恭喜，登陆成功");
        } else{
            System.out.println("抱歉，登陆失败");
        }

        //5.关闭连接
        resultSet.close();
        statement.close();
        connection.close();


        //想看sql注入，下面的万能密码
        //输入用户：1' or
        //密码：or '1'='1
        //也能成功

        
    }
}
