import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的应用实例
 */

public class RegExp03 {
    public static void main(String[] args) {
        
        String content = "https://www.bilibili.com/video/BV1fh411y7R8?p=894&vd_source=6b8f7ac3a32568235346768a30e2fde5";

        //汉字
        // String regStr = "^[\u4e00-\u9fa5]+$";
        //邮政编码 1-9开头的6位数字
        // String regStr = "^[1-9]\\d{5}$";
        //QQ号码 1-9开头的5-10位数
        // String regStr = "^[1-9]\\d{4,9}$";
        //手机号码 13,14,15,18开头的11位数
        // String regStr = "^1[3|4|5|8]\\d{9}$";

        //URL 思路
        /*
        1.先确定url的开始部分 https:// | http:// 
        2.然后通过 ([\\w-]+\\.)+[\\w-]+ 匹配www.bilibili.com(域名)
        3./video/BV1fh411y7R8?p=894&vd_source=6b8f7ac3a32568235346768a30e2fde5 匹配 (\\/[\\w-?=&/%.#]*)?
        */
        String regStr = "^((https|http)://)?([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]*)?$";
        
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if(matcher.find()){
            System.out.println("满足格式");
        } else{
            System.out.println("不满足格式");
        }


    }
}
