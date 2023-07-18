package com.hspedu.jdbc.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.hspedu.jdbc.utils.JDBCUtils;

public class Batch_ {
    //传统方法，添加5000条数据到admin2
    @Test
    public void noBatch() throws SQLException{
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis(); //开始时间
        for(int i=0;i<5000;i++){
            prepareStatement.setString(1,"jack"+i);
            prepareStatement.setString(2,"666");
            prepareStatement.executeUpdate();
        }
        long end = System.currentTimeMillis(); //结束时间
        System.out.println("传统的方式 耗时："+(end-start)); //735 0.7s左右
        //关闭连接
        JDBCUtils.close(null, prepareStatement, connection);
    }

    //使用批量方式添加数据
    @Test
    public void batch() throws SQLException{
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis(); //开始时间
        for(int i=0;i<5000;i++){
            prepareStatement.setString(1,"jack"+i);
            prepareStatement.setString(2,"666");
            //将sql语句加入到 批处理 包中
            prepareStatement.addBatch();
            //当有1000条记录，再批量执行
            if((i+1)%1000==0){
                prepareStatement.executeBatch();
                //清空一次
                prepareStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis(); //结束时间
        System.out.println("传统的方式 耗时："+(end-start)); //68
        //关闭连接
        JDBCUtils.close(null, prepareStatement, connection);
    }
    
}
