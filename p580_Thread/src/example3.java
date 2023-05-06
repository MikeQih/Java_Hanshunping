public class example3 {
    //多个子线程 13:08
    public static void main(String[] args) {
        // T1 t1 = new T1();
        // T2 t2 = new T2();
        // Thread thread1 = new Thread(t1);
        // Thread thread2 = new Thread(t2);
        // thread1.start();
        // thread2.start();

        //多线程，模拟3个售票窗口，共100张票
        // SellTicket sellTicket1 = new SellTicket();
        // SellTicket sellTicket2 = new SellTicket();
        // SellTicket sellTicket3 = new SellTicket();

        // //会出现超卖的情况
        // sellTicket1.start();
        // sellTicket2.start();
        // sellTicket3.start();

        // System.out.println("===使用实现");
        // SellTicket2 sellTicket2 = new SellTicket2();

        // new Thread(sellTicket2).start();
        // new Thread(sellTicket2).start();
        // new Thread(sellTicket2).start();


        SellTicket3 sellTicket3 = new SellTicket3(); //为什么只有sellTicket3,还是有0，1，2？没用别的窗口啊
        new Thread(sellTicket3).start();
        new Thread(sellTicket3).start();
        new Thread(sellTicket3).start();



    }
}
//实现接口方式，使用synchronized实现线程同步
class SellTicket3 implements Runnable{
    private int ticketNum = 1000; //多个线程共享
    private boolean loop = true;
    Object object = new Object();

    /*
    public synchronized static void m1(){

    }
    public static void m2(){ //互斥锁在类本身，所以synchronized(当前类.class) (多个线程的锁对象要求为同一个)
        synchronized(SellTicket3.class){ //首选同步代码块，效率更高；锁的范围越大，效率越低
            System.out.println("m2");
        }
    }
    */

    /*
    1.public synchronized void sell(){} 就是个同步方法。这时锁在this对象
    2.也可在代码块上写synchronize，同步代码块，互斥锁还是在this对象
    */
    public /*synchronized*/ void sell(){
        synchronized(/*this*/ object){
            if(ticketNum<=0){
                System.out.println("售票结束");
                loop = false;
                return;
            }
            //还有票，就每次休眠50ms (卖票也需要时间)
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口："+Thread.currentThread().getName()+" 售出一张票"
            +" 剩余票数为："+(--ticketNum));
        }
    }

    @Override
    public void run() { //同步方法，一次只能一个线程执行run方法
        while(loop){
            sell();
        }
    }
}

//使用Thread方式
class SellTicket extends Thread{
    private static int ticketNum = 1000; //多个线程共享
    @Override
    public void run() {
        while(true){
            if(ticketNum<=0){
                System.out.println("售票结束");
                break;
            }
            //还有票，就每次休眠50ms (卖票也需要时间)
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口："+Thread.getAllStackTraces()+" 售出一张票"
            +" 剩余票数为："+(--ticketNum));
        }
    }
}

//实现接口方式
class SellTicket2 implements Runnable{
    private int ticketNum = 1000; //多个线程共享
    @Override
    public void run() {
        while(true){
            if(ticketNum<=0){
                System.out.println("售票结束");
                break;
            }
            //还有票，就每次休眠50ms (卖票也需要时间)
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口："+Thread.getAllStackTraces()+" 售出一张票"
            +" 剩余票数为："+(--ticketNum));
        }
    }
}

//example 3
class T1 implements Runnable{
    int count = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("hello, world " + (++count));
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            if(count == 5){
                break;
            }
        }
    }
}
class T2 implements Runnable{
    int count = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("hi " + (++count));
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            if(count == 10){
                break;
            }
        }
    }
}

