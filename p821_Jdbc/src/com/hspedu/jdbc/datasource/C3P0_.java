package com.hspedu.jdbc.datasource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@SuppressWarnings({"all"})
public class C3P0_{

    @Test
    //方式1: 相关参数，在程序中指定user，url，password等
    public void testC3P0_01() throws Exception{
        //1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
    
        //2.通过配置文件mysql.properties获取相关的连接信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("/Users/hengchangqi/c_vscode/Java_Hanshunping/p821_Jdbc/src/mysql.properties"));
        //读取相关的属性值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //给数据源 comboPooledDataSource 设置相关的参数
        //注意：连接管理是由 comboPooledDataSource 来管理
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setUser(user);

        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        //测试连接池的效率，测试对mysql 5000次操作
        long start = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            Connection connection = comboPooledDataSource.getConnection(); //核心方法
            // System.out.println("连接成功！");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0第一种方式，5000次连接mysql，耗时：" + (end-start)); //309ms
    }

    //第二种方式：使用配置文件模版来完成
    //把c3p0-config.xml写到src目录下，该文件指定了连接数据库和连接池的相关参数
    @Test
    public void testC3P0_02() throws SQLException{
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("mike_pool");

        //测试5000次连接mysql
        long start = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            Connection connection = comboPooledDataSource.getConnection();
            // System.out.println("连接OK！！");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0第二种方式，5000次连接mysql，耗时：" + (end-start)); //314ms

    }
}
