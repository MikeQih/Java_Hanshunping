package com.hspedu.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

//第一个Jdbc程序，完成简单的操作
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        // 1.注册驱动 - 加载Driver类
        Driver driver = new Driver();

        // 2.获取连接 - 得到Connection
        /*
         * (1)jdbc:mysql:// 规定好表示协议，通过jdbc的方式连接mysql
         * (2)localhost 主机，可以是ip地址
         * (3)3306 表示mysql监听的端口
         * (4)hsp_db02 连接到mysql dbms的哪个数据库
         * (5)mysql连接的本质还是前面学过的socket连接
         */
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        //将用户名和密码放到Properties对象
        Properties properties = new Properties();
        //user和password是规定好的，后面的值根据实际情况写
        properties.setProperty("user", "root"); //用户
        properties.setProperty("password", "qhc5211314"); //密码

        //通过给定的url连接数据库
        Connection connect = driver.connect(url,properties); //connect就相当于网络连接

        // 3.执行增删改查 - 发送SQL语句给mysql执行
        // String sql = "insert into actor values(null,'刘德华','男','1970-11-11','110')";
        // String sql = "update actor set `name` = '周星驰' where id = 1";
        String sql = "delete from actor where id = 100";

        
        //statement 用于执行静态sql语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); //如果是dml语句，返回的就是影响行数
        System.out.println(rows>0 ? "成功" : "失败");
        

        // 4.释放资源 - 关闭相关连接
        statement.close();
        connect.close();
    }
}
