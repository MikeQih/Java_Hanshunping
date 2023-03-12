import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

public class array {

    public static void main(String[] args) {
        Integer[] integers = {100,20,90};
        //Arrays.toString()方法，显示数组
        System.out.println(Arrays.toString(integers));

        Arrays.sort(integers);
        System.out.println(Arrays.toString(integers));
        //数组是引用类型，所以通过sort排序后，会直接影响到 实参 integers
        /*
        sort也可以通过传入接口，Comparator实现定制排序
        调用定制排序时传入的参数：1.需要排序的数组 2.实现了Comparator接口的匿名内部类，需要实现compare方法
        */
        // Arrays.sort(integers, new Comparator() {
        //     @Override
        //     public int compare(Object o1, Object o2) { //返回的值>0 还是<0，会影响整个排序的结果
        //         Integer i1 = (Integer)o1;
        //         Integer i2 = (Integer)o2;
        //         return i2-i1; //o1存储的是较小值 o2存储的是较大值？？？
        //     }
        // });
        System.out.println(Arrays.toString(integers));

        int[]arr = {1,-1,8,0,20};
        bubble01(arr);
        System.out.println("bubble01 排序后的arr: "+Arrays.toString(arr));

        bubble02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i2-i1; //大于0 (i2>i1) 就交换，(bubble02的if)，所以最后从大到小
            }
        });
        System.out.println("bubble02 排序后的arr: "+Arrays.toString(arr));

        Integer[] arr1 = {1,3,2,4,5};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
        /*
        Arrays.binarySearch()，二叉查找
        要求该数组是有序的
        如果数组不存在该元素，return -(low+1) //key not found (就是负的（它应该存在的位置+1）)
        */
        
        System.out.println(Arrays.binarySearch(arr1,1));
        System.out.println(Arrays.binarySearch(arr1,21));

        /*
        copyOf 数组元素的复制
        拷贝的长度>arr1.length,就在新数组后面加null
        长度<0,抛出NegativeArraySizeException
        方法底层使用的是 System.arraycopy()
        */
        
        Integer[] newArr = Arrays.copyOf(arr1, arr1.length-2);
        System.out.println("拷贝执行完毕后：");
        System.out.println(Arrays.toString(newArr));

        Arrays.fill(newArr, 999);
        //Arrays.fill(), 数组元素的填充 
        //用999替换了数组原来的元素
        System.out.println(Arrays.toString(newArr));

        // System.out.println(Arrays.toString(integers));
        // System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.equals(integers, arr1)); //比较两个数组元素是否完全一致

        List asList = Arrays.asList(1,2,3,4);
        /*
        asList方法会把(1,2,3,4) 转换成一个List集合
        返回的asList 
        编译类型：List(接口)
        运行类型：java.util.Arrays$ArrayList
        */
        System.out.println(asList.getClass());
        

    }

    public static void bubble01(int[] arr){
        int temp=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){ //>:从小到大；<:就是从大到小
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void bubble02(int[] arr,Comparator c){
        int temp=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(c.compare(arr[j], arr[j+1]) > 0){ //>:从小到大；<:就是从大到小
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

    }
}
/*

*/
