import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherMethod {
    public static void main(String[] args) {
        String content = "hello abc hello hspedu, 韩顺平很牛, hello hspedu, hspedu";

        String regStr = "hello.*";        
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println("==============");
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println("找到："+content.substring(matcher.start(), matcher.end()));
        }

        //整体匹配方法，常用于校验某个字符串是否满足某个规划
        System.out.println("整体匹配："+matcher.matches());


        //如果content有hspedu，就替换成 mike加油
        regStr = "hspedu";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(content);
        //返回后的字符串才是替换后的字符串，原来的content不变 (想原来的变，就用content接收)
        String newContent = matcher.replaceAll("mike加油");
        System.out.println("newContent="+newContent);
        System.out.println("content="+content);

    }
}
