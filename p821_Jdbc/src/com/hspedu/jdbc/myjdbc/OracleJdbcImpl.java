package com.hspedu.jdbc.myjdbc;

public class OracleJdbcImpl implements JdbcInterface{

    @Override
    public void close() {
        System.out.println("关闭 oracle 的连接");        
    }

    @Override
    public void crud() {
        System.out.println("完成 oracle 的增删改查");        
    }

    @Override
    public Object getConnection() {
        System.out.println("得到 oracle 的连接");
        return null;
    }
    
}
