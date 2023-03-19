import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class list_method {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("mike");
        list.add("david");
        list.add(1,"lucas"); //不写索引，默认加到末尾
        System.out.println(list);

        List list2 = new ArrayList();
        list2.add("岐恒昌");
        list2.add("商子岳");
        list2.add("mike");
        list.addAll(1,list2);
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.indexOf("mike")); //返回首次出现的位置
        System.out.println(list.lastIndexOf("mike")); //返回最后一次出现的位置

        list.remove(1);
        System.out.println(list);
        list.set(0,"曹津豪"); //相当于替换
        System.out.println(list);
        System.out.println(list.subList(0, 2)); //返回从fromIndex - toIndex位置的子集合
        
        System.out.println();
        List list3 = new ArrayList();//换成Vector，LinkedList一点问题没有
        for(int i=0;i<12;i++){
            list3.add("hello"+i);
        }
        list3.add(1,"韩顺平教育");
        System.out.println("第五个元素："+list3.get(4));
        list3.remove(5);
        list3.set(6, "修改了");
        Iterator iterator = list3.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }

        //普通for遍历
        System.out.println();
        for(int i=0;i<list3.size();i++){
            Object obj = list3.get(i);
            System.out.println("obj: "+obj);
        }
    }
}
/*

*/