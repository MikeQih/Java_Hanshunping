import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BOSexample {
    public static void main(String[] args) {
        String srcFilePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p569_TankGame/tankgame/src/bomb1.png";
        String destFilePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/copied_bomb1.png";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try{
            bis = new BufferedInputStream(new FileInputStream(srcFilePath)); //FileInputStream是InputStream的子类
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));

            byte[] buff = new byte[1024];
            int readLen = 0;

            while((readLen = bis.read(buff))!=-1){
                bos.write(buff,0,readLen);
            }
            System.out.println("文件拷贝完毕");
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try{
                if(bis!=null){
                    bis.close();
                }
                if(bos!=null){
                    bos.close();
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    


}
//BufferedOutputStream，BufferedInputStream 可以完成二进制文件(视频，图片)拷贝（也可操作文本文件 (打印到控制台乱码，正常拷贝没问题)）