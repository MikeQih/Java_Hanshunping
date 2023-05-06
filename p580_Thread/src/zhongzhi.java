public class zhongzhi {
    public static void main(String[] args) throws InterruptedException {
        // T t1 = new T();
        // t1.start();

        //如果希望main线程控制t1 线程的终止，必须可以修改loop
        //让t1退出run方法，从而终止t1线程 -> 通知方式

        //让主线程休眠10s，再通知t1线程退出
        // System.out.println("main线程休眠10s...");
        // Thread.sleep(10*1000);
        // t1.setLoop(false);


        // TM1 t = new TM1();
        // t.setName("mike");
        // t.setPriority(Thread.MIN_PRIORITY); //1
        // t.start();

        // //主线程打印5 hi，然后中断子线程的休眠
        // for(int i=0;i<5;i++){
        //     Thread.sleep(1000);
        //     System.out.println("hi "+ i);
        // }
        // System.out.println(t.getName()+"线程的优先级 = "+t.getPriority()); //1
        // t.interrupt(); //当执行到这时，中断t线程的休眠

        TM2 t2 = new TM2();
        t2.start();
        for(int i=1;i<=20;i++){
            Thread.sleep(1000);
            System.out.println("主线程(小弟) 吃了 "+i+" 包子");
            if(i==5){
                System.out.println("主线程(小弟) 让 子线程(老大) 先吃");
                t2.join(); //让t2全部执行完毕(肯定成功)

                // yield 礼让，如果cpu空间很多(资源很丰富)，根本不需要礼让，可能会失败
                // Thread.yield(); (调用想礼让的 对方的yield方法)
                System.out.println("子线程(老大) 吃完了 主线程(小弟) 接着吃...");
            }
        }
    }
}
class T extends Thread{
    private int count = 0;
    private boolean loop = true;
    @Override
    public void run() {
        while(loop){
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("T 运行中..."+(++count));
        }
    }
    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

//ThreadMethod01
class TM1 extends Thread{ //自定义的线程类
    @Override
    public void run() {
        while(true){
            for(int i=0;i<100;i++){
                //Thread.currentThread().getName() 获取当前线程的名称
                System.out.println(Thread.currentThread().getName()+" 吃包子~~~" + i);
            }
            try{
                System.out.println(Thread.currentThread().getName()+"休眠中~~~");
                Thread.sleep(20000);
            }catch(InterruptedException e){
                //当该线程执行到一个interrupt方法时，会catch一个异常，可加入自己的业务代码
                //InterruptedException 是捕获到一个中断异常
                System.out.println(Thread.currentThread().getName() + "被 interrupt了");
            }
        }
    }
}

//ThreadMethod02
class TM2 extends Thread{ //自定义的线程类
    @Override
    public void run() {
        for(int i=1;i<=20;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程(老大) 吃了"+i+" 个包子");
        }
    }
}



/*
线程终止：
1.当线程完成任务后，会自动退出
2.还可以通过使用变量，来控制run方法退出的方式，停止线程，即通知方式

线程常用方法：
第一组：
1. setName 设置线程名称，使之与参数name相同
2. getName
3. start
4. run
5. setPriority 更改线程的优先级
6. getPriority 获取线程的优先级
7. sleep
8. interrupt 中断线程(并没有真正结束线程，一般用于中断正在休眠的线程)

第二组：
1. yield 线程的礼让。让出cpu，让其他线程执行，但礼让时间不确定，所以也不一定礼让成功。
2. join 线程的插队。插入的线程一旦插队成功，则肯定先执行完插入的线程所有的任务。

第三组：
1.用户线程：也叫工作线程，当线程的任务执行完 或通知方式结束
2.守护线程：一般是为工作线程服务的，当所有的用户线程结束，守护线程自动结束(垃圾回收机制，常见守护线程)

线程6种状态：
New (new后)
Runnable(Ready, Running) (start()后)
Blocked (等待进入同步代码块的锁？)
Waiting (wait(),join(),LockSupport.park())
TimedWaiting (sleep(),wait(),join(),LockSupport.parkNanos(),LockSupport.parkUntil())
Terminated

Synchronized
线程同步机制：
在多线程编程，一些敏感数据不允许被多个线程同时访问，此时使用同步。
保证数据在任何同一时刻，最多有一个线程访问，以保证数据的完整性。
(即当有一个线程在对内存操作时，其他线程都不可以对这个内存地址进行操作，直到该线程完成操作)
具体方法：
1.同步代码块:synchronized(对象){//得到对象的锁，才能操作同步代码}
2.public synchronized void sell(String name){//需要被同步的代码}

互斥锁
每个对象都对应于一个可称为"互斥锁"的标记，这个标记用来保证在任一时刻，只能有一个线程访问该对象。
关键字synchronized来与对象的互斥锁联系。
局限性：同步导致程序的执行效率要降低
同步方法(非静态)：的锁可以是this，也可以是其他对象(要求是同一个对象)
同步方法(静态)：的锁为当前类本身

线程的死锁：
多个线程都占用了对方的锁资源，不肯相让，导致了死锁。(在编程中需要避免)


以下方法会释放锁：
1.当前线程的同步方法，同步代码块执行结束
2.当前线程在同步代码块，同步方法中遇到break，return
3.当前线程在同步代码块，同步方法中出现了未处理的Error或Exception，导致异常结束
4.当前线程在同步代码块，同步方法中执行了线程对象的wait()方法，当前线程暂停，并释放锁。(一会再回来)

以下操作不会释放锁：
1.线程执行同步代码块或同步方法时，程序调用Thread.sleep(),Thread.yield()方法会暂停当前线程的执行，不会释放锁
2.线程执行同步代码块时，其他线程调用该线程的suspend()方法将该线程挂起，该线程不会释放锁。
(避免使用suspend(),resume()控制线程，方法不再推荐使用)

8:30
看到p605
*/
