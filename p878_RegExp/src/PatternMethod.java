import java.util.regex.Pattern;

public class PatternMethod {
    public static void main(String[] args) {
        String content = "hello abc hello, 韩顺平很牛";

        String regStr = "hello.*";        
        boolean matches = Pattern.matches(regStr, content);
        System.out.println("整体匹配："+matches);
        
    }
}
