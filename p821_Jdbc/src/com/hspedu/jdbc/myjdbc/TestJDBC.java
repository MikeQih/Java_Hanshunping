package com.hspedu.jdbc.myjdbc;
public class TestJDBC {
    public static void main(String[] args) {
        //完成对mysql的操作
        // JdbcInterface jdbcInterface = new MysqlJdbcImpl();

        //完成对oracle的操作
        JdbcInterface jdbcInterface = new OracleJdbcImpl();

        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();
    }
}
