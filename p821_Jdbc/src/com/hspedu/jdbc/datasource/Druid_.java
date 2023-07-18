package com.hspedu.jdbc.datasource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class Druid_ {
    @Test
    public void testDruid() throws Exception{
        //1.加入druid jar包
        //2.加入配置文件druid.properties，放在src的目录
        //3.创建properties对象，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("/Users/hengchangqi/c_vscode/Java_Hanshunping/p821_Jdbc/src/druid.properties"));
        
        //4.创建一个指定参数的数据库连接地
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        long start = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            Connection connection = dataSource.getConnection();
            // System.out.println("连接成功");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("druid连接池，5000次连接mysql，耗时："+(end-start)); //388ms (调成500000次，就能快的特别明显)

    }
}
