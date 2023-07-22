import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hw01 {
    public static void main(String[] args) {
        //1.判断电子邮件
        // String content = "mike@qq.com";
        // String regStr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        // if(content.matches(regStr)){
        //     System.out.println("匹配成功");
        // } else{
        //     System.out.println("匹配失败");
        // }

        //2.判断是不是整数或是小数，此题需考虑正数和负数
        //提示：先从简单的来，逐步加内容
        // String content = "0.02";
        // String regStr = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
        // if(content.matches(regStr)){
        //     System.out.println("匹配成功，是正整数或是小数");
        // } else{
        //     System.out.println("匹配失败");
        // }

        //3.对url进行解析 eg.http://www.sohu.com:8080/abc/index.htm
        String content = "http://www.sohu.com:8080/abc/index.htm";
        String regStr = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w.]+)$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if(matcher.matches()){
            System.out.println("整体匹配："+matcher.group(0));
            System.out.println("协议："+matcher.group(1));
            System.out.println("域名："+matcher.group(2));
            System.out.println("端口："+matcher.group(3));
            System.out.println("文件："+matcher.group(4));
        } else{
            System.out.println("没有匹配成功");
        }

    }
}
