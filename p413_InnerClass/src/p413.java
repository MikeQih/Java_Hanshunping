public class p413 {
    public static void main(String[] args) {
        // Outer outer = new Outer();
        // outer.m1();
        Outer4 outer4 = new Outer4();
        outer4.method();

        Outer03 o3 = new Outer03();
        o3.t1();

        Outer03.inner03 inner3 = o3.new inner03();//m1 调用成员内部类
        inner3.say();

        Outer03.inner03 inner03Instance = o3.getInner03Instance();//m2 返回一个inner03的实例
        inner03Instance.say();

        Outer06 outer06 = new Outer06();
        outer06.m6();

        Outer06.Inner06 n = new Outer06.Inner06();//m1 调用静态内部类
        n.say();

        Outer06.Inner06 inner06 = outer06.getInner06();//m2 创建一个inner06的实例
        inner06.say();

        // Outer06.Inner06 inner06_ = Outer06.getInner06_();//m2 创建的静态的inner06实例
        // inner06_.say();

        
    }
}
class Outer06{
    private int n2=10;
    private static String name="张三";
    static class Inner06 {//静态内部类
        public String name = "MikeQi";
        public void say(){
            System.out.println("name是："+ name+" 外部类name是："+Outer06.name);
        }
    }
    public void m6(){
        Inner06 inner06 = new Inner06();
        inner06.say();
    }
    public Inner06 getInner06(){
        return new Inner06();
    }

    public static Inner06 getInner06_(){
        return new Inner06();
    }
}

class Outer03{
    private int n1=10;
    public class inner03 {//成员内部类
        private int n1=20;
        public void say(){
            System.out.println("name "+ n1+" 外部类的n1 = "+Outer03.this.n1);
        }
    }
    public void t1(){
        inner03 i3 = new inner03();
        i3.say();
    }

    public inner03 getInner03Instance(){//返回一个inner03的实例
        return new inner03();
    }
}

    

class Outer{
    private int n1 = 100;//属性
    public Outer(){
        
    }
    public Outer(int n1){//构造器
        this.n1=n1;
    }
    public void m2(){
        System.out.println("Outer m2()");
    }
    public void m1(){//方法
        class Inner2{//局部内部类
            private int n1 = 80;
            public void f1(){
                System.out.println("内部类n1:"+n1+",外部类n1:"+Outer.this.n1);//谁调用的m1，Outer.this就是谁
                m2();
            }
        }
        Inner2 inner2 = new Inner2();
        inner2.f1();
    }
    {//代码块
        System.out.println("代码块");
    }
    class Inner{//内部类，在Outer类的内部

    }
}
class Outer4{
    private int n1=10;
    public void method(){
        A tiger = new A() {//基于接口的 匿名内部类
            /*
            tiger的编译类型：A，运行类型：匿名内部类 XXXX => 系统分配的Outer4$1
            jdk底层创建了Outer4$1匿名内部类后，立即创建了Outer4$1实例，并把地址返回给tiger
            匿名内部类使用一次，就不能再使用了（对象tiger 可以反复使用）
            */
            @Override
            public void cry() {
                System.out.println("老虎叫唤");
            }
            
        };
        tiger.cry();

        Father father = new Father("Jack"){//基于类的 匿名内部类
            /*
            编译类型：Father；运行类型：Outer4$2
            */
            @Override
            public void test(){
                System.out.println("匿名内部类重写了test方法");
            }
        };
        father.test();

        Animal animal = new Animal() {
            @Override
            void eat(){
                System.out.println("小狗吃骨头");
            }
        };
        animal.eat();

    }  
}
interface A{
    public abstract void cry();

}
class Father{
    public Father(String name){}
    public void test(){}
}
abstract class Animal{
    abstract void eat();
}

/* 15:21
类的五大成员：属性，方法，构造器，代码块，内部类

内部类有四种：
定义在外部类的局部位置上（比如方法内）：
1.局部内部类（有类名）
不能添加访问修饰符，但可以用final修饰；作用域仅在定义它的方法或代码块中

2.匿名内部类（没有类名）
本质是类，同时还是一个对象；简化开发，匿名内部类使用一次，就不能使用了；
外部类和匿名内部类成员重名时，匿名内部类访问默认就近原则，如果想访问外部类成员时，则可以使用 外部类名.this.成员 访问
语法：new 类或接口 (参数列表){类体};

定义在外部类的成员位置上：
1.成员内部类（无static）
定义在外部类的成员位置上

2.静态内部类（有static）
也是定义在外部类的成员位置上，有static修饰

*/
