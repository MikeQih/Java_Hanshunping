import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class file{
    public static void main(String[] args) {
        
        
    }
    @Test
    //方式1: new File(String pathname)
    public void create01(){
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //方式2: new File(File parent, String child) 根据父目录文件+子路径构建
    public void create02(){
        File parenFile = new File("/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src");
        String fileName = "news2.txt";
        //这里的file对象，在java程序中，只是个对象。只有执行了createNewFile方法，才会在磁盘中真正创建该文件
        File file = new File(parenFile,fileName);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //方式3: new File(String parent, String child) 根据父目录文件+子路径构建 (第一个参数是String)
    public void create03(){
        String parentPath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src";
        String fileName = "news3.txt";
        File file = new File(parentPath,fileName);
        try {
            file.createNewFile();
            System.out.println("创建成功~~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
输出流：java程序(内存)->文件(磁盘)
输入流：文件(磁盘)->java程序(内存)

File implements Serializable, Comparable

Java IO流原理
1. I/O Input/Output，I/O是很实用的技术，用于处理数据传输 eg.读写文件，网络通讯等
2. Java对于数据的输入/输出操作，以“流(stream)”的方式进行
3. Java.io包下提供了各种”流“的类和接口，用以获取不同种类的数据，通过方法输入或输出数据
4. 输入input：读取外部数据(磁盘，光盘等存储设备的数据)到程序(内存)中
5. 输出output：将程序(内存)数据输出到磁盘，光盘等存储设备中

流的分类
按操作数据单位 分为：字节流(8 bit)(二进制文件)；字符流(按字符)(文本文件)
按数据流的流向 分为：输入流(字节流：InputStream,字符流：Reader)，输出流(字节流：OutputStream,字符流：Writer) (四个类都是抽象类)
按流的角色不同 分为：节点流，处理流/包装流

InputStream(字节输入流) 抽象类是所有类字节输入流的超类
常用子类：1.FileInputStream文件输入流，2.BufferedInputStream缓冲字节输入流，3.ObjectInputStream对象字节输入流

FileReader extends InputStreamReader
FileWriter extends OutputStreamWriter
(写FileWriter一定记得关闭，才显示)

节点流：可以从一个特点的数据源读写数据，eg.FileReader, FileWriter
处理流(包装流)：是“连接”在已存在的流(节点流或处理流)之上，为程序提供更为强大的读写功能，eg.BufferedReader, BufferedWriter (修饰器模式)

BufferedReader，BufferedWriter 属于字符流(传入文本文件；声音/图片/视频都是二进制文件)
BufferedInputStream，BufferedOutputStream 处理字节

对象流：ObjectOutputStream, ObjectInputStream-> 能将基本数据类型/对象 序列化和反序列化
序列化：保存数据时，保存数据的值和数据类型
反序列化：恢复数据时，恢复数据的值和数据类型
细节说明：
1.读写顺序要一致 2.序列化/反序列化对象要实现Serializable 3.序列化中的类建议添加serialVersionUID，提高版本兼容性
4.序列化对象时，默认里面所有属性都进行序列化，除了static和transient修饰的成员 5.序列化对象时，要求属性的类型也要实现Serializable
6.序列化具备可继承性，如果某父类实现了序列化，它的所有子类也默认实现了序列化

打印流只有输出流，没有输入流 PrintStream(字节流),PrintWriter(字符流)

转换流：字节流转成字符流(可在字节流上指定编码格式)

学到p662 网络相关概念

*/
