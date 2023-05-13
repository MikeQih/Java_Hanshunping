import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutStream_ {
    public static void main(String[] args) throws Exception {
        //序列化后，保存的文件格式不是纯文本的，是按照它的格式来保存
        String filePath = "/Users/hengchangqi/c_vscode/Java_Hanshunping/p611_File/src/data.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        //将序列化数据到 data.dat
        oos.writeInt(100); //int->Integer 实现了Serializable
        oos.writeBoolean(true); //boolean->Boolean 实现了Serializable
        oos.writeChar('a'); //char->Character 实现了Serializable
        oos.writeDouble(9.5); //double->Double 实现了Serializable
        oos.writeUTF("mike岐恒昌"); //String
        oos.writeObject(new Dog("旺财", 10));
        oos.close();

        System.out.println("数据保存完毕(序列化形式)");
    }
}

//如需要序列化某个类的对象，实现Serializable
class Dog implements Serializable{
    private String name;
    private int age;
    //serialVersionUID序列化的版本号，可提高兼容性(以后了解)
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