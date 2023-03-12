import java.util.Arrays;

import javax.management.RuntimeErrorException;
import javax.print.attribute.standard.PrinterName;


public class HW {
    public static void printNmae(String str){
        if(str==null){
            System.out.println("str 不能为空");
            return;
        }
        String[] strList = str.split(" ");

        if(strList.length!=3){
            System.out.println("输入的字符串格式不对");
            return;
        }
        char[] c = strList[1].toUpperCase().toCharArray();
        System.out.println(strList[2]+","+strList[0]+" ."+String.valueOf(c[0]));
        //m2:
        // String format = String.format("%s,%s .%c", strList[2],strList[0],strList[1].toUpperCase().charAt(0));
        // System.out.println(format);
    }
    
    public static void countStr(String str){
        if(str==null){
            System.out.println("str 不能为null");
            return;
        }
        int numCount = 0;
        int lowerCount = 0;
        int upperCount = 0;
        int otherCount = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                numCount++;
            }
            else if(str.charAt(i)>='a' && str.charAt(i)<='z'){
                lowerCount++;
            }
            else if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                upperCount++;
            }
            else{
                otherCount++;
            }
        }
        System.out.println("数字有："+numCount);
        System.out.println("小写有："+lowerCount);
        System.out.println("大写有："+upperCount);
        System.out.println("其他有："+otherCount);

    }
    public static void main(String[] args) {
        countStr("m211Wde");
        printNmae("Han shun Ping");
        printNmae("William Jefferson Clinton");
        printNmae("tom");
        String s = "abcdef";
        System.out.println("交换前："+s);
        try{
            s = reverse(s, 01, 05); //在数字前加0，转化成八进制，只有01-07
        }catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("交换后："+s);
        String name = "mike";
        String pwd = "1212s12";
        String email = "253122@asas.";
        try{
            userRegister(name, pwd, email);
            System.out.println("恭喜注册成功！");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void userRegister(String name, String pwd,String email){
        if(!(name!=null && pwd!= null && email!=null)){
            throw new RuntimeException("参数不能为null");
        }

        int userName = name.length();
        if(!(userName>=2 && userName<=4)){
            throw new RuntimeException("用户名长度为2-4");
        }
        if(!(pwd.length()==6 && isDigital(pwd))){
            throw new RuntimeException("你的密码长度需为6个 且都是数字");
        }
        int i = email.indexOf("@");
        int j = email.indexOf(".");
        if(!(i>0 && j>i)){
            throw new RuntimeException("邮箱中需包含@和. 并且@在.的前面");

        }

    }
    public static boolean isDigital(String str){
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]<'0' || chars[i]>'9'){
                return false;
            }
        }
        return true;
    }
    public static String reverse(String str, int start, int end){
        //最好：先写出正确的情况，然后取反这些情况，就是满足的条件
        if(!(str!=null && start>=0 && end>start && end<str.length())){
            throw new RuntimeException("数字参数不正确");
        }
        //m2 双指针
        int lc = start;
        int rc = end;
        char[] charList = str.toCharArray();
        while(rc>lc){
            char temp = 'A';
            temp = charList[lc];
            charList[lc] = charList[rc];
            charList[rc] = temp;
            if((lc+1)==charList.length || (rc-1)==charList.length){
                break;
            }
            lc+=1;
            rc-=1;
        }
        return new String(charList);

        //m1:
        // String[] strList = str.split("");
        // String[] temp = new String[end-start+1];
        // int j =0;
        // for(int i=end;i>=start;i--){
        //     temp[j] = strList[i];
        //     j+=1;
        // }
        // int j2=0;
        // for(int i=start;i<=end;i++){
        //     strList[i]=temp[j2];
        //     j2+=1;
        // }
        // return Arrays.toString(strList);
    }
}
/*
11:30
看到p499
*/
