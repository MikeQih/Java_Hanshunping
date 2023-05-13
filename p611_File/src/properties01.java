import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class properties01 {
    public static void main(String[] args) throws IOException{


        // BufferedReader br = new BufferedReader(new FileReader("/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/mysql.properties"));
        // String line="";
        // while((line=br.readLine())!=null){
        //     String[] split = line.split("=");
        //     System.out.println(split[0]+"值是："+split[1]);
        // }
        // br.close();


        //1.使用Properties类读取mysql.properties文件
        Properties properties = new Properties();
        properties.load(new FileReader("/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/mysql.properties"));
        properties.list(System.out); //把k-v显示在控制台
        //根据key 读取对应的值
        String user =  properties.getProperty("user");
        String pwd =  properties.getProperty("pwd");
        System.out.println("用户名是 "+user);
        System.out.println("密码是 "+pwd);

        //使用Properties类 创建/修改配置文件
        Properties properties2 = new Properties();
        //文件无key，就是创建；有这个key了，就是修改 (setProperty就是setKey的意思)
        //Properties父类是Hashtable，底层就是Hashtable核心方法
        properties2.setProperty("charset", "utf-8");
        properties2.setProperty("user", "汤姆");
        properties2.setProperty("pwd", "abc111");
        properties2.store(new FileOutputStream("/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/mysql.properties"),null); //null(注释为空)
        System.out.println("保存配置文件成功");



        //到p642
        
    }
}
