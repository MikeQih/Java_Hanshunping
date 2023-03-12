import java.util.Arrays;
import java.util.Comparator;

public class array_exercise {
    public static void main(String[] args) {
        book[] books = new book[4];
        books[0] = new book("红楼梦", 100);
        books[1] = new book("金瓶梅", 90);
        books[2] = new book("青年文摘", 6);
        books[3] = new book("Java从入门到放弃", 300);
        // Arrays.sort(books, new Comparator() {
        //     @Override
        //     public int compare(Object o1, Object o2) {
        //         book book1 = (book)o1;
        //         book book2 = (book)o2;
        //         return book2.getPrice()-book1.getPrice(); //价格从大到小排序
        //     }
        // });

        // Arrays.sort(books, new Comparator() {
        //     @Override
        //     public int compare(Object o1, Object o2) {
        //         book book1 = (book)o1;
        //         book book2 = (book)o2;
        //         double priceVal = book2.getPrice()-book1.getPrice();
        //         if (priceVal>0){ 
        //             return -1; //价格从小到大排序
        //         }
        //         else if (priceVal<0){
        //             return 1;
        //         }
        //         else{
        //             return 0;
        //         }
        //     }
        // });

        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                book book1 = (book)o1;
                book book2 = (book)o2;
                double priceVal = book2.getName().length()-book1.getName().length();
                if (priceVal>0){ 
                    return 1; //书名长度从大到小排序
                }
                else if (priceVal<0){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        });

        // for(int i=0;i<books.length;i++){
        //     System.out.println(books[i].getName()+" "+books[i].getPrice());
            // System.out.println(Arrays.toString(books));
        // }
        System.out.println(Arrays.toString(books));

    }
}
/*

*/
