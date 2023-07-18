public class note {
    public static void main(String[] args) {
        
    }
}
/*
java程序【公司】
1.如果不同的数据库，方法不统一，不利于程序管理
2.改进：规定一套接口规范，让不同的数据库厂商实现 (让mysql,oracle,db2,sql server集体实现一个接口，在java中统计调用接口的方法即可管理所有了)
(这些数据库厂商都会把他们的类打包成一个大文件（jar[驱动]）eg. mysql-connect-java....jar)


JDBC概述：
1.JDBC为访问不同的数据库提供了统一的接口，为使用者屏蔽了细节问题
2.Java程序员使用JDBC，可以连接任何提供了JDBC驱动程序的数据库系统，从而完成对数据库的各种操作
(Java程序员只需面向这套接口编程即可)


JDBC API：是一系列接口，统一和规范了应用程序与数据库的连接，执行SQL语句，并得到返回结果等各类操作，相关类和接口在java.sql与javax.sql包中
DriverManager驱动管理类, Connection接口, Statement接口, PreparedStatement接口

DriverManager：getConnection(url,user,pwd) 获取到连接
Connection：createStatement创建Statement对象，preparedStatement(sql)生成预处理对象
Statement接口：executeUpdate(sql)执行dml语句，返回影响的行数；executeQuery(sql)执行查询，返回ResultSet对象；execute(sql)执行任意的sql，返回布尔值
PreparedStatement接口：executeUpdate, executeQuery(),execute(),setXxx()解决sql注入, setObject()
ResultSet结果集：next()下移一行，previous()上移一行，getXxx()返回对应列的值，getObject()返回对应的值，接收类型是Object



JDBC程序编写步骤：
1.注册驱动 - 加载Driver类
2.获取连接 - 得到Connection
3.执行增删改查 - 发送SQL语句给mysql执行
4.释放资源 - 关闭相关连接

(vscode 想创建连续的folder eg.a/b/c)
(在最下面的java projects中找到Referenced Libraries中加入想要创建libraries的jar包)

连接数据库的方式在JdbcConn，5种方式


Statement介绍：
1.Statement对象 用于执行静态sql语句并返回其生成的结果的对象
2.建立连接后，需对数据库进行访问，执行命名或sql语句，用：
(1)Statement[存在sql注入]
(2)PreparedStatement[预处理]
(3)CallableStatement[存储过程]
3.Statement对象执行sql语句，存在sql注入风险
4.sql注入是利用某些系统没有对用户输入的数据进行充分检查，而在用户输入数据中注入非法的sql语句或命令，恶意攻击数据库(eg. or 1=1 这种恒等肯定成立的东西)
5.要防范SQL注入，只需用PreparedStatement(从Statement扩展而来)，取代Statement就可以了

PreparedStatement执行中的sql语句的参数用?来表示

当需要成批插入或更新记录时，可采用java的批量更新机制。该机制允许多条语句一次性提交给数据库批量处理。通常情况下比单独提交处理更有效率。
JDBC的批量处理语句 包括这些方法：addBatch(),executeBatch(),clearBatch()
(只有在url对应的表后加上：?rewriteBatchedStatements=true，才是执行批量处理的)

(用Test junit的话，在debug console看输出)


数据库连接池：
传统获取Connection问题分析
1.传统JDBC数据库，连接使用DriverManager来获取，每次向数据库建立连接时都要将Connection加载到内存中，再验证ip地址，用户名和密码(0.05s-1s)
需要更多数据库连接，就向数据库要求一个，频繁进行数据库连接操作将占用很多系统资源，易造成服务器崩溃
2.每次连接，用完都得断开，如程序出现异常未能关闭，将导致数据库内存泄漏，最终导致重启数据库
3.传统获取连接的方式，不能控制创建的连接的数量，连接过多，也可能导致内存泄漏，mysql崩溃
4.可采用数据库连接池技术，解决传统开发的数据库连接问题(connection pool)

数据库连接池 介绍：
1.预先在缓冲池中放入一定数量的连接，需要建立连接时，只需从“缓冲池”中取一个，用完后再放回去
2.数据库连接池负责分配，管理和释放数据库连接，允许应用程序重复使用一个现有的数据库连接，而不是重新建立一个
3.当向连接池请求的连续数超过最大连接数量时，这些请求将被加入到等待队列

数据库连接池种类：
1.连接池用javax.sql.DataSource表示，DataSource只是个接口，该接口通常由第三方提供实现
2.
C3P0：数据库连接池速度较慢，稳定不错 (推荐)
DBCP：速度比C3P0快点，但不稳定
Proxool：能监控连接池状态，稳定性较C3P0差些
BoneCP：速度快
Druid(德鲁伊)：阿里提供的数据库连接池，集DBCP，C3P0，Proxool优点于一身 (最常使用的，最快最稳定的，最推荐！)


eg.对actor表操作，创建Java类Actor(JavaBean,PoJO,Domain)，一个Actor对象对应一条actor表记录，actor对象放入到ArrayList集合
解决了：如果集合connection是关联的，关闭了连接就不能使用结果集 的问题


Apache-DBUtils：
1.commons-dbutils是Apache组织提供的一个开源JDBC工具类，是对JDBC的封装，使用dbutils能极大简化jdbc编码的工作量。

DbUtils类
1.QueryRunner类：该类封装了SQL的执行，是线程安全的。可实现增删改查，批处理
2.使用QueryRunner类实现查询
3.ResultSetHandler接口：该接口用于处理java.sql.ResultSet，将数据转换成另一种形式

ArrayHandler：把结果集第一行数据转换成对象数组
ArrayListHandler：把结果集中的每一行数据都转换成数组，再放到list中
BeanHandler：把结果集第一行数据封装到一个对应的JavaBean实例中
BeanListHandler：把结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到list里
ColumnListHandler：把结果集中某一列的数据存放到list中
KeyedHandler(name)：把结果集的每一行数据都存放到Map里，再把这些map再存到一个map里，其key为指定的key
MapHandler：把结果集的第一行数据封装到一个map里，key是列名，value就是对应的值
MapListHandler：把结果集的每一行数据都封装到一个Map里，然后再存放到List

(DBUtils_USE里写了具体案例)

apache-dbutils + druid 简化了JDBC开发，但也有不足：
1.SQL语句太固定，不能通过参数传入，通用性不好，需改进
2.select操作，如果有返回值，返回类型不能固定，需要使用泛型
3.将来的表很多，业务需求复杂，不能通过一个Java类完成
4.引出 -> BasicDAO (各种类的DAO 都继承BasicDAO，每个DAO就放特有的操作)


DAO和增删改差通用方法-BasicDAO
1.DAO(Data Access Object 数据访问对象(访问数据的对象))
2.这样的通用类，称为BasicDAO，是专门和数据库交互的，即完成对数据库(表)的crud操作
3.在BasicDAO(最重要)的基础上，实现一张表，对应一个DAO，更好地完成功能 eg.Customer表 -> Customer.java类(javabean) -> CustomerDao.java

简单设计：utils工具类，domain(javabean)，dao存放XxxDao和BasicDAO，test写测试类

(可变形参 eg.public int update(String sql, Object... parameters){} 这个方法中的形参是可变个数的)

界面层->业务层(服务层)->DAO层->数据层

看到p856 6:50
全部学完，再push一遍
*/
