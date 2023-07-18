package com.hspedu.jdbc.preparedstatement_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

@SuppressWarnings({"all"})
public class PreparedStatementDML_ {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //让用户输入管理员名和密码
        System.out.println("请输入要删除的管理员的名字："); //next():当接收到 空格 或者 ' 就表示结束
        String admin_name = scanner.nextLine(); //如果希望看到sql注入，就需要用nextLine() (nextLine回车才算结束)
        // System.out.println("请输入管理员的新密码：");
        // String admin_pwd = scanner.nextLine();

        Properties properties = new Properties();
        properties.load(new FileInputStream("/Users/hengchangqi/c_vscode/Java_Hanshunping/p821_Jdbc/src/mysql.properties"));
        //获取相关的值
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String user = properties.getProperty("user");
        // String driver = properties.getProperty("driver");

        //1.注册驱动
        // Class.forName(driver); //建议写上

        //2.得到连接
        Connection connection = DriverManager.getConnection(url,user,password); //connect就相当于网络连接

        //3.得到PreparedStatement
        //3.1 组织sql，Sql语句的?就相当于占位符
        //添加记录
        // String sql = "insert into admin values(?,?)";
        // String sql = "update admin set pwd = ? where name = ?";
        String sql = "delete from admin where name = ?";

        //3.2 prepareStatement 对象实现了 PrepareStatement接口的实现类的对象
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        //3.3 给?赋值
        prepareStatement.setString(1, admin_name); //给 第一个问号“?” 赋值
        // prepareStatement.setString(2, admin_name);

        //4.执行 dml 语句，使用executeUpdate
        int rows = prepareStatement.executeUpdate();
        System.out.println(rows>0?"执行成功":"执行失败");
        
        //5.关闭连接
        prepareStatement.close();
        connection.close();
    }
}
