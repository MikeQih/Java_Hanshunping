import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
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

        HashSet hashSet = new HashSet();
        for(int i=0;i<=8;i++){
            hashSet.add(new A(i)); //保证hashCode相同，但是.equals()不同
        }
        System.out.println("hashSet = "+hashSet.getClass());
        hashSet.add(new A(13));
        System.out.println("hashSet = "+hashSet.getClass()); //怎样看树化后的class类型，HashMap$TreeNode?

        System.out.println("\n---example---");
        HashSet hashSet2 = new HashSet();
        hashSet2.add(new Employment("mike",18));
        hashSet2.add(new Employment("david",20));
        hashSet2.add(new Employment("david",20));
        hashSet2.add(new Employment("lucas",20));
        System.out.println(hashSet2);

        System.out.println();
        HashSet hashSet3 = new HashSet(); //name和MyDate相同就是同一个人，就不能加进hashSet3
        hashSet3.add((new Employee2("mike",50000,new MyDate(2003, 10, 14))));
        hashSet3.add((new Employee2("mike",40000,new MyDate(2002, 10, 14))));
        hashSet3.add((new Employee2("mike",40000,new MyDate(2003, 10, 14))));
        for(Object o : hashSet3){
            System.out.println(o);
        }

        System.out.println("---LinkedHashSet---"); //有序的
        Set set2 = new LinkedHashSet<>();
        set2.add(new String("AA"));
        set2.add(455);
        set2.add(455);
        set2.add(new Employment("mike", 19));
        set2.add(new Employment("mike", 19));

        System.out.println(set2); //LinkedHashSet 加入和取出元素/数据的顺序一致



    }
}
class Employee2{
    private String name;
    private int sal;
    private MyDate mydate;
    public Employee2(String name, int sal, MyDate mydate) {
        this.name = name;
        this.sal = sal;
        this.mydate = mydate;
    }
    @Override
    public String toString() {
        return "Employee [name=" + name + ", sal=" + sal + ", mydate=" + mydate + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((mydate == null) ? 0 : mydate.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee2 other = (Employee2) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (mydate == null) {
            if (other.mydate != null)
                return false;
        } else if (!mydate.equals(other.mydate))
            return false;
        return true;
    }
    

}
class MyDate{
    private int year;
    private int month;
    private int day;
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + year;
        result = prime * result + month;
        result = prime * result + day;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyDate other = (MyDate) obj;
        if (year != other.year)
            return false;
        if (month != other.month)
            return false;
        if (day != other.day)
            return false;
        return true;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
    }
    
}

class Employment{
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
        return "Employment [name=" + name + ", age=" + age + "]";
    }
    public Employment(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }
    @Override
    public boolean equals(Object obj) {//如果name和age的值相同，使用equals时，返回true
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employment other = (Employment) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }
  
}

class A{
    private int n;
    
    public A(int n) {
        this.n = n;
    }

    @Override
    public int hashCode(){
        return 100;
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
5.不能有重复的元素/对象:

5.不能有重复的元素/对象:
a.HashSet底层是HashMap
b.添加一个元素时，先得到Hash值，然后会转成索引值
c.看存储数据表table中，判断该索引值是否已经存有元素
d.如果没有，直接加入
e.如果有，调用equals比较(程序员决定比较的内容)：如果相同，放弃添加；如果不同，添加到最后
f.在Java8中，如果一条链表的元素个数到达TREEIFY_THRESHOLD(默认是8)，并且table的大小>=MIN_TREEIFY_THRESHOLD(默认64)，就会进行树化(红黑树) （？？红黑树以后了解
(Hash值不是hash.Code，hash.Code^(h>>>16)处理过后才是哈希值，右移> 就是 /2)

HashSet底层机制(扩容，红黑树机制)
1.HashSet底层是HashMap，第一次添加时，table数组扩容到16，
临界值(threshold) = 16 * 0.75 (加载因子, loadFactor) = 12
2.如果table数组使用到了临界值12，就扩容2倍，16*2=32。新的临界值就是32*0.75=24，以此类推
3.在Java8中，如果一条链表的元素个数到达TREEIFY_THRESHOLD(默认=8)，并且table的大小>=MIN_TREEIFY_THRESHOLD(默认64)，就会进行树化(红黑树)，否则仍然采用数组扩容机制

LinkedHashSet：
1.是HashSet的子类
2.底层是一个LinkedHashMap(HashMap的子类)，维护了一个数组+双向链表
3.根据元素的hashCode值决定元素的存储位置，同时使用链表维护元素的次序，使得元素看起来是以插入顺序保存的 (有序的)
(也就是加入和取出元素/数据的顺序一致)
4.不允许添加重复元素


看到p529 19:26 抄/看下源码分析
*/
