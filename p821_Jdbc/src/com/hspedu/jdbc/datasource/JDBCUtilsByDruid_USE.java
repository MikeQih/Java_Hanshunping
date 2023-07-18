package com.hspedu.jdbc.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;


public class JDBCUtilsByDruid_USE {
    @Test
    public void selectDML(){
        //1.得到连接
        Connection connection = null;

        //2.组织一个sql
        String sql = "select * from actor"; //还可以测试delete和insert语句
        PreparedStatement preparedStatement = null;
        ResultSet set = null;

        //3.创建PreparedStatement对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass()); //输出运行类型：class com.alibaba.druid.pool.DruidPooledConnection
            preparedStatement = connection.prepareStatement(sql);
            //执行
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while(set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                String borndate = set.getString("borndate");
                String phone = set.getString("phone");
                System.out.println(id+"\t"+name+"\t"+sex+"\t"+borndate+"\t"+phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //关闭资源
            JDBCUtilsByDruid.close(set,preparedStatement,connection);
        }
    }

    //使用土方法解决ResultSet 封装 => ArrayList
    @Test
    public void testSelectToArrayList(){
        //1.得到连接
        Connection connection = null;

        //2.组织一个sql
        String sql = "select * from actor"; //还可以测试delete和insert语句
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        ArrayList<Actor> list = new ArrayList<>(); //创建ArrayList对象，存放actor对象

        //3.创建PreparedStatement对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass()); //输出运行类型：class com.alibaba.druid.pool.DruidPooledConnection
            preparedStatement = connection.prepareStatement(sql);
            //执行
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while(set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                // System.out.println(id+"\t"+name+"\t"+sex+"\t"+borndate+"\t"+phone);
                //把得到的resultset的记录，封装到Actor对象，放入到list集合
                list.add(new Actor(id, name, sex, borndate, phone));
            }
            // System.out.println("list集合数据 = "+list);
            for(Actor actor:list){
                System.out.println("id = "+actor.getId()+"\t"+actor.getName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //关闭资源
            JDBCUtilsByDruid.close(set,preparedStatement,connection);
        }
        //因为ArrayList和connection没有任何关联，所以该集合可以复用
        // return list; 把返回类型改成ArrayList<Actor>
    }
}
