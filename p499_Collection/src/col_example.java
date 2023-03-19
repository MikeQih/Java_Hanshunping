import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class col_example {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col= new ArrayList();
        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));
        // System.out.println(col);

        // 现在希望遍历集合col集合：
        // 1.得到col对应的迭代器
        Iterator iterator = col.iterator();
        //2.使用while循环遍历
        while(iterator.hasNext()){
            Object obj = iterator.next(); //obj的编译类型是Object，运行类型取决于存放的是什么对象 (command+j 打开/关闭terminal)
            System.out.println("obj = "+obj);
        }
        // 3.当退出while循环时，iterator迭代器指向最后的元素
        // 4.如果希望再次遍历，需要重制迭代器
        // System.out.println("第二次输出(遍历)：");
        // iterator = col.iterator();
        // System.out.println(iterator.next());

        //增强for 底层仍然是迭代器 (简化版的迭代器遍历)
        // System.out.println();
        // for(Object book:col){
        //     System.out.println("book: "+book);
        // }

        System.out.println();
        List list = new ArrayList();
        list.add(new Dog("大黄",20));
        list.add(new Dog("小汪",10));
        list.add(new Dog("小黄",10));

        for(Object dog : list){
            System.out.println("dog = "+dog);
        }
        Iterator iterator2 = list.iterator();
        System.out.println("迭代器编译结果：");
        int cnt=0;
        while(iterator2.hasNext()){
            Object dog = iterator2.next();
            System.out.println("11 "+dog);
            // System.out.println(2);
            // System.out.println("22 "+iterator2.next()); //为啥输出没有两遍小汪，这个next到底咋回事
            cnt++;
        }
        System.out.println(cnt);

        

    }
}
class Dog{
    private String name;
    private int age;
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
    @Override
    public String toString() {
        return "Dog [name=" + name + ", age=" + age + "]";
    }
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    
}
class Book{
    private String name;
    private String author;
    private double price;
    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Book [name=" + name + ", author=" + author + ", price=" + price + "]";
    }
    
    

}
