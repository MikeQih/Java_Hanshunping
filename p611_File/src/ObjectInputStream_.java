import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

//Java序列化：把Java对象转换为字节序列的过程
//Java反序列化：把字节序列恢复为Java对象的过程

public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception, ClassNotFoundException{
        //指定反序列化文件
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/data.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读取(反序列化)的顺序需要和保存数据的顺序一致，否则出现异常
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object dog = ois.readObject();
        System.out.println("运行类型："+dog.getClass());
        System.out.println("dog信息："+dog); //底层 Object->Dog
        
        Dog dog2 = (Dog)dog; //想调用Dog的方法，需要向下转型。需要将Dog类的定义拷贝到可以引用的位置。
        System.out.println(dog2.getName());

        ois.close(); //关闭外层流即可
    }
}//反序列化

class Dog implements Serializable{
    private String name;
    private int age;
    private static final long serialVersionUID = 1;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Dog [name=" + name + ", age=" + age + "]";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}