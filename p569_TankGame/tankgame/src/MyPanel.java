import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JPanel;

//为了监听键盘事件，实现KeyListener
//为了让MyPanel不停重绘子弹，需要将MyPanel实现Runnable，当做一个线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable{
    //坦克大战绘图区域
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>(); //Vector线程安全
    //定义一个存放Node对象的Vector，用于恢复敌人坦克的坐标和方向
    Vector<Node> nodes = new Vector<>();
    int enemyTankSize = 3;

    //定义一个Vector，用于存放炸弹
    //当子弹击中坦克时，加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    //定义三张炸弹图片，显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    

    public MyPanel(String key){
        //先判断记录的文件是否存在
        //如存在，正常执行；如不存在，提示只能开始新游戏，key="1"
        File file = new File(Recorder.getRecordFile());
        if(file.exists()){
            nodes = Recorder.getNodesAndEnemyTankRec();
        } else{
            System.out.println("文件不存在，只能开启新的游戏");
            key = "1";
        }

        //将MyPanel的enemyTanks设置给Recorder的enemyTanks
        Recorder.setEnemyTanks(enemyTanks);
        hero = new Hero(500, 100); //初始化自己的坦克
        // hero.setSpeed(10); //默认速度为5

        switch(key){
            case "1": //新游戏
                //初始化敌人的坦克
                for(int i=0;i<enemyTankSize;i++){
                    EnemyTank enemyTank = new EnemyTank((100*(i+1)),0);
                    //将enemyTanks设置给enemyTank ！！！
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setDir(2);
                    
                    //启动敌人坦克的线程，让他们动起来
                    new Thread(enemyTank).start();

                    //给该enemyTank加入一颗子弹
                    Shot shot = new Shot(enemyTank.getX()+20, enemyTank.getY()+60, enemyTank.getDir());
                    //加入enemyTank的Vector成员
                    enemyTank.shots.add(shot);
                    new Thread(shot).start();

                    enemyTanks.add(enemyTank);
                }
                break;
    
            case "2": //继续上局游戏
                //初始化敌人的坦克
                for(int i=0;i<nodes.size();i++){
                    Node node = nodes.get(i);
                    EnemyTank enemyTank = new EnemyTank(node.getX(),node.getY());
                    //将enemyTanks设置给enemyTank ！！！
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setDir(node.getDir());
                    
                    //启动敌人坦克的线程，让他们动起来
                    new Thread(enemyTank).start();

                    //给该enemyTank加入一颗子弹
                    Shot shot = new Shot(enemyTank.getX()+20, enemyTank.getY()+60, enemyTank.getDir());
                    //加入enemyTank的Vector成员
                    enemyTank.shots.add(shot);
                    new Thread(shot).start();

                    enemyTanks.add(enemyTank);
                }
                break;

            default:
                System.out.println("你的输入有误...");
        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb1.png")); //前面加不加"/" 都行
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb3.png"));
    }

    //编写方法，显示我方击毁敌方坦克信息
    public void showInfo(Graphics g){
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("您已累计击毁敌方坦克",1020,30);
        drawTank(1020, 60, g, 0, 0);
        g.setColor(Color.BLACK);//drawTank把color改了，所以改回黑色
        g.drawString(Recorder.getAllEnemyTankNum()+"",1080,100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        showInfo(g);
        g.fillRect(0, 0, 1000, 750); //默认黑色

        //画出自己的坦克
        if(hero!=null && hero.isLive){
            drawTank(hero.getX(),hero.getY(),g,hero.getDir(),1); //type=1 是己方黄色坦克；type=0 是敌方青色坦克;
        }
    
        //画出hero射出的子弹
        // if(hero.shot!=null && hero.shot.isLive!=false){
        //     g.draw3DRect(hero.shot.x, hero.shot.y, 1, 1, false);
        // }
        //将hero的子弹集合 shots，遍历取出绘制
        for(int i=0;i<hero.shots.size();i++){
            Shot shot = hero.shots.get(i);
            if(hero.shot!=null && shot.isLive){
                g.draw3DRect(shot.x, shot.y, 1, 1, false);
            }
            else{//如果已经无效，从shots集合中拿掉
                hero.shots.remove(shot);
            }
        }

        //如果bombs集合中有对象，就画出
        for(int i=0;i<bombs.size();i++){
            try {
                Thread.sleep(50); //不休眠第一个坦克炸不了
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Bomb bomb = bombs.get(i);
            if(bomb.life>6){
                g.drawImage(image3,bomb.x,bomb.y,60,60,this); //宽高60
            }
            else if(bomb.life>3){
                g.drawImage(image2,bomb.x,bomb.y,60,60,this); //宽高60
            }
            else{
                g.drawImage(image1,bomb.x,bomb.y,60,60,this); //宽高60
            }
            //循环每次让炸弹生命值减少
            bomb.lifeDown();
            if(bomb.life == 0){
                bombs.remove(bomb);
            }
        }


        //画出敌人的坦克
        for(int i=0;i<enemyTanks.size();i++){
            EnemyTank enemyTank = enemyTanks.get(i);
            if(enemyTank.isLive){ //当敌人坦克活着时
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDir(), 0);
                //画出enemyTank所有子弹
                for(int j=0;j<enemyTank.shots.size();j++){
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    //绘制
                    if(shot.isLive){
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                    }
                    else{
                        //从Vector(shots)中移除
                        enemyTank.shots.remove(shot);
                    }
                }
            }
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

    public void hitEnemyTank(){
        for(int j=0;j<hero.shots.size();j++){
            Shot shot = hero.shots.get(j);
            //判断是否击中敌方坦克
            if(shot!=null && shot.isLive){ //当子弹还存活
                for(int i=0;i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(hero.shot, enemyTank);
                }
            }
        }
        
    }

    //判断敌人坦克击中我方坦克
    public void hitHero(){
        for(int i=0;i<enemyTanks.size();i++){
            EnemyTank enemyTank = enemyTanks.get(i);
            for(int j=0;j<enemyTank.shots.size();j++){
                Shot shot = enemyTank.shots.get(j);
                if(shot.isLive && hero.isLive){
                    hitTank(shot, hero);
                }
            }
        }
    }

    //判断我方子弹是否击中地方坦克
    public void hitTank(Shot s,Tank enemyTank){
        //判断s 击中坦克
        switch(enemyTank.getDir()){
            case 0: //上            
            case 2: //下
                if(s.x>enemyTank.getX() && s.x<enemyTank.getX()+40 && s.y>enemyTank.getY() && s.y<enemyTank.getY()+60){
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //子弹击中后，把enemyTank从Vector拿掉
                    enemyTanks.remove(enemyTank);

                    //当我方击毁一个敌方坦克时，就对allEnemyTankNum++
                    //因为enemyTank可以是Hero，也可以是EnemyTank
                    if(enemyTank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNum();
                    }

                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1: //右
            case 3: //左
                if(s.x>enemyTank.getX() && s.x<enemyTank.getX()+60 && s.y>enemyTank.getY() && s.y<enemyTank.getY()+40){
                    s.isLive = false;
                    enemyTank.isLive = false;
                    enemyTanks.remove(enemyTank);
                    if(enemyTank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNum();
                    }
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
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
            if(hero.getY()>0){
                hero.moveUp();
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            hero.setDir(1);
            if(hero.getX()+60<1000){
                hero.moveRight();
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_S){
            hero.setDir(2);
            if(hero.getY()+60<750){
                hero.moveDown();
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_A){
            hero.setDir(3);
            if(hero.getX()>0){
                hero.moveLeft();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_J){
            // System.out.println("用户按下了J，开始射击");
            //判断hero的子弹是否销毁
            // if(hero.shot==null || !hero.shot.isLive){
            //     hero.shotEnemyTank();
            // }

            //发射多颗子弹
            hero.shotEnemyTank(); 
        }
        //让面板重绘
        this.repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    @Override
    public void run() {
        //每隔100ms，重绘区域，刷新绘图区域，子弹就移动
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hitEnemyTank();
            hitHero();
            this.repaint();
        }
        
    }
    
}
