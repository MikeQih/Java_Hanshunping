import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 反向引用
 */
public class RegExp04 {
    public static void main(String[] args) {
        // String content = "hello abc11asd 7777 12321-333999111 1551 hello, mike11 jackie david22 nihao";
        
        //匹配连续2个连续的相同数字
        // String regStr = "(\\d)\\1";    
        //5个连续相同的
        // String regStr = "(\\d)\\1{4}";
        //匹配个位千位相同，十位百位相同
        // String regStr = "(\\d)(\\d)\\2\\1";  

        //练习：检索商品编号，5位数 - 9位数(连续的每三位要相同) eg.12321-333999111
        // String regStr = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";

        // Pattern compile = Pattern.compile(regStr);
        // Matcher matcher = compile.matcher(content);
        // while(matcher.find()){
        //     System.out.println("找到："+matcher.group(0));
        // }


        //结巴去重案例
        String content = "我....我要....学学学学....编程java！";
        //1.去掉.
        Pattern pattern = Pattern.compile("\\."); 
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("");
        //2.去掉重复的字，用反向引用$1 替换匹配到的内容
        // pattern = Pattern.compile("(.)\\1+");  //(.)算是外部的分组，所以用$1替换
        // matcher = pattern.matcher(content); //需要重制matcher
        // while(matcher.find()){
        //     System.out.println("找到："+matcher.group(0));
        // }
        // content = matcher.replaceAll("$1"); //替换匹配到的内容
        //3.使用一条语句去重
        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
        System.out.println(content);


        //替换分割匹配
        //把jdk1.3，jdk1.4换成jdk
        String content2 = "david jdk1.3 jdk1.4 mike";
        content2 = content2.replaceAll("jdk1\\.3|jdk1\\.4", "jdk");
        System.out.println(content2);
        
        //验证手机号，必须是以138 139开头的
        content2 = "13888888882";
        if(content2.matches("1(38|39)\\d{8}")){
            System.out.println("验证成功");
        }
        else{
            System.out.println("验证失败");
        }

        //按照 #|-|~|\\d 来分割
        content2 = "hello#abc~jack12smith~北京";
        String[] split = content2.split("#|-|~|\\d+");
        for(String s:split){
            System.out.println(s);
        }
        
    }
}
