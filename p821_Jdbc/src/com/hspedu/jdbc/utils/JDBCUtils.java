package com.hspedu.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 这是一个工具类，完成mysql的连接和关闭资源
 */
public class JDBCUtils {
    //定义相关属性(4个)，因为只需要一份，因此做成static
    private static String user; //用户名
    private static String password; //密码
    private static String url; //url
    private static String driver; //驱动名
    //在static代码块去初始化
    static{
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("/Users/hengchangqi/c_vscode/Java_Hanshunping/p821_Jdbc/src/mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //在实际开发中，我们可这样处理
            //1.将编译异常转成运行异常
            //2.这是调用者，可以捕获该异常，也可以选择默认处理该异常，比较方便
            throw new RuntimeException(e);
        }
    }

    //连接数据库，返回Connection
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //1.将编译异常转成运行异常
            //2.这是调用者，可以捕获该异常，也可以选择默认处理该异常，比较方便
            throw new RuntimeException(e);
        }
    }

    //关闭相关资源
    /*
     * 1.ResultSet结果集
     * 2.Statement或者PreparedStatement
     * 3.Connection
     * 4.如需关闭资源，就传入对象，否则传入null
     */
    public static void close(ResultSet set,Statement statement,Connection connection){
        try {
            if(set!=null){
                set.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            //将编译异常转成运行异常抛出
            throw new RuntimeException(e);
        }
    }
    
    
}
