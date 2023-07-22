import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 体验正则表达式，给文本处理带来怎样的便利
 */
public class first {
    public static void main(String[] args) {
        //假定编写了爬虫，从网页得到了如下文本
        // String content = "Java 是一个通用术语，用于表示 Java 软件及其组件，包括“Java 运行时环境 (JRE)”、"+
        //     "“Java 虚拟机 (JVM)”以及“插件”。 [1] Java具有大部分编程语言所共有的一些特征，被特意设计用于互联网的分布式环境。"+
        //     "Java具有类似于C++语言的形式和感觉，但它要比C++语言更易于使用，而且在编程时彻底采用了一种以对象为导向的方式。"+
        //     "Java版本指的是 Java 系列和更新编号。示例：在网站上或者 Windows 程序中，版本显示为 Java 8 Update 25。旧版本也可显示为 1.7.0_65，这表示 Java 7 Update 65。";
        
        String content = "<!DOCTYPE html>\n" + //
                "<html dir=\"ltr\" lang=\"zh\" xml:lang=\"zh\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:Web=\"http://schemas.live.com/Web/\">\n" + //
                "<script type=\"text/javascript\">\n" + //
                "//<![CDATA[\n" + //
                "si_ST = new Date//]]>\n" + //
                "</script>\n" + //
                "<head>\n" + //
                "    <!--pc-->\n" + //
                "    <title>\u600E\u6837\u67E5\u770B\u7F51\u9875\u7684html macbook - \u641C\u7D22</title>\n" + //
                "    <meta content=\"text/html; charset=utf-8\" http-equiv=\"content-type\"/>\n" + //
                "    <meta name=\"referrer\" content=\"origin-when-cross-origin\"/>\n" + //
                "    <meta property=\"og:description\" content=\"\u901A\u8FC7\u5FC5\u5E94\u7684\u667A\u80FD\u641C\u7D22\uFF0C\u53EF\u4EE5\u66F4\u8F7B\u677E\u5730\u5FEB\u901F\u67E5\u627E\u6240\u9700\u5185\u5BB9\u5E76\u83B7\u5F97\u5956\u52B1\u3002\"/>\n" + //
                "    <meta property=\"og:site_name\" content=\"\u5FC5\u5E94\"/>\n" + //
                "    <meta property=\"og:title\" content=\"\u600E\u6837\u67E5\u770B\u7F51\u9875\u7684html macbook - \u5FC5\u5E94\"/>\n" + //
                "    <meta property=\"og:url\" content=\"https://cn.bing.com/search?go=\u641C\u7D22&amp;q=\u600E\u6837\u67E5\u770B\u7F51\u9875\u7684html+macbook&amp;qs=n&amp;form=QBRE&amp;msbsrank=6_6__0&amp;sp=-1&amp;lq=0&amp;pq=\u600E\u6837\u67E5\u770B\u7F51\u9875\u7684htm+macbook&amp;sc=6-18&amp;sk=&amp;cvid=CE1AE1012D69452B9ADFC63311E7C6E0&amp;ghsh=0&amp;ghacc=0&amp;ghpl=\"/>\n" + //
                "    <meta property=\"fb:app_id\" content=\"570810223073062\"/>\n" + //
                "    <meta property=\"og:image\" content=\"http://www.bing.com/sa/simg/facebook_sharing_5.png\"/>\n" + //
                "    <meta property=\"og:type\" content=\"website\"/>\n" + //
                "    <meta property=\"og:image:width\" content=\"600\"/>\n" + //
                "    <meta property=\"og:image:height\" content=\"315\"/>\n" + //
                "    <link href=\"/search?";

        /*
        需求：提取文章中所有英文单词，数字，两个都提取，提取网页信息
        (1)传统方法，使用遍历方式，代码量大，效率不高
        (2)正则表达式
        */

        //1.先创建一个Pattern对象，默示对象，就是一个正则表达式对象
        // Pattern pattern = Pattern.compile("[a-zA-Z]+"); //找单词，后面的+表示 后面可以有1到多
        // Pattern pattern = Pattern.compile("[0-9]+"); //找数字
        // Pattern pattern = Pattern.compile("([a-zA-Z]+)|([0-9]+)"); //两个都要
        Pattern pattern = Pattern.compile("content=\"(\\S*)\"/>\n"); //匹配到的(\\S*)，这部分内容是要查找的
        
        //2.创建一个匹配器对象
        //matcher匹配器按照pattern(模式/样式)，到context文本中去匹配，找到返回true，否则就是false
        int no = 0;
        Matcher matcher = pattern.matcher(content);
        //3.开始循环匹配
        while(matcher.find()){
            //匹配文本，内容，放到m.group(0)
            System.out.println("找到："+ (++no) +" "+ matcher.group(1));
        }


    }
}
