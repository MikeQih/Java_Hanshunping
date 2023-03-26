import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class map {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1", "mike");
        map.put("no2", "david");//底层HashMap，无序存储
        map.put("no2","张三丰");//用新的值，替换原来key中的值
        map.put("no3", "lucas");
        map.put(null,null);
        map.put(null,"abc");
        map.put("no4",null);
        map.put("no5",null);


        System.out.println(map);
        System.out.println("get no1："+map.get("no1"));
        map.remove("no3"); //"lucas被remove了"
        System.out.println("remove no3 后："+map);
        System.out.println("map的size是："+map.size());
        System.out.println("判断map是否为空："+map.isEmpty());
        System.out.println("查找键是否存在 no7："+map.containsKey("no7"));
        // map.clear();
        // System.out.println("clear后的map："+map);
        System.out.println("---");

        System.out.println("源码分析：");
        Set set = map.entrySet();
        System.out.println(set.getClass());//HashMap$EntrySet，里面放了一个个Entry
        

        System.out.println("\n遍历：");
        //m1 第一组：先取出所有的key，通过key取出对应的value
        //遍历 m1.1 增强for
        Set keyset = map.keySet();
        for(Object obj: keyset){
            System.out.println("key的值是"+"-"+map.get(obj));
        }
        //遍历 m1.2：迭代器
        System.out.println("\nm2:");
        Iterator iterator = keyset.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println("key的值是"+"-"+map.get(next));
        }

        //第二组：把所有values取出 m2.1
        System.out.println();
        Collection values2 = map.values();
        //这里可以使用所有的Collections使用的遍历方法
        for(Object value:values2){
            System.out.println(value);
        }
        //m2.2
        System.out.println("\n迭代器:");
        Iterator iterator2 = values2.iterator();
        while(iterator2.hasNext()){
            Object value = iterator2.next();
            System.out.println(value);
        }

        //第三组：通过EntrySet来获取k-v m3
        Set entrySet = map.entrySet();
        System.out.println("\n使用EntrySet的for增强");
        //3.1 增强for
        for(Object entry: entrySet){
            //将Object类型的entry 转化为Map.Entry类型
            //因为EntrySet<Entry<K,V>>
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey()+"-"+m.getValue());
        }
        //3.2 迭代器
        Iterator iterator3 = entrySet.iterator();
        System.out.println("\n3.2 使用EntrySet中的迭代器：");
        while(iterator3.hasNext()){
            Object entry = iterator3.next();
            // System.out.println(entry);//HashMap$Node
            // 向下转型 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey()+"-"+m.getValue());
        }
        
        System.out.println();
        Set set2 = map.keySet();
        System.out.println(set2.getClass());
        Collection values = map.values();
        System.out.println(values.getClass());

        
    }
}
/*
Map:
1.Map用于保存具有映射关系的数据：Key-Value(双列元素)，与Collection并列存在。
2.Map中的key和value可以是任何类型的数据，会封装到HashMap$Node对象中
3.Map中的key不允许重复，原因与HashSet相同(见set.java笔记)
4.value可以重复(因为在不同的链表(key)中)
5.key和value都能存放null。但key为null只能有一个，value随便
6.常用String类作为Map的key
7.key和value间存在单向一对一关系，通过指定的key总能找到对应的value
8.一对k-v放在一个HashMap$Node中，Node就是HashMap里的内部类；又因为Node实现了Entry接口，有些书也说一对k-v就是一个Entry
9.添加相同的key就会覆盖原来的key-value，等同于修改(value会被替换，key不会)
10.与HashSet一样，不保证映射的顺序，因为底层是以hash表的方式来存储的。(jdk8的hashMap 底层 数组+链表+红黑树)
11.HashMap没有实现同步，因此是线程不安全的。（方法没有做同步互斥的操作，没有synchronized）

源码解读：
1.k-v最后是 HashMap$Node node = newNode(hash,key,value,null)
2.k-v为了方便程序员的遍历，还会创建EntrySet集合，该集合存放的元素类型：Entry，
而一个Entry对象就有k,v -> EntrySet<Entry<K,V>>（EntrySet中的对象其实就是Map.Entry，Entry其实就是Node的一个接口）
3.EntrySet中，虽然定义的类型是Map.Entry，但实际存放的还是HashMap$Node (因为 static class Node<K,V> 实现了 Map.Entry<K,V> 这个接口)
4.把HashMap$Node对象存放到EntrySet就方便遍历，因为Map.Entry提供了重要方法: K - getKey(); V - getValue();

常用方法：put, get, size, isEmpty, clear, containsKey

看到p537
19:28
*/
