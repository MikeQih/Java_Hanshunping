import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{

    //在敌人坦克类，使用Vector保存多个Shot
    Vector<Shot> shots = new Vector<>();
    Vector<EnemyTank> enemyTanks = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //将MyPanel的成员Vector<EnemyTank> enemyTanks = new Vector<>();
    //设置到EnemyTank的成员enemyTanks ??
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks){
        this.enemyTanks = enemyTanks;
    }

    //判断当前敌人坦克，是否和enemyTanks中的其他坦克发生重叠或碰撞
    public boolean isTouchEnemyTank(){
        switch(this.getDir()){
            case 0:
                for(int i=0;i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if(enemyTank!=this){ //不是自己
                        //敌人坦克上/下：x范围(x,x+40);y(y,y+60)
                        if(enemyTank.getDir()==0 || enemyTank.getDir()==2){ //敌人坦克是上/下
                            //当前坦克：x范围(x,x+40);y(y,y)
                            if(this.getX()>=enemyTank.getX() && this.getX()<=enemyTank.getX()+40 
                                    && this.getY()>=enemyTank.getY() && this.getY()<=enemyTank.getY()+60){
                                return true;
                            }
                            if(this.getX()+40>=enemyTank.getX() && this.getX()+40<=enemyTank.getX()+40 
                                    && this.getY()>=enemyTank.getY() && this.getY()<=enemyTank.getY()+60){
                                return true;
                            }

                        }

                        //敌人坦克右/左：x范围(x,x+60);y(y,y+40)
                        if(enemyTank.getDir()==1 || enemyTank.getDir()==3){ //右/左
                            if(this.getX()>=enemyTank.getX() && this.getX()<=enemyTank.getX()+60 
                                    && this.getY()>=enemyTank.getY() && this.getY()<=enemyTank.getY()+40){
                                return true;
                            }
                            if(this.getX()+40>=enemyTank.getX() && this.getX()+40<=enemyTank.getX()+60 
                                    && this.getY()>=enemyTank.getY() && this.getY()<=enemyTank.getY()+40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                for(int i=0;i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if(enemyTank!=this){
                        //敌人坦克上/下：x范围(x,x+40);y(y,y+60)
                        if(enemyTank.getDir()==0 || enemyTank.getDir()==2){ //敌人坦克是上/下
                            //右上角
                            //当前坦克：x+60;y
                            if(this.getX()+60>=enemyTank.getX() && this.getX()+60<=enemyTank.getX()+40 
                                    && this.getY()>=enemyTank.getY() && this.getY()<=enemyTank.getY()+60){
                                return true;
                            }

                            //右下角
                            //当前坦克：x+60;y+40
                            if(this.getX()+60>=enemyTank.getX() && this.getX()+60<=enemyTank.getX()+40 
                                    && this.getY()+40>=enemyTank.getY() && this.getY()+40<=enemyTank.getY()+60){
                                return true;
                            }

                        }
                        //敌人坦克右/左：x范围(x,x+60);y(y,y+40)
                        if(enemyTank.getDir()==1 || enemyTank.getDir()==3){
                            if(this.getX()+60>=enemyTank.getX() && this.getX()+60<=enemyTank.getX()+60 
                                    && this.getY()>=enemyTank.getY() && this.getY()<=enemyTank.getY()+40){
                                return true;
                            }
                            //右下
                            if(this.getX()+60>=enemyTank.getX() && this.getX()+60<=enemyTank.getX()+60 
                                    && this.getY()+40>=enemyTank.getY() && this.getY()+40<=enemyTank.getY()+40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2:
                for(int i=0;i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if(enemyTank!=this){
                        //敌人坦克上/下：x范围(x,x+40);y(y,y+60)
                        if(enemyTank.getDir()==0 || enemyTank.getDir()==2){ //敌人坦克是上/下
                            //左下角
                            if(this.getX()>=enemyTank.getX() && this.getX()<=enemyTank.getX()+40 
                                    && this.getY()+60>=enemyTank.getY() && this.getY()+60<=enemyTank.getY()+60){
                                return true;
                            }

                            //右下角
                            //当前坦克：x+40;y+60
                            if(this.getX()+40>=enemyTank.getX() && this.getX()+40<=enemyTank.getX()+40 
                                    && this.getY()+60>=enemyTank.getY() && this.getY()+60<=enemyTank.getY()+60){
                                return true;
                            }

                        }
                        //敌人坦克右/左：x范围(x,x+60);y(y,y+40)
                        if(enemyTank.getDir()==1 || enemyTank.getDir()==3){
                            //左下
                            if(this.getX()>=enemyTank.getX() && this.getX()<=enemyTank.getX()+60 
                                    && this.getY()+60>=enemyTank.getY() && this.getY()+60<=enemyTank.getY()+40){
                                return true;
                            }
                            //右下
                            if(this.getX()+40>=enemyTank.getX() && this.getX()+40<=enemyTank.getX()+60 
                                    && this.getY()+60>=enemyTank.getY() && this.getY()+60<=enemyTank.getY()+40){
                                return true;
                            }
                        }
                    }
                }
                break; 
            case 3:
                for(int i=0;i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if(enemyTank!=this){
                        //敌人坦克上/下：x范围(x,x+40);y(y,y+60)
                        if(enemyTank.getDir()==0 || enemyTank.getDir()==2){ //敌人坦克是上/下
                            //左上角 x，y
                            if(this.getX()>=enemyTank.getX() && this.getX()<=enemyTank.getX()+40 
                                    && this.getY()>=enemyTank.getY() && this.getY()<=enemyTank.getY()+60){
                                return true;
                            }

                            //左下角
                            //当前坦克：x;y+40
                            if(this.getX()>=enemyTank.getX() && this.getX()<=enemyTank.getX()+40 
                                    && this.getY()+40>=enemyTank.getY() && this.getY()+40<=enemyTank.getY()+60){
                                return true;
                            }

                        }
                        //敌人坦克右/左：x范围(x,x+60);y(y,y+40)
                        if(enemyTank.getDir()==1 || enemyTank.getDir()==3){
                            //左上
                            if(this.getX()>=enemyTank.getX() && this.getX()<=enemyTank.getX()+60 
                                    && this.getY()>=enemyTank.getY() && this.getY()<=enemyTank.getY()+40){
                                return true;
                            }
                            //左下
                            if(this.getX()>=enemyTank.getX() && this.getX()<=enemyTank.getX()+60 
                                    && this.getY()+40>=enemyTank.getY() && this.getY()+40<=enemyTank.getY()+40){
                                return true;
                            }
                        }
                    }
                }
                break;   
        }
        return false;
    }
    
    @Override
    public void run() {
        while(true){
            if(isLive && shots.size()<=1){
                Shot s = null;
                switch(getDir()){
                    case 0:
                        s = new Shot(getX()+20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX()+60, getY()+20, 1);
                        break;
                    case 2:
                        s = new Shot(getX()+20, getY()+60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY()+20, 3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }
            //根据坦克方向继续移动
            switch(getDir()){
                case 0:
                    //让坦克保持一个方向，走30步
                    for(int i=0;i<30;i++){
                        if(getY()>0 && !isTouchEnemyTank()){
                            moveUp();
                        }
                        //休眠50ms
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for(int i=0;i<30;i++){
                        if(getX()+60<1000 && !isTouchEnemyTank()){
                            moveRight();
                        }
                        //休眠50ms
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for(int i=0;i<30;i++){
                        if(getY()+60<750 && !isTouchEnemyTank()){
                            moveDown();
                        }
                        //休眠50ms
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for(int i=0;i<30;i++){
                        if(getX()>0 && !isTouchEnemyTank()){
                            moveLeft();
                        }
                        //休眠50ms
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            //随机改变坦克方向 0-3
            setDir((int)(Math.random()*4)); //返回0-4，取不到4 (因为Math.random()是 [0，1) 的小数)
            // setDir(3); //返回0-4，取不到4 (因为Math.random()是 [0，1) 的小数)

            //写并发程序，要考虑线程什么时候结束 (和在创建enemyTank的地方启动)
            if(!isLive){
                break;
            }
        }
    }
}
