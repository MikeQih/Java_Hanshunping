import java.util.ArrayList;
import java.util.List;

public class Annotation {
    @SuppressWarnings({"rawtypes","unchecked","unused"}) //all可以抑制所有警告，还有更多
    public static void main(String[] args) {
        Father f = new Father();
        Son s = new Son();
        s.fly();

        A a = new A();
        a.hi();

        List list = new ArrayList();//rawtypes
        list.add("Jack");//unchecked
        list.add("Mike");
        list.add("Lucas");
        int i;
        System.out.println(list.get(1));
    }
    
}
class Father{
    public void fly(){
        
        System.out.println("父类飞");
    }
    
}
class Son extends Father{
    @Override
    public void fly(){
        System.out.println("子类飞");
    }
}

class A{
    private int a = 10;
    @Deprecated
    public void hi(){
        System.out.println("hi");
    }
}
/*
注解(Annotation)也被称为元数据(MetaData),用于修饰解释 包类，方法，属性，构造器，局部变量等数据信息。
和注释一样，注解不影响程序逻辑， 但注解可以被编译或运行，相当于嵌入在代码中的补充信息
三个基本的annotation:
1.@Override：限定某个方法，重写父类的方法，该注解只能用于方法
如果发现@interface，表示一个注解类

2.@Deprecated：用于表示/修饰某个程序元素（类，方法等）已过时
即不再推荐使用，但是仍然可以使用
可以修饰：方法，类，字段，包，参数 等
作用：可以做到新旧版本的兼容和过渡

3.@SuppressWarnings：抑制编译器警告
作用范围和放置的位置相关。通常放置在具体的语句，方法，类
该注解类有数组 String[] values() 设置一个数组eg.({"rawtypes","unchecked","unused"})


修饰注解的注解，称为元注解 
元注解种类：
1.Retention 指定注解的作用范围，三种：SOURCE, CLASS, RUNTIME
RetentionPolicy.SOURCE：编译器使用后，丢弃这种策略的注释 （时间最短）
RetentionPolicy.CLASS：编译器把注解记录在class文件中，当运行Java程序时，JVM不会保留注释。（默认）
RetentionPolicy.RUNTIME：编译器将把注解记录在class文件中，运行java程序时，JVM会保留注释，程序可以通过反射获得该注释

2.Target 指定注解可以在哪些地方使用
eg.CONSTRUCTOR, FIELD, METHOD...
eg.@Target(ElementType.METHOD)，说明只能修饰方法


3.Documented 指定该注解是否会在javacdoc体现
被该元Annotation修饰的annotation类将被javadoc工具提取成文档，即在生成该文档时，可以看到该注释 
eg.一个Deprecated注解@Documented，则javadoc会看到Deprecated

4.Inherited 子类会继承父类的注解
如果某个类使用了被@Inherited修饰的Annotation，则其子类将自动具有该注释
*/
