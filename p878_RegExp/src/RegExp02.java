import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示转义字符的使用
 */
@SuppressWarnings({"all"})
public class RegExp02 {
    public static void main(String[] args) {
        String content = "abc$(a.bc(123(";
        //匹配( => \\(
        //匹配. => \\.
        String regStr = "\\.";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        // while(matcher.find()){
        //     System.out.println("找到 "+matcher.group(0));
        // }

        // System.out.println();


        //演示字符匹配符的使用
        String content2 = "a11c8ab._cABC aa";
        // String regStr2 = "[a-z]";
        // String regStr2 = "(?i)abc"; //匹配abc字符串，不区分大小写；a(?i)bc 表示bc不区分大小写
        // String regStr2 = "abc";
        // String regStr2 = "\\s"; //匹配任何空白字符
        String regStr2 = "\\."; //匹配任何空白字符

        Pattern pattern2 = Pattern.compile(regStr2/* ,Pattern.CASE_INSENSITIVE*/); //不区分大小写
        Matcher matcher2 = pattern2.matcher(content2);
        // while(matcher2.find()){
        //     System.out.println("找到："+matcher2.group(0));
        // }


        String content3 = "a111111aaaaaahello";
        // String regStr3 = "a{3,4}"; //要匹配aaa aaaa，尽可能匹配多的
        String regStr3 = "a1?"; //匹配a或者a1

        Pattern pattern3 = Pattern.compile(regStr3);
        Matcher matcher3 = pattern3.matcher(content3);
        // while(matcher3.find()){
        //     System.out.println("找到："+matcher3.group(0));
        // }


        String content4 = "as7789 1189ass_";
        // String regStr4 = "(\\d\\d)(\\d)(\\d)"; //分了3个组 eg.把7789放到了 77 8 9
        //命名分组：可以给分组取名
        String regStr4 = "(?<g1>\\d\\d)(?<g2>\\d\\d)";

        Pattern pattern4 = Pattern.compile(regStr4);
        Matcher matcher4 = pattern4.matcher(content4);
        // while(matcher4.find()){
        //     System.out.println("找到："+matcher4.group(0));
        //     System.out.println("第一个分组内容："+matcher4.group(1));
        //     System.out.println("第一个分组内容[通过组名]："+matcher4.group("g1"));
        //     System.out.println("第二个分组内容："+matcher4.group(2));
        //     System.out.println("第二个分组内容[通过组名]："+matcher4.group("g2"));
        //     // System.out.println("找到第三个分组内容："+matcher4.group(3));
        // }


        String content5 = "mike加油，mikenb mikehello";

        // String regStr5 = "mike加油|mikenb|mikehello";
        // String regStr5 = "mike(?:加油|nb|hello)"; //非捕获分组 的等价写法
        // String regStr5 = "mike(?=加油|nb|hello)"; //找到mike关键字，查找这三个后缀前的mike
        String regStr5 = "mike(?!加油|hello)"; //不要加油和hello前的mike，要nb前的那个mike

        Pattern pattern5 = Pattern.compile(regStr5);
        Matcher matcher5 = pattern5.matcher(content5);
        while(matcher5.find()){
            System.out.println("找到："+matcher5.group(0));
        }
    }
}
