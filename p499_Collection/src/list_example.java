import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class list_example {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        // List list = new ArrayList<>(); //这三种都可以
        // List list = new Vector<>();
        List list = new LinkedList<>();
        list.add(new Book("孙子兵法", "孙武", 100));
        list.add(new Book("水浒传", "施耐庵", 50));
        list.add(new Book("西游记", "吴承恩", 80));

        // list.sort(new Comparator() {//method 1
        //     @Override
        //     public int compare(Object o1, Object o2) {
        //         Book book1 = (Book)o1;
        //         Book book2 = (Book)o2;
        //         return (int)(book2.getPrice()-book1.getPrice()); //从大到小排序
        //     }   
        // });
        
        sort(list);//从小到大 m2
        for(Object b: list){
            System.out.println(b);
        }

    }
    public static void sort(List list){
        int listSize = list.size();
        for(int i=0;i<listSize-1;i++){
            for(int j=0;j<listSize-1-i;j++){
                Book book1 = (Book)list.get(j);
                Book book2 = (Book)list.get(j+1);
                if(book1.getPrice()>book2.getPrice()){//从大到小
                    list.set(j, book2);
                    list.set(j+1, book1);
                }
            }
        }
    }
}
class Book{
    private String name;
    private String author;
    private double price;
    
    @Override
    public String toString() {
        return "Book [name=" + name + ", price=" + price + ", author=" + author + "]";
    }

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
    
    
}
/*

*/