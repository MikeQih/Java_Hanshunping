import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Date_1 {
    public static void main(String[] args) throws ParseException {
        Date d1 = new Date(); //获取当前系统时间
        System.out.println(d1); 

        Date dd = new Date(1000); //从1970-1-1
        //通过指定毫秒，得到时间
        System.out.println("dd = "+dd);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String format = sdf.format(d1);//将日期转换为指定的字符串，这里的格式使用的字母是规定的
        System.out.println(format);

        //把一个格式化的String 转成相应的 Date
        String s = "2023年03月08日 07:23:06 周三";

        //把String转换成Date时，使用的sdf格式需要和给的String格式相同，否则会抛出转换异常??？(那该怎么写)
        Date parse = sdf.parse(s); //有异常，所以在main方法后抛出
        System.out.println("parse: "+parse);
        System.out.println();

        Calendar c = Calendar.getInstance();
        System.out.println(c);
        System.out.println("年："+(c.get(Calendar.YEAR)));
        System.out.println("月："+(c.get(Calendar.MONTH)+1));//月份是从0开始的
        System.out.println("日："+c.get(Calendar.DAY_OF_MONTH));
        System.out.println("时："+c.get(Calendar.HOUR));
        System.out.println("24小时制："+c.get(Calendar.HOUR_OF_DAY));
        System.out.println("分："+c.get(Calendar.MINUTE));
        System.out.println("秒："+c.get(Calendar.SECOND)+"\n");

        /*
        第三代日期：jdk8加入的
        */
        System.out.println("第三代日期：");
        LocalDateTime ldt = LocalDateTime.now(); //LocalDate.now() 和 LocalTime.now()的结合
        System.out.println(ldt);
        System.out.println("年："+ldt.getYear());
        System.out.println("月："+ldt.getMonth());
        System.out.println("月(getMonthValue)："+ldt.getMonthValue());
        System.out.println("日："+ldt.getMonth());
        System.out.println("分："+ldt.getMinute());
        System.out.println("秒："+ldt.getSecond());

        LocalDate now = LocalDate.now(); //可获取到年月日
        LocalTime now2 = LocalTime.now(); //可获取到时分秒
        System.out.println();

        //使用DateTimeFormatter 对象来进行格式化
        LocalDateTime ldt2 = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH小时mm分种ss秒");
        String format2 = dateTimeFormatter.format(ldt2);
        System.out.println("ldt2 现在的时间 是："+format2+"\n");

        //通过 静态方法now() 获取表示当前时间戳的对象
        Instant now3 = Instant.now();
        System.out.println("instant:"+now3);
        //from可以把Instant转成Date，date的toInstant()可以把date转成Instant对象
        Date date = Date.from(now3);
        System.out.println(date);

        //使用plus minus方法可以对当前时间加或者减
        LocalDateTime localDateTime = ldt2.plusDays(890);//也能plusYear()，plusMonth()
        System.out.println("890天后："+dateTimeFormatter.format(localDateTime));
        //看3456min前的时间
        LocalDateTime localDateTime2 = ldt2.minusMinutes(3456);
        System.out.println("3456min前："+dateTimeFormatter.format(localDateTime2));

    }
}
/*
Date extends Object, implements Cloneable, Comparable, Serializable
Data使用 import java.util.Date;

Calendar类 extends Object, implements Serializable, Cloneable, Comparable
Calendar是一个抽象类，并且构造器是private
可以通过getInstance()来获取实例
提供大量方法和字段给程序员
Calendar没有提供对应的格式化的类，因此需要程序员自己组合来输出(灵活)

java.util.Date类的大多数方法 在JDK 1.1中引入Calendar类之后被弃用了，而Calendar也存在的问题是：
可变性：像日期，时间这样的类应该是不可变的
偏移性：Date中的年份是从1900开始的，月份从0开始
格式化：格式化只对Date有用，Calendar则不行
此外，也不是线程安全的；不能处理闰秒等(每隔两天，多出1s)

第三代日期类：jdk8之后
常见方法：1.LocalDate(日期，年月日) 2.LocalTime(时分秒) 3.LocalDateTime(年月日时分秒)

DateTimeFormatter定制

*/
