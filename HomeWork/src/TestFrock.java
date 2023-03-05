public class TestFrock {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());//100100
        System.out.println(Frock.getNextNum());//100200
        Frock frock1 = new Frock();//100300
        Frock frock2 = new Frock();//100400
        Frock frock3 = new Frock();//100500
        System.out.println(frock1.getSerialNumebr());
        System.out.println(frock2.getSerialNumebr());
        System.out.println(frock3.getSerialNumebr());

        Dog dog = new Dog();
        dog.shout();
        Animal cat = new Cat();
        cat.shout();

        Cellphone c = new Cellphone();
        c.testWork(new Computer() {//匿名内部类，也是个对象
            @Override
            public double work(double a,double b){
                return a+b;
            }
        },10,10);

        c.testWork(new Computer() {//匿名内部类，也是个对象
            @Override
            public double work(double a,double b){
                return a*b;
            }
        },10,10);

        A a = new A();
        a.m();
        // new A().m(); //method2

        Person p = new Person("唐僧", new Horse());
        p.passRiver();
        p.common();
        p.passHuoyanshan();

        Car car1 = new Car(41);
        car1.getAir().flow();
        Car car2 = new Car(-2);
        car2.getAir().flow();
        Car car3 = new Car(39);
        car3.getAir().flow();

        Color green = Color.GREEN;
        green.show();
        switch(green){
            case GREEN:
                System.out.println("匹配到绿色");
                break;
            case YELLOW:
                System.out.println("匹配到黄色");
                break;
            default:
                System.out.println("没有匹配到");
                break;
        }
        
    }
}
interface Show{
    public abstract void show();
}
enum Color implements Show{
    RED(255,0,0),BLUE(0,0,255),BLACK(0,0,0),
    YELLOW(255,255,0),GREEN(0,255,0);
    private int redValue;
    private int greenValue;
    private int blueValue;
    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }
    @Override
    public void show(){
        System.out.println("属性值为："+redValue+", "+greenValue+", "+blueValue);
    }
    
}
class Car{
    private int temperature; 
    public Car(int temperature) {
        this.temperature = temperature;
    }

    class Air{
        public void flow(){
            if(temperature>40){
                System.out.println("吹出冷气");
            }
            else if(temperature<0){
                System.out.println("吹出暖气");
            }
            else{
                System.out.println("关掉空调");
            }
        }
    }
    public Air getAir(){
        return new Air();
    }
    

}
interface Vehicles{
    public void work();
}
class Transportation{
    private Transportation(){}
    private static Horse horse = new Horse(); //饿汉式？单例模式？
    public static Horse getHorse(){
        return horse;
    }
    public static Boat getBoat(){
        return new Boat();
    }
    public static Plane getPlane(){
        return new Plane();
    }
}
class Person{
    private String name;
    private Vehicles vehicles;
    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }
    public void passRiver(){
        if(!(vehicles instanceof Boat)){ //判断vehicles是否为空，以及是不是Boat
            vehicles = Transportation.getBoat();
        }
        vehicles.work();
    }

    public void passHuoyanshan(){
        if(!(vehicles instanceof Plane)){
            vehicles = Transportation.getPlane();
        }
        vehicles.work();
    }

    public void common(){
        if(!(vehicles instanceof Horse)){
            vehicles = Transportation.getHorse();
        }
        vehicles.work();
    }
    
}
class Plane implements Vehicles{
    @Override
    public void work() {
        System.out.println("过火焰山时，驾驶飞机通过");
    }
}

class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("一般情况下，骑马前进");
    }
}

class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("过河时，乘船前行");  
    }
}

class A{
    private String NAME = "Hengchang Qi";
    
    public void m(){
        class B{
            private final String NAME = "Mike";
            public void show(){
                System.out.println("name is: "+NAME+" 外部类的name："+ A.this.NAME);//A.this.name
            }
        }
        B b = new B();
        b.show();
    }
}
interface Computer{
    public double work(double n1, double n2);
}
class Cellphone{
    public void testWork(Computer c, double a,double b){
        double result = c.work(a, b);
        System.out.println("answer is: "+result);
    }
}
abstract class Animal{
    public abstract void shout();
}
class Dog extends Animal{
    @Override
    public void shout() {
        System.out.println("狗会汪汪叫");        
    }
}
class Cat extends Animal{
    @Override
    public void shout() {
        System.out.println("猫会喵喵叫");        
    }
}
class Frock{
    private static int currentNum=100000;
    private int serialNumebr;

    public static int getNextNum(){
        currentNum+=100;
        return currentNum;
    }
    public Frock() {
        this.serialNumebr = getNextNum();
    }

    public int getSerialNumebr() {
        return serialNumebr;
    }
    
}
