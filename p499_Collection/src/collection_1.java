import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class collection_1 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        System.out.println("ArrayList：");
        // ArrayList arrayList = new ArrayList();
        // arrayList.add("jack");
        // arrayList.add("tom");
        List list = new ArrayList();
        list.add("jack"); //继承object的，随便放
        list.add(true); //继承object的，随便放
        list.add(0); //继承object的，随便放

        System.out.println(list);
        list.remove("jack");
        list.remove((Integer)0);//想删除0这个元素，而不是索引的话
        System.out.println(list);
        System.out.println(list.contains(true));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        // list.clear();
        ArrayList list2 = new ArrayList();
        list2.add("三国演义");
        // list2.add("红楼梦");
        System.out.println(list.addAll(list2));
        System.out.println("加了list2后的list = "+list);
        System.out.println(list.containsAll(list2)); //查找多个元素是否都存在
        list.removeAll(list2); //删除多个元素
        System.out.println(list);
        

        HashMap hashMap = new HashMap();
        hashMap.put("NO1", "北京");
        hashMap.put("NO2", "上海");

    }    
}
/*
集合：
可以动态保存任意多个对象，使用很方便
提供了一系列方便的操作对象的方法：add, remove, set, get等
使用集合，删除/添加新元素，简洁明了

集合分成：单列集合和双列集合
Collection接口的两个重要的子接口：List和Set的实现子类都是单列集合
Map接口的实现子类，是双列集合，存放K-V (Key和Value，键值对)

单列集合：
Vector, ArrayList, LinkedList implements List接口 (相当于也implements Collection)
TreeSet, HashSet(LinkedHashSet implements HashSet) implements Set接口 (相当于也implements Collection)
List, Set implements Collection
Collection implements Iterable

双列集合：
Properties extends Hashtable
LinkedHashMap extends HashMap, implements Map
Hashtable implements Map
HashMap implements Map (使用频率最高)
TreeMap implements Map

Collection接口遍历元素
方式1：使用Iterator (迭代器)(仅用于遍历集合，本身并不存放对象)
Iterator对象称为迭代器，主要用于遍历Collection集合中的元素
所有实现了Collection接口的集合类都有一个.iterator()方法，用于返回一个实现了Iterator接口的对象，即可以返回一个迭代器。
tips：调用iterator.next()方法前，必须调用iterator.hasNext()进行检测。
若没调用，并且下条记录无效，直接调用it.next()会抛出NoSuchElementException异常。

方式2：增强for


List：
1.集合类中元素有序(添加和取出顺序一致)，且可重复
2.每个元素都有其对应的顺序缩印，从0开始 (eg. list.get(3))
3.遍历方式：Iterator，赠钱for，普通for

ArrayList:
写完可以抄上，在array_vector_linkedlist.java里

*/

