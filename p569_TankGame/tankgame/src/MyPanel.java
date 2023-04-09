import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JPanel;

//为了监听键盘事件，实现KeyListener
public class MyPanel extends JPanel implements KeyListener{
    //坦克大战绘图区域
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>(); //Vector线程安全
    int enemyTankSize = 3;

    public MyPanel(){
        hero = new Hero(100, 100); //初始化自己的坦克
        // hero.setSpeed(10); //默认速度为5

        //初始化敌人的坦克
        for(int i=0;i<enemyTankSize;i++){
            EnemyTank enemyTank = new EnemyTank((100*(i+1)),0);
            enemyTank.setDir(2);
            enemyTanks.add(enemyTank);
        }
        
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); //默认黑色

        //画出自己的坦克
        drawTank(hero.getX(),hero.getY(),g,hero.getDir(),1); //type=1 是己方黄色坦克；type=0 是敌方青色坦克;
        
        //画出敌人的坦克
        for(int i=0;i<enemyTanks.size();i++){
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDir(), 0);

        }

    }
    

    //画坦克写在一个方法里
    /**
     * 
     * @param x 坦克左上角x
     * @param y 坦克左上角y
     * @param g 画笔
     * @param dir 坦克方向(上下左右)
     * @param type 坦克类型(敌/我)
     */
    public void drawTank(int x,int y,Graphics g,int dir,int type){ //直接 /**+回车 会出来对应注释
        switch(type){
            case 0: //敌方
                g.setColor(Color.CYAN); //青色
                break;
            case 1: //我方坦克
                g.setColor(Color.YELLOW); //黄色
                break;
        }

        //根据方向绘制坦克
        //dir 表示方向(顺时针)：0-上，1-右，2-下，3-左
        switch(dir){
            case 0: //向上移动
                g.fill3DRect(x, y, 10, 60, false); //填充一个3D高亮矩形 //左轮子
                g.fill3DRect(x+30, y, 10, 60, false); //右轮子
                g.fill3DRect(x+10, y+10, 20, 40, false); //身体
                g.fillOval(x+10, y+20, 20, 20); //圆盖(炮台)
                g.drawLine(x+20, y+30, x+20, y); //炮管
                break;

            case 1: //向右移动
                g.fill3DRect(x, y, 60, 10, false); //左轮子
                g.fill3DRect(x, y+30, 60, 10, false); //右轮子
                g.fill3DRect(x+10, y+10, 40, 20, false); //身体
                g.fillOval(x+20, y+10, 20, 20); //圆盖(炮台)
                g.drawLine(x+30, y+20, x+60, y+20); //炮管
                break;

            case 2: //向下移动
                g.fill3DRect(x, y, 10, 60, false); //左轮子
                g.fill3DRect(x+30, y, 10, 60, false); //右轮子
                g.fill3DRect(x+10, y+10, 20, 40, false); //身体
                g.fillOval(x+10, y+20, 20, 20); //圆盖(炮台)
                g.drawLine(x+20, y+30, x+20, y+60); //炮管
                break;

            case 3: //向左移动
                g.fill3DRect(x, y, 60, 10, false); //左轮子
                g.fill3DRect(x, y+30, 60, 10, false); //右轮子
                g.fill3DRect(x+10, y+10, 40, 20, false); //身体
                g.fillOval(x+20, y+10, 20, 20); //圆盖(炮台)
                g.drawLine(x+30, y+20, x, y+20); //炮管
                break;
            default:
                System.out.println("暂时还未处理");
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    //处理wdsa键 按下后的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){ // w键
            hero.setDir(0);
            //y--
            hero.moveUp();
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            hero.setDir(1);
            hero.moveRight();
        }
        else if(e.getKeyCode() == KeyEvent.VK_S){
            hero.setDir(2);
            hero.moveDown();
        }
        else if(e.getKeyCode() == KeyEvent.VK_A){
            hero.setDir(3);
            hero.moveLeft();
        }
        //让面板重绘
        this.repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
