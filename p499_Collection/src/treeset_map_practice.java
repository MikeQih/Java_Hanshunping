import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

@SuppressWarnings({"all"})
public class treeset_map_practice {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        // TreeSet treeSet = new TreeSet();
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // return ((String)o1).compareTo((String)o2); //根据字符串的大小排序 从小到大
                return (((String)o1).length()) -  (((String)o2).length()); //根据长度排序 小到大
            }
        });
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("sp");
        treeSet.add("a"); //字符串能添加成功，因为字符串本身就实现了Comparable接口(implements Comparable)
        // treeSet.add(new P()); //ClassCastException 如果不重写compareTo
        System.out.println("treeSet = "+treeSet);


        // TreeMap treeMap = new TreeMap(); //默认无参时 按首字母升序排序
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // return ((String)o2).compareTo((String)o1); //字符串大到小
                return ((String)o2).length() - ((String)o1).length(); //长度大到小
            }
            
        });
        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("kristina", "克里斯提娜");
        treeMap.put("smith", "史密斯");
        treeMap.put("smith", "史密斯2");
        treeMap.put("ddd", "史密斯3"); //原来tom的值被更新成史密斯3 (长度排序)
        System.out.println("treeMap = "+treeMap);
    }
}
// class P implements Comparable{

//     @Override
//     public int compareTo(Object o) {
//         return 0;
//     }
    
// }
/*
TreeSet
1.当使用无参构造器，创建TreeSet时，仍然是无序的
(2.希望添加的元素，按照字符串大小/长度等进行排序)
3.使用TreeSet提供的构造器，可以传入一个比较器(匿名内部类)，并指定排序规则
*/
