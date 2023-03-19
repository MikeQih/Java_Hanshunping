import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class set {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Set set = new HashSet(); //Set接口的实现类HashSet
        set.add("mike");
        set.add("lucas");
        set.add("david");
        set.add("marin");
        set.add("samuel");
        set.add(null);
        set.add(null);
        // System.out.println(set.add(null)); //false
        System.out.println(set);

        Iterator iterator = set.iterator();
        System.out.println("---使用迭代器---");
        while(iterator.hasNext()){
            System.out.println(iterator.next());//迭代器的第一个值是什么？
        }

        set.remove(null);
        System.out.println("---增强for---");
        for(Object o:set){
            System.out.println(o);
        }

        System.out.println("-----");
        set = new HashSet<>();
        set.add("dahuang");
        set.add("dahuang");
        set.add(new Dog("wangwang"));
        set.add(new Dog("wangwang"));
        set.add(new String("mike"));
        set.add(new String("mike")); //加不进去
        System.out.println(set);

        System.out.println("-----");
        Node[] table = new Node[16];
        System.out.println("table = "+table);

        Node john = new Node("john",null);
        table[2] = john;
        Node jack = new Node("jack",null);
        john.next = jack;
        Node rose = new Node("rose",null);
        jack.next = rose;
        System.out.println(table[2].next.item);

        Node lucy = new Node("lucy",null);
        table[3] = lucy;
        System.out.println(table);





    }
}
class Node{
    Object item; //存放数据
    Node next; //指向下一个节点
    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
    
}
class Dog{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog [name=" + name + "]";
    }
    
    
}
/*
Set
HashSet, TreeSet implements Set
1. 无序 (添加和取出的顺序不一致)，没有索引 (取出的顺序虽然不是添加的顺序，但也是固定的)
2. 不允许重复的元素，所以最多只包含一个null
3. 实现的子类很多(eg. HashSet, TreeSet...)

遍历：
方式1：迭代器
方式2：增强for (set接口对象，不能通过索引来获取。没有get方法，普通for循环用不了)

HashSet:
1.HashSet实现了Set接口
2.HashSet实际上是HashMap (HashSet底层是HashMap，HashMap底层是(数组+链表+红黑树))
3.可以存放null，但只能有一个null
4.HashSet不保证元素是有序的，取决于hash后，再确定索引的结果。(即不保证存放元素的顺序和取出顺序一致)
5.不能有重复的元素/对象

看到p521 HashSet扩容机制
*/
