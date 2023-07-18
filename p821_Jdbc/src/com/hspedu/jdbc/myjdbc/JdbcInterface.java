package com.hspedu.jdbc.myjdbc;
public interface JdbcInterface {
    //我们规定的jdbc接口(方法)
    
    //连接
    public Object getConnection();
    //crud
    public void crud();
    //关闭连接
    public void close();



}
