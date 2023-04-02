import java.util.ArrayList;

public class generic_01 {
    public static void main(String[] args) {
        ArrayList<Dog> arrayList = new ArrayList<Dog>(); //只能存Dog类型
        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("发财", 1));
        arrayList.add(new Dog("小黄", 5));
        // arrayList.add(new Cat("招财猫", 8)); //添加Cat就会报错
        
        for(Dog o:arrayList){ //遍历也能直接取Dog (不用Object然后向下转型了)
            System.out.println(o.getName()+" - "+o.getAge());
        }
        System.out.println("-----");

        //E具体的数据类型在定义Person对象的时候指定，即在编译期间，就确定E是什么类型
        Person<String> person = new Person<String>("mike");
        person.show();
        Person<Integer> person2 = new Person<Integer>(100);
        person2.show();

        
    }
}
class Person<E>{
    E s; //E表示s的数据类型 eg.int s;
    public Person(E s){ //E可以是参数类型
        this.s = s;
    }
    public E f(){ //E也可以是返回值类型
        return s;
    }
    public void show(){
        System.out.println(s.getClass());
    }
}
class Dog{
    private String name;
    private int age;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
class Cat{
    private String name;
    private int age;
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
/*
泛型
理解与好处：
1.编译时，检查添加的元素的类型，提高了安全性
2.减少了类型转换的次数，提高效率
3.不再提示编译警告

使用传统方法的问题分析：
1.不能对加入到集合ArrayList中的数据类型进行约束(不安全 eg.在Dog的ArrayList中，添加了一只Cat)
2.遍历的时候，需要进行类型转换，如果集合中的数据量较大，对效率有影响

泛型体验-用泛型解决问题
ArrayList<Dog> arrayList = new ArrayList<Dog>();



看到p557 泛型应用实例
*/
