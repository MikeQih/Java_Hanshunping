import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.InputMap;
class Father{
    public void method() throws IOException{
        
    }
}
class Son extends Father{//子类抛出的异常要么一致，要么为父类的异常类型
    @Override
    public void method() throws FileNotFoundException{
        
    }
}
//自定义一个异常
class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
    static void m(){
        throw new CustomException("制造异常");
    }
}
public class test {
    public static int method(){
        int i=1;
        try{
            System.out.println(i/0);
            return 50;
        }catch(Exception e){
            // i++;
            return 30;
        }finally{
            i+=1;
            System.out.println("i= "+i);
            // return i;
        }
    }
    public void f2() throws FileNotFoundException{//也可以throws Exception(父类)
        FileInputStream fis = new FileInputStream("aaa.txt");
 
    }
    public static void main(String[] args) {

        // int age = 900;
        // if(!(age>=18 && age<=120)){
        //     //通过构造器设置信息
        //     throw new CustomException("年龄需要在18-120之间");
        // }
        // System.out.println("你的年龄范围正确");

        try{
            CustomException.m();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("11");
        // System.out.println("输出为："+method());
        // System.out.println();
        // int a=0;
        // int b=10;
        // try{
        //     int c = b/a;
        // }
        // catch(Exception e){
        //     // e.printStackTrace();
        //     System.out.println(e.getMessage());//输出异常信息
        // }
        // finally{
        //     System.out.println("来了老弟");
        // }

        // //ArithmeticException 抛出异常后，程序中断，不再执行接下来的内容；这样不好，不应该因为一个不算致命的问题，导致整个程序崩溃
        // System.out.println("程序继续运行");

        // try{
        //     System.out.println("mike");
        // }
        // catch(Exception e){
        //     System.out.println("有个异常");
        // }

        // Scanner num = new Scanner(System.in);
        // int number=0;
        // while(true){
        //     System.out.println("请输入一个整数：");
        //     String input = num.next();
        //     try{
        //         number = Integer.parseInt(input);
        //         break;
        //     }catch(NumberFormatException e){
        //         System.out.println("你输入的不是一个整数");
        //         // continue;
        //     }
        // }
        // System.out.println("你输入的值为：" +number);
        // num.close();
        
    }
}
/*
Java语言中，程序执行中发生的不正常的情况称为“异常”，语法错误和逻辑错误不算。

Throwable 执行过程中发生的异常，(implements Serializable, extends Object,) 分为两大类（两个子类）：
1.Error错误：Java虚拟机无法解决的严重问题 eg.JVM系统文件错误，资源耗尽等 例如：StackOverflowError栈溢出，和OOM(OutOfMemoryError)
2.Exception：其他因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码处理。eg.空指针访问，试图读取不存在的文件，网络连接中断...

Exception 也分为两大类(两个子类)：
1. RuntimeException 运行时异常(编译器检测不出) eg.5/0(ArithmeticException), NullPointerException, ArrayIndexOutOfBoundsException, ClassCastException, NumberFormatException...
2. IOException 编译时异常 eg.FileNotFoundException, ClassNotFoundException...

RuntimeException：
NullPointerException: 程序在需要对象的地方使用null时，抛出该异常 eg. String name=null; sout(name.length())
ArithmeticException: 数学运算异常 eg. int number/0
ArrayIndexOutOfBoundsException: 数组下标越界异常 (索引为负或>=数组长度)
ClassCastException: 试图将对象强制转换为不是实例的子类时 eg.B和C都是A的子类，把指向B的对象强制转换成C (B和C无关，不能强制转换)
NumberFormatException： 数字格式不正确异常，程序试图将字符串转换成一种数值类型，但该字符串不能转换成对应格式 eg. String name = "mike"; int num = Integer.parseInt(name);

编译时异常 IOException：
(IOException 操作文件时，发生的异常)
SQLException 操作数据库时，查询表可能发生异常
FileNotFoundException 不存在的文件
ClassNotFoundException 不存在的类
EOFException 操作文件，到文件末尾，发生的异常
IllegalStateException 参数异常

异常处理的方式：
1. try{}catch(){}finally{}
程序员在代码中捕获发生的异常，自行处理。
要使用多个catch捕获异常的话，子类异常写在前，父类异常在后 (eg. Exception写在NullPointerException后面)
finally{} 可加可不加: 不管有无异常，finally中的代码都会执行，通常用来释放资源 eg.关闭文件
try{}finally{}也可以不加catch(){}使用用，相当于没捕获异常，因此程序会直接退出。应用场景：不管是否发生异常，都必须执行某个业务逻辑
catch中就算有return，也会执行finally的代码。如果finally中没有return，catch中有，那么执行完finally的代码，还要执行catch的return

2.throws 如果程序员没显示处理异常，默认使用throws
将异常抛出，交给调用者处理(父类)，最顶级(最上面的父类)的处理者就是JVM（处理方式为输出异常信息，退出程序）
throws后的异常类型可以是方法中产生的异常类型，也可以是其父类异常类型(eg. Exception)
子类抛出的异常要么与父类异常类型一致，要么为父类异常类型的子类型
throws关键字后可以是异常列表，可以抛出多个异常(","连接)

//自定义一个异常，一般做成运行时异常，好处是可以使用默认处理机制 eg.
class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}

throws 意义：异常处理的一种方式 位置：方法声明处 后面跟的东西：异常类型
throw 意义：手动生成异常对象的关键字 位置：方法体中 后面跟的东西：异常对象

看到p457 异常课后作业1
*/
