import java.beans.Transient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class arraylist_vector_linkedlist {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        arrayList.add("jack");
        System.out.println(arrayList);

        
        Vector vector = new Vector();
        for(int i=0;i<10;i++){
            vector.add(i);
        }
        System.out.println(vector);


        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node hsp = new Node("hsp");

        //三个节点，模拟一个简单的双向链表
        //jack->tom->hsp
        jack.next = tom;
        tom.next = hsp;
        //hsp->tom->jack
        hsp.pre = tom;
        tom.pre = jack;
        Node first = jack;
        Node last = hsp;
        while(first!=null){//从头到尾遍历
            System.out.println(first);
            first = first.next;
        }
        System.out.println("-----");
        while(last!=null){//从尾到头遍历
            System.out.println(last);
            last = last.pre;
        }
        //给链表添加/删除对象
        System.out.println("-----");
        Node david = new Node("david");
        david.next = tom;
        david.pre = jack;
        tom.pre = david;
        jack.next = david;
        first = jack; //让first再指向第一个
        while(first!=null){//头到尾
            System.out.println(first);
            first = first.next;
        }
        System.out.println("-----");
        last = hsp;
        while(last!=null){//尾到头
            System.out.println(last);
            last = last.pre;
        }

        System.out.println("-----");
        LinkedList linkedList = new LinkedList();//first, last都是null
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.remove(); //默认删除第一个节点
        linkedList.set(1, 100); //修改节点
        System.out.println(linkedList);
        //因为LinkedList实现了List接口，遍历方式可用iterator，增强for和for
        // Iterator iterator = linkedList.iterator();
        // while(iterator.hasNext()){
        //     System.out.println(iterator.next());//迭代器的第一个值是什么？
        // }
        // for(Object o: linkedList){
        //     System.out.println(o);
        // }

    }
}
class Node{
    public Object item; //真正存放数据
    public Node next;
    public Node pre;
    public Node(Object name){
        this.item = name;
    }
    public String toString(){
        return "Node name= "+item;
    }
    
}


/*
ArrayList 可以加入null，并且是多个。
由数组实现存储
ArrayList基本等同于Vector，除了 ArrayList是线程不安全的，源码的add方法前没有 synchronized
但是执行效率高(改和查的效率高，因为通过索引直接定位；增删的效率低，数组扩容)，在多线程情况下，不建议使用ArrayList

ArrayList维护了一个Object类型的数组，elementData (transient Object[] elementData;) //transient表示该属性不会被序列化
1. 当创建ArrayList对象时，如果使用的是无参构造器，则初始elementData容量为0,
第一次添加，则扩容elementData为10，如需再次扩容，则扩容elementData为1.5倍。(扩容使用的是Arrays.copyof())
2. 如果使用的指定大小的构造器，初始elementData容量为指定大小，如需扩容，则直接扩容为1.5倍
(如果是有参构造：1.5倍；如果是无参：初始容量为0，第一次10，从第二次开始按1.5倍扩)

Vector extends AbstractList<E>, implements List<E>, RandomAccess, Cloneable, Serializable
底层是一个对象数组，protected Object[] elementData;
Vector是线程同步的，即线程安全，操作方法都带有synchronized
在开发中，需要线程同步安全时，使用Vector(安全，效率不高)
(无参：默认10，从第二次开始按2倍扩；指定大小的话，每次直接按2倍扩)

LinkedList
底层维护了一个双向链表 (底层实现了双向链表和双端队列的特点)
可以添加包括null的任意元素
线程不安全，没实现同步
LinkedList维护了两个属性first, last分别指向首节点和尾节点
每个节点(Node对象)，里面又维护了pre,next,item三个属性。通过pre和next实现双向链表
LinkedList元素的添加和删除，不是通过数组实现，相对来说效率较高
CRUD create, read/retrieve, update, delete(增删改查)
(增删的效率高，通过链表追加；改差的效率低，要遍历链表找)


写完arraylist的笔记，放到collection_1里
*/