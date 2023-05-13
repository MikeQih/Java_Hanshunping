import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BRexample {
    public static void main(String[] args) throws IOException{
        // fileRead();
        fileCopy();

    }
    public static void fileRead() throws IOException{
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news1.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line; 
        //bufferedReader.readLine() 按行读取
        //当返回null时，表示文件读取完毕
        while((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        //只需要关闭bufferedReader，因为底层会自动关闭节点流(FileReader)
        bufferedReader.close();
    }
    public static void fileCopy(){
        String srcFilePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news1.txt";
        String destFilePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news4.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;

        try{
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));
            while((line = br.readLine())!=null){
                //每读取一行就写入
                bw.write(line);
                bw.newLine();; //插入一个换行符
            }
            System.out.println("拷贝完毕");
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try {
                if(br!=null){
                    br.close();
                }
                if(bw!=null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
