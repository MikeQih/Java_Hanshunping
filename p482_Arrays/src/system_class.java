import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;


public class system_class {
    public static void main(String[] args) {
        // System.out.println("mike");
        // System.exit(0);
        // //exit 退出当前程序，exit(0)正常状态，下面的内容不会执行
        // System.out.println("mmm");

        //arraycopy: System.arraycopy(src 原数组, 0 从原数组的第几个索引开始, dest 目标数组, 0 把原数组的索引拷贝到目标数组的哪个索引, 3 从原数组拷贝数据的数量);
        int[] src = {1,2,3};
        int[] dest = new int[3];
        System.arraycopy(src, 2, dest, 1, 1);
        System.out.println(Arrays.toString(dest));
        System.arraycopy(src, 0, dest, 0, src.length);
        System.out.println(Arrays.toString(dest));

        System.out.println();
        //返回当前时间距离1970-1-1的毫秒数
        System.out.println(System.currentTimeMillis());

        //在对BigInteger加减乘除时，需要使用对应的方法，不能直接+-*/
        //底层就是把数据当成字符串，处理完后转成bigInteger
        BigInteger bigInteger = new BigInteger("233222232232232323223");
        //可以创建一个要操作的BigInteger 然后进行对应操作
        BigInteger bigInteger2 = new BigInteger("100");
        System.out.println(bigInteger.getClass());

        BigInteger add = bigInteger.add(bigInteger2);
        System.out.println(add);
        BigInteger subtract = bigInteger.subtract(bigInteger2);
        System.out.println(subtract);
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        System.out.println(multiply);
        BigInteger divide = bigInteger.divide(bigInteger2);
        System.out.println(divide);
        System.out.println();

        /*
        BigDecimal 当需要保存一个精度很高的小数，double不够用，就需要BigDecimal 
        运算与BigInteger相同，同样需要使用对应的方法，
        创建一个需要操作的BigDecimal 然后调用对应的方法
        */
        BigDecimal bigDecimal = new BigDecimal("12.2122");
        System.out.println(bigDecimal.add(new BigDecimal( 3000)));
        System.out.println(bigDecimal.multiply(bigDecimal));
        //divide可能会抛出异常ArithmeticException(除不尽)
        //解决方案：使用divide时，指定精度。BigDecimal.ROUND_CEILING
        //如果有无限循环小数，就会保留分子的精度(分子小数点后几位，结果就保留几位)
        BigDecimal bigDecimal2 = new BigDecimal("3");
        System.out.println(bigDecimal.divide(bigDecimal2,bigDecimal.ROUND_CEILING));

    }
}
/*
BigInteger适合保存比较大的整型
BigDecimal适合保存精度更高的浮点型(小数)
*/
