package com.hspedu.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import com.mysql.jdbc.Driver;

public class JdbsConn {
    public static void main(String[] args) throws Exception {
        // connect01();
        // connect02();
        // connect03();
        // connect04();
        connect05();
    }
    
    public static void connect01() throws SQLException {
        //java连接的几种方式
        //第一种：
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        //将用户名和密码放到Properties对象
        Properties properties = new Properties();
        //user和password是规定好的，后面的值根据实际情况写
        properties.setProperty("user", "root"); //用户
        properties.setProperty("password", "qhc5211314"); //密码
        Connection connect = driver.connect(url,properties); //connect就相当于网络连接
        System.out.println(connect);
        connect.close();
    }

    @SuppressWarnings({"all"})
    public static void connect02() throws Exception{
        //2.使用反射加载Driver类，动态加载，更加灵活，减少依赖性
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        //将用户名和密码放到Properties对象
        Properties properties = new Properties();
        //user和password是规定好的，后面的值根据实际情况写
        properties.setProperty("user", "root"); //用户
        properties.setProperty("password", "qhc5211314"); //密码
        Connection connect = driver.connect(url,properties); //connect就相当于网络连接
        System.out.println("方式二 = "+connect);
        connect.close();
    }

    @SuppressWarnings({"all"})
    public static void connect03() throws Exception{
        //3.使用DriverManager替代Driver进行统一管理
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        String user = "root";
        String password = "qhc5211314";
        DriverManager.registerDriver(driver); //注册Driver驱动
        Connection connect = DriverManager.getConnection(url,user,password); //connect就相当于网络连接
        System.out.println("方式三 = "+connect);
        connect.close();
    }

    public static void connect04() throws Exception{
        //4.使用Class.forName自动完成注册驱动，简化代码 (使用最多的一种)
        //使用反射加载了Driver类，在加载Driver类时，完成注册
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        String user = "root";
        String password = "qhc5211314";
        Connection connect = DriverManager.getConnection(url,user,password); //connect就相当于网络连接
        System.out.println("方式四 = "+connect);
        connect.close();
    }

    public static void connect05() throws Exception{
        //5.在方式4的基础上改进，增加配置文件，让连接mysql更加灵活 (4，5两种方式都可)
        //通过Properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("/Users/hengchangqi/c_vscode/Java_Hanshunping/p821_Jdbc/src/mysql.properties"));
        
        //获取相关的值
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String user = properties.getProperty("user");
        String driver = properties.getProperty("driver");

        Class.forName(driver); //建议写上
        Connection connect = DriverManager.getConnection(url,user,password); //connect就相当于网络连接
        System.out.println("方式五 = "+connect);
        connect.close();
    }
}
