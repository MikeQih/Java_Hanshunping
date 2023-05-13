import java.util.Vector;

public class Hero extends Tank{
    //定义一个Shot对象，表示一个射击(线程)
    Shot shot = null;
    Vector<Shot> shots = new Vector<>();
    //自己的坦克
    public Hero(int x,int y){
        super(x,y);
    }
    public void shotEnemyTank(){
        //控制在面板上，最多5颗子弹
        if(shots.size()==3){
            return;
        }

        //根据当前Hero对象的位置和方向创建Shot
        switch(getDir()){
            case 0:
                shot = new Shot(getX()+20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX()+60, getY()+20, 1);
                break;
            case 2:
                shot = new Shot(getX()+20, getY()+60, 2);
                break;  
            case 3:
                shot = new Shot(getX(), getY()+20, 3);
                break; 
        }

        shots.add(shot);
        //启动Shot线程
        new Thread(shot).start();
    }
}
