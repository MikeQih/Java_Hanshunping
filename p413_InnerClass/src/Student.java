public class Student {
    public static void main(String[] args) {
        Outer5 outer5 = new Outer5();
        outer5.f1();
    }
    
}

class Outer5{
    private int n1 = 99;
    public void f1(){
        Person p = new Person(){
            @Override
            public void hi(){
                System.out.println("匿名内部类重写的hi()");
            }
        };
        p.hi(); //动态绑定，运行类型是 Outer5$1

        //也可以直接调用，匿名内部类本身也是返回对象
        new Person(){
            @Override
            public void hi(){
                System.out.println("匿名内部类重写的hi() 哈哈哈");
            }
            @Override
            public void ok(String str){
                super.ok(str);
            }
        }.ok("Jack"); 
    
    }
}
class Person{
    public void hi(){
        System.out.println("person hi()");
    }
    public void ok(String str){
        System.out.println("Person ok(): "+str);
    }
}