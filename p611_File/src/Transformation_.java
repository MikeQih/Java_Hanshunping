import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Transformation_ {
    public static void main(String[] args) throws IOException {

        // read_inputstream();
        createFile_OutputStreamWriter();
    }
    //演示OutputStreamWriter 
    //把FileOutputStream字节流转成字符流OutputStreamWriter
    //指定处理的编码
    public static void createFile_OutputStreamWriter() throws IOException{
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news2.txt";
        String charSet = "utf-8";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath),charSet);
        osw.write("你好，mike");
        osw.close();
        System.out.println("按照"+charSet+"保存文件成功");
        
    }

    /*
    中文乱码问题
    读取news4到程序
    转换流 可把字节流转成字符流(可在字节流上指定编码格式)
    */
    public static void read_inputstream() throws IOException{
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news4.txt";
        // InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"gbk");
        // BufferedReader br = new BufferedReader(isr);
        //or两个合一句(下面的写法) 
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"gbk"));
        String s = br.readLine();
        System.out.println("读取内容 = "+s);
        br.close();
    }
}
//15:30

