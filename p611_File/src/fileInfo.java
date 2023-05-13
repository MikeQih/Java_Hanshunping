import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileInfo {
    public static void main(String[] args) {
        // info();
        // m1_deleteFile();
        // m2_deleteDir();
        // m3_createDir();
        // readFile01();
        // readFile02();
        // writeFile();
        // fileCopy();
        // FileReader_m2();
        FileWriter_();
    }

    //获取文件信息
    public static void info(){
        //先创建文件对象
        File file = new File("/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news1.txt");
        
        //调用相应方法，得到对应信息
        System.out.println("文件名为："+file.getName());
        System.out.println("文件绝对路径："+file.getAbsolutePath());
        System.out.println("文件父级目录："+file.getParent());
        System.out.println("文件大小(字符)："+file.length()); //一个汉字3个字节，一字母一字节
        System.out.println("文件是否存在："+file.exists());
        System.out.println("是不是一个文件："+file.isFile());
        System.out.println("是不是一个目录："+file.isDirectory());
    }

    public static void m1_deleteFile(){
        //判断“/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news2.txt”是否存在，如存在就删除
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news2.txt";
        File file = new File(filePath);
        if(file.exists()){
            if(file.delete()){
                System.out.println(filePath+" 删除成功");
            }
            else{
                System.out.println(filePath+" 删除失败");
            }
        }
        else{
            System.out.println("该文件不存在");
        }
    }

    public static void m2_deleteDir(){
        //判断“/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news2.txt”是否存在，如存在就删除
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news2";
        File file = new File(filePath);
        if(file.exists()){
            if(file.delete()){
                System.out.println(filePath+" 删除成功");
            }
            else{
                System.out.println(filePath+" 删除失败");
            }
        }
        else{
            System.out.println("该目录不存在");
        }
    }

    public static void m3_createDir(){
        //判断“/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news2/a/b/c”是否存在，如不存在就创建
        String directoryPath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news2/a/b/c";
        File file = new File(directoryPath);
        if(file.exists()){
            System.out.println(directoryPath+"已存在");
        }
        else{
            if(file.mkdirs()){ //mkdir是单目录，mkdirs是多级目录
                System.out.println(directoryPath + "创建成功");
            }
            else{
                System.out.println("创建失败");
            }
        }
    }

    public static void readFile01(){
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news1.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建fileInputStream对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据，如果没有输入可用，此方法将阻止
            //如果返回-1，表示读取完毕
            while((readData = fileInputStream.read())!=-1){
                System.out.print((char)readData); //转成char显示 (一个中文3个字节，read方法一次读一个字节然后转，肯定乱码。所以读文本最好用字符流)
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFile02(){
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news1.txt";
        byte[] buf = new byte[10]; //一次读取10个字节，读完就再分批读取
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建fileInputStream对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取最多b.length字节的数据到字节数组。
            //如果返回-1，表示读取完毕
            while((readLen = fileInputStream.read(buf))!=-1){
                System.out.print(new String(buf,0,readLen)); 
                //new String(,,)三个参数：1.要解码为字符的名为byte的数组 2.要解码的第一个byte索引 3.要解码的byte数的长度
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeFile(){
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news4.txt";
        FileOutputStream fileOutputStream = null;
        try {
            //1.new FileOutputStream(filePath); 写入内容时，覆盖原有内容
            //2.new FileOutputStream(filePath, true); 追加到文件的后面
            fileOutputStream = new FileOutputStream(filePath, false);

            //写入一个字符
            // fileOutputStream.write('Q');

            //写入字符串
            String str = "hello mike world";
            //str.getBytes() 可把字符串->字节数组
            // fileOutputStream.write(str.getBytes()); //m1
            fileOutputStream.write(str.getBytes(), 0, str.length()); //m2
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileCopy(){
        //文件拷贝，把TankGame中的 bomb1.png 拷贝到File的src中
        //思路：1.创建文件输入流，把文件读入程序 2.创建文件输出流，把读取到的文件数据，写入到指定文件
        String srcFilePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p569_TankGame/tankgame/src/bomb1.png";
        String destFilePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/bomb1.png";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            byte[] buf = new byte[1024];
            int readLen = 0;
            while((readLen = fileInputStream.read(buf))!= -1){
                //读取了部分数据就写入指定文件，全部读完再写入占用的内存太大
                fileOutputStream.write(buf,0,readLen); //一定使用这方法，读图片
            }
            System.out.println("拷贝完成");

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(fileInputStream!=null){ //判断->避免空指针异常
                    fileInputStream.close();
                }
                if(fileOutputStream!=null){
                    fileOutputStream.close();
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void FileReader_m1(){
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news1.txt";
        FileReader fileReader = null;
        //m1
        int data = 0;
        try {
            fileReader = new FileReader(filePath);
            //循环，使用read，单个读取（慢）
            while((data = fileReader.read())!=-1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void FileReader_m2(){
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news1.txt";
        FileReader fileReader = null;
        //m2 使用字符数组
        char[] buf = new char[8];
        int readLen = 0;
        try {
            fileReader = new FileReader(filePath);
            //循环，使用read(buf)，返回实际读取到的字符数（块）
            while((readLen = fileReader.read(buf))!=-1){
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void FileWriter_(){
        FileWriter fileWriter = null;
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news3.txt";
        char[] chars ={'a','b','c'};
        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write('H');
            fileWriter.write(chars);
            fileWriter.write("岐恒昌".toCharArray(),0,3);
            fileWriter.write(" 你好mike～ ");
            fileWriter.write("mike你好",4,2); //只要“你好“
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                fileWriter.close(); //一定关流！
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
