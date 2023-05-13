import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BWexample {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news1.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));//true (追加)
        bufferedWriter.write("hello mikee");
        bufferedWriter.newLine(); //插入一个和系统相关的换行
        bufferedWriter.write("helloa mikkee");
        bufferedWriter.newLine();

        bufferedWriter.close(); //关闭外层流就行
    }
}
