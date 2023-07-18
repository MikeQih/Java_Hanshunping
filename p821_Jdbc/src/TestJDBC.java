public class TestJDBC {
    public static void main(String[] args) {
        //完成对mysql的操作
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();
    }
}
