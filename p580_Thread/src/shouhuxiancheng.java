public class shouhuxiancheng {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();

        //如果希望当main线程结束后，子线程自动结束，只需将子线程设为守护线程即可
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();        

        for(int i=1;i<=10;i++){ //main线程
            System.out.println("宝强在辛苦地工作...");
            Thread.sleep(1000);
        }
    }
}
class MyDaemonThread extends Thread{ //Daemon 后台驻留程序
    @Override
    public void run() {
        for(;;){ //无限循环
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("马蓉和宋喆快乐聊天...");
        }
    }
}
//看到p593 8:13
