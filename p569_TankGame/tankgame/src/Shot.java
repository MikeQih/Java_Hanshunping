//射击子弹
public class Shot implements Runnable{
    int x; //子弹x坐标
    int y; //子弹y坐标
    int direct = 0; //子弹方向
    int speed = 6; //子弹速度
    boolean isLive = true; //子弹是否存活

    
    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }


    @Override
    public void run() { //射击
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //根据方向改变x，y坐标
            switch(direct){
                case 0:
                    y-=speed;
                    break;
                case 1:
                    x+=speed;
                    break;
                case 2:
                    y+=speed;
                    break;
                case 3:
                    x-=speed;
                    break;
            }
            //测试坐标
            // System.out.println("子弹 x="+x+" y="+y);
            if(!(x>=0 && x<=1000 && y>=0 && y<=750 && isLive)){
                // System.out.println("子弹线程退出");
                isLive = false;
                break;
            }
        }
    }
    
}
