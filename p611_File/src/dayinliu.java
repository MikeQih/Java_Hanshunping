import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class dayinliu {
    
    public static void main(String[] args) throws IOException {
        //演示PrintStream 字节打印流
        // PrintStream out = System.out;
        // out.print("mike\n");//默认情况下，输出位置在显示器
        // out.write("岐恒昌你好".getBytes()); //getBytes：把String的字符转换成byte类型，并存在一个byte数组中
        // out.close();

        // System.setOut(new PrintStream("/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news1.txt"));
        // //没有这文件就创建一个
        // System.out.println("mmmiiikkkeee");



        //PrintWriter
        // PrintWriter printWriter = new PrintWriter(System.out); //在显示器输入
        PrintWriter printWriter = new PrintWriter("/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news1.txt"); //指定的file中输入
        printWriter.println("我是mike");
        printWriter.close();//没close就不会刷新内容，相当于flush(把数据写进去)+关闭流

    
    }
}
