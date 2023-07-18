package com.hspedu.jdbc.datasource;

import java.sql.Connection;

import org.junit.Test;

import com.hspedu.jdbc.utils.JDBCUtils;


public class ConQuestion {
    @Test
    //传统连接5000次
    public void testCon(){
        long start = System.currentTimeMillis();
        System.out.println("开始连接...");
        for(int i=0;i<5000;i++){
            //用传统jdbc方式得到连接
            Connection connection = JDBCUtils.getConnection();
            JDBCUtils.close(null, null, connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方式5000次，耗时："+(end-start)); //14885ms 真的慢

    }
}
