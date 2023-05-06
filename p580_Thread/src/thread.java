public class thread {
    
    public static void main(String[] args) throws InterruptedException {
        // Runtime runtime = Runtime.getRuntime();
        // //获取当前电脑的cpu数量 //8核
        // int cpuNums = runtime.availableProcessors();
        // System.out.println("当前有CPU个数为："+cpuNums);

        Cat cat = new Cat();
        // cat.run(); //直接cat.run()的话，因为run就是个普通的方法，并没有启动多线程。运行完run才运行下面的。(线程名是main)
        cat.start(); //启动线程
        //说明：当main线程启动一个子线程(Thread-0)，主线程不会阻塞，会继续执行
        //这时，主线程和子线程是交替执行
        System.out.println("主线程继续执行"+Thread.currentThread().getName());
        for(int i=0;i<5;i++){
            System.out.println("主线程 i="+i);
            //让主线程休眠
            Thread.sleep(1000);
        }

    }
}
/*
1.当一个类继承了Thread类，该类就可以当作线程使用
2.重写run方法，写上自己的业务代码
3.Thread类实现了Runnable接口的run方法
*/
class Cat extends Thread{
    int times = 0;
    @Override
    public void run() {
        while(true){
            //该线程每隔一秒，在控制台输出“我是小猫咪”
            System.out.println("我是小猫咪"+(++times)+" 线程名="+Thread.currentThread().getName());
            
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            if(times==3){
                break;
            }
        }
    }
}
/*
线程相关概念：
程序(program)：是为完成特定任务，用某种语言编写的一组指令的集合。(简单说就是我们写的代码)

进程：
1.进程是指运行中的程序，eg.使用QQ，就启动了一个进程，操作系统就会为该进程分配内存空间
2.进程是程序的一次执行过程，或是正在运行的一个程序。是动态的过程，有它自身的产生，存在和消亡的过程。

线程：
1.线程由进程创建，是进程的实体，
2.一个进程可以拥有多个线程

其他相关概念：
1.单线程：同一个时刻，只允许执行一个线程
2.多线程：同一个时刻，可以执行多个线程  eg.一个QQ进程可以同时打开多个聊天窗口
3.并发：同一时刻，多个任务交替进行，造成一种“貌似同时”的错觉。(单核CPU实现的多任务就是并发)
4.并行：同一时刻，多个任务同时执行。(多核CPU可以实现并行)

创建线程的两种方式：
1.继承Thread类，重写run方法
2.实现Runnable接口，重写run方法

可以使用jconsole监控线程执行情况 (进程->主线程->Thread-0线程)
(不一定主线程结束，进程就结束；如果还有其他的子线程在运行，就并不会造成应用程序的结束) eg.主60，子80

真正实现多线程的是start0()，而不是run 

继承Thread vs 实现Runnable接口
1.从Java设计来看，继承Thread或实现Runnable接口来创建线程本质没有区别。jdk文档中Thread类本身就实现了Runnable接口。
2.实现Runnable接口的方式 更适合多个线程共享一个资源的情况，而且避免了单继承的限制。(建议使用Runnable接口的方式)

*/
