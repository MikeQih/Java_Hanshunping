//mysql 数据库实现了jdbc接口(模拟) [mysql厂商开发]
public class MysqlJdbcImpl implements JdbcInterface{

    @Override
    public void close() {
        System.out.println("关闭 mysql 的连接");
    }

    @Override
    public void crud() {
        System.out.println("完成 mysql 的增删改查");

    }

    @Override
    public Object getConnection() {
        System.out.println("得到 mysql 的连接");
        return null;
    }
    
}