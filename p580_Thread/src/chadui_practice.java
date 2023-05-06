public class chadui_practice {
    public static void main(String[] args) throws InterruptedException{
        Thread t = new Thread(new T());
        for(int i=1;i<=10;i++){
            System.out.println("hi "+i);
            if(i==5){
                t.start(); //启动子线程 输出hello... (必须先start)
                t.join();
                System.out.println("子线程结束...");
            }
            Thread.sleep(1000);
        }
        System.out.println("主线程结束...");
        
    }
}
class T implements Runnable{
    private int count = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("hello "+(++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count==10){
                break;
            }
        }
    }
}
