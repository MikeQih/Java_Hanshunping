import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class collections {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList(); //创建ArrayList集合用于测试
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("milan");
        System.out.println(list);

        Collections.reverse(list); //反转
        System.out.println(list);

        Collections.shuffle(list); //随机排序
        System.out.println(list);

        Collections.sort(list);//自然排序(升序)
        System.out.println("自然排序后："+list);
        Collections.sort(list,new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)(o2)).length(); //小到大
            }
        });
        System.out.println("按长度排序后："+list);

        Collections.swap(list, 0, 1);
        System.out.println("交换0和1索引后的list = "+list);
        

        System.out.println("\n第二组方法：\n");
        System.out.println("自然排序后的最大值："+Collections.max(list)); //自然排序后的最大值
        Object maxObject = Collections.max(list,new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)(o2)).length();
            }
        });
        System.out.println(maxObject);

        System.out.println("自然排序后的最小值："+Collections.min(list)); //自然排序后的最小值

        list.add("tom");
        System.out.println(Collections.frequency(list, "tom")); //集合中 指定元素出现的次数

        ArrayList dest = new ArrayList();
        //为了完成一个完整的拷贝，需要先给dest赋值，大小和list.size()一样
        for(int i=0;i<list.size();i++){
            dest.add("");
        }
        Collections.copy(dest, list); //拷贝
        System.out.println("dest = "+dest);

        Collections.replaceAll(list, "tom", "汤姆"); //使用新值 替换对象中所有的旧值
        System.out.println("list替换tom后："+list);

    }
}
/*

*/
