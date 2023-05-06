public class deadlock {
    public static void main(String[] args) {
        DeadLockDemo A = new DeadLockDemo(true);
        A.setName("A线程");
        DeadLockDemo B = new DeadLockDemo(false);
        B.setName("B线程");

        A.start();
        B.start();
    }
}
class DeadLockDemo extends Thread{
    static Object o1 = new Object(); //保证多线程，共享一个对象，使用static
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag){
        this.flag = flag;
    }

    /*
    业务逻辑分析：
    1.如果flag为true，线程A先得到/持有o1对象锁，然后尝试获取o2对象锁
    如果A得不到o2对象锁，就会blocked
    2.如果flag为false，同上
    */
    @Override
    public void run() {
        if(flag){
            synchronized(o1){ //synchronized代码块 默认放对象(不是synchronized方法)
                System.out.println(Thread.currentThread().getName()+" 进入1");
                synchronized(o2){
                    System.out.println(Thread.currentThread().getName()+" 进入2");
                }
            }
        }
        else{
            synchronized(o2){ //synchronized代码块 默认放对象(不是synchronized方法)
                System.out.println(Thread.currentThread().getName()+" 进入3");
                synchronized(o1){
                    System.out.println(Thread.currentThread().getName()+" 进入4");
                }
            }
        }
    }
}
