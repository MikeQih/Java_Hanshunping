package com.hspedu.jdbc.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

// import com.hspedu.jdbc.utils.JDBCUtils;

public class DBUtils_USE {

    @Test
    //使用 Apache-DBUtils工具类 + druid 完成对表的crud操作
    public void testQueryMany() throws SQLException{ //返回结果是多行的情况
        //1.得到连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();

        //2.使用DBUtils类和接口，引入DBUtils.jar包

        //3.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        //4.就可以执行相关的方法，返回ArrayList结果集
        // String sql = "select * from actor where id >= ?";
        //也可以查询部分列
        String sql = "select id,name from actor where id >= ?";

        //query方法就是执行sql语句，得到resultset 封装到 ArrayList集合中
        //new BeanListHandler<>(Actor.class)：将resultset -> Actor对象 -> 封装到ArrayList。底层使用反射机制，获取Actor的属性，然后进行封装
        //最后的1，是给?的值，可以有多个
        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);

        System.out.println("输出集合的信息：");
        for(Actor actor : list){
            System.out.print(actor);
        }

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    @Test
    //演示 apache-dbutils + druid 完成 返回的结果是单行记录(单个对象)
    public void testQuerySingle() throws SQLException{
        //1.得到连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();

        //2.使用DBUtils类和接口，引入DBUtils.jar包

        //3.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        //4.就可以执行相关的方法，返回单个对象
        String sql = "select * from actor where id = ?";
        
        //因为返回的是单行记录(单个对象)，使用的Handler是BeanHandler
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 2);
        System.out.println(actor);

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection); //resultSet和statement底层都已关闭
    }


    @Test
    //演示apache-dbutils + druid 查询结果是单行单列，返回的就是object
    public void testScaler() throws SQLException{
        //1.得到连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();

        //2.使用DBUtils类和接口，引入DBUtils.jar包
        //3.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        //4.就可以执行相关的方法，返回单行单列，返回的就是object
        String sql = "select name from actor where id = ?";
        Object obj = queryRunner.query(connection, sql, new ScalarHandler<>(), 2);
        System.out.println(obj);

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection); //resultSet和statement底层都已关闭
    }

    @Test
    //演示 apache-dbutils + druid 完成dml(update,insert,delete)
    public void testDML() throws SQLException{
        //1.得到连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();

        //2.使用DBUtils类和接口，引入DBUtils.jar包
        //3.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        
        //4.组织sql语句，完成update,insert,delete
        // String sql = "update actor set name = ? where id = ?";
        // String sql = "insert into actor values(null,?,?,?,?)";
        String sql = "delete from actor where id = ?";


        //执行dml操作是queryRunner.update()
        //返回的值是受影响的行数
        // int affectedRow = queryRunner.update(connection, sql, "lucas","男","2002-11-3","224");
        int affectedRow = queryRunner.update(connection, sql, 6);

        System.out.println(affectedRow>0 ? "执行成功" : "执行没有影响到表");

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }
}
