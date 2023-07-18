package com.hspedu.dao_.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 基于druid数据库连接池的工具类
 */
public class JDBCUtilsByDruid {
    private static DataSource ds;
    //在静态代码块完成ds 初始化
    static{
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("/Users/hengchangqi/c_vscode/Java_Hanshunping/p821_Jdbc/src/druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }

    //关闭连接，在数据库连接技术中，close不是真的断掉连接
    //而是把使用的Connection对象放回连接池 (druid的特点)
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
