public class practice {
    public static void main(String[] args) {
        // //jdk5之前 手动
        // int n1=100;
        // // Integer integer = new Integer(n1); //手动装箱 int->Integer m1
        // Integer integer1 = Integer.valueOf(n1); //m2
        // int i = integer1.intValue(); //手动拆箱 Integer->int

        // //jdk5之后 自动
        // int n2 = 100;
        // Integer integer2 = n2; //自动装箱 底层使用的还是: Integer.valueOf(n2)
        // int n3 = integer2; //自动拆箱 底层使用的还是: integer.intValue()

        // Double d = 100d;
        // System.out.println(d);

        //包装类(Integer)->String
        Integer i = 100; //自动装箱
        String str1 = i+""; //m1
        String str2 = i.toString(i); //m2
        String str3 = String.valueOf(i); //m2

        //String->包装类(Integer)
        String str4 = "12345";
        Integer i2 = Integer.parseInt(str4); //m1 使用到自动装箱
        // Integer i3 = new Integer(str4); //m2 构造器

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.toUpperCase('a'));
    }
}
/*
基本类型与其包装类(Wrapper)：
boolean Boolean (Boolean extends Object类, implements Serializable, Comparable)
char Character (Character extends Object类, implements Serializable, Comparable)
byte Byte (以下六个包装类 extends Number类, implements Comparable; Number类 extends Object, implements Serializable)
int Integer
short Short
long Long
float Float
double Double

包装类和基本数据类型的转换：
装箱：基本类型->包装类型
拆箱：包装类型->基本类型

jdk5前是手动装箱和拆箱
jdk5后就可以自动装和拆

看到p464 Integer创建机制
*/