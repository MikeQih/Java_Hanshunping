public class example2_runnable {
    public static void main(String[] args) {
        Dog dog = new Dog();
        // dog.start(); //这里不能调用start，start是extends Thread的方法
        //需要创建Thread对象，把dog对象(实现了Runnable接口的)，放入Thread
        Thread thread = new Thread(dog);
        thread.start();

        Tiger tiger = new Tiger();
        ThreadProx threadProx = new ThreadProx(tiger); 
        //tiger能放进去，因为实现了Runnable接口；ThreadProx构造器接收的也是Runnable接口类的
        threadProx.start();
        

    }
}
class Animal{

}
class Tiger extends Animal implements Runnable{
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫....");
    }
}
class ThreadProx implements Runnable{ //线程代理类，模拟了一个极简的Thread类
    private Runnable target = null; //属性，类型是Runnable
    @Override
    public void run() {
        if(target!=null){
            target.run(); //动态绑定（运行类型Tiger）
        }
    }
    public ThreadProx(Runnable target) {
        this.target = target;
    }
    public void start(){
        start0();
    }
    public void start0(){
        run();
    }
}
class Dog implements Runnable{//通过实现Runnable接口，开发线程
    int count=0;
    @Override
    public void run() {
        while(true){
            System.out.println("小狗汪汪叫"+(++count)+Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            if(count==5){
                break;
            }
        }
    }
}
/*
案例2:
用Runnable实现
每隔一秒，在控制台输出“hi”，输出10次后，自动退出。


*/