public class Enumeration01 {
    public static void main(String[] args) {
        // Season spring = new Season("春天", "温暖");
        System.out.println(Season2.SPRING);

        Season2 s1 = Season2.SPRING;
        Season2 s2 = Season2.SPRING;
        System.out.println(s1==s2);
        System.out.println("-----");

        Season2 autumn = Season2.AUTUMN;
        System.out.println(autumn.name());//输出枚举对象的名字
        System.out.println(autumn.ordinal());//输出该枚举对象的次序/编号，从0开始
        System.out.println(Season2.values());//以数组形式 返回含有定义的所有枚举对象
        for(Season2 season: Season2.values()){
            System.out.println(season);
        }
        System.out.println("-----");

        Season2 autumn1 = Season2.valueOf("AUTUMN");//把输入的字符串转换成枚举对象，在Season2中的枚举对象查找，找到就返回，没找到就报错
        System.out.println(autumn1==autumn);
        System.out.println(Season2.SPRING.compareTo(Season2.AUTUMN));//比较两个枚举常量编号，前减后

        Season2.AUTUMN.play();
    }
}
interface music{
    public void play();
}

enum Season2 implements music{//enum关键字 实现枚举
    SPRING("春天", "温暖"),SUMMER("夏天","炎热"),AUTUMN("秋天","凉爽"),WINTER("冬天","寒冷");

    private String name;
    private String desc;

    @Override
    public void play(){
        System.out.println("播放好听的音乐。。。");
    }

    @Override
    public String toString() {
        return "Season [name=" + name + ", desc=" + desc + "]";
    }

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}

class Season{//自定义类实现枚举
    private String name;
    private String desc;
    // public Season(String name, String desc) {
    //     this.name = name;
    //     this.desc = desc;
    // }
    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season SUMMER = new Season("夏天", "炎热");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season WINTER = new Season("冬天", "寒冷");

    @Override
    public String toString() {
        return "Season [name=" + name + ", desc=" + desc + "]";
    }

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    public String getName() {
        return name;
    }
    // public void setName(String name) {
    //     this.name = name;
    // }
    public String getDesc() {
        return desc;
    }
    // public void setDesc(String desc) {
    //     this.desc = desc;
    // }
}
/*
枚举：eg.季节，普通方法创建Season类，可以随便增加类的数量，不能体现季节是固定的四个对象，因此这样的设计不好。
枚举类[枚：一个一个 举：列举，把对象一个一个列举出来的类称为枚举类]，属于一种特殊的类，里面只包含一组有限的特定的对象 (对象名需要大写)

两种实现方式：
1.自定义类实现枚举 
把构造器变private，去掉set方法，用static逐个创建固定的对象，final

2.enum关键字实现枚举（默认会隐式继承Enum类，是一个final类。Java是单继承，所以不能再继承别的类，但可以实现接口）
使用关键字enum替代class
常量名(参数列表)
多个对象 结尾用"," 最后一个对象后用";"
如果使用enum 来实现枚举，需要把定义的常量(枚举)对象，写在枚举类的行首

javap 类名(.class)，可以查看反编译

*/
