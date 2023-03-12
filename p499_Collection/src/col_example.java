import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
