import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ball_move extends JFrame{
    MyPanel mp = null;
    public static void main(String[] args) {
        ball_move ballMove = new ball_move();
    }
    public ball_move(){ //构造器
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        //窗口JFrame 对象可以监听键盘事件，即可以监听到面板发生的键盘事件
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}

//画板 画出小球
class MyPanel extends JPanel implements KeyListener{ //KeyListener是监听器，可以监听键盘事件

    //为了让小球移动，把左上角(x,y)设置成变量
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    //有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {
    }

    //按下某个键，方法就会触发
    @Override
    public void keyPressed(KeyEvent e) {
        // System.out.println((char)e.getKeyCode()+"被按下");

        //根据用户按下的不同键，处理小球的移动(上下左右)
        if(e.getKeyCode() == KeyEvent.VK_DOWN){ //向下箭头
            y+=10;
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP){ //向下箭头
            y-=10;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){ //向下箭头
            x-=10;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){ //向下箭头
            x+=10;
        }
        //改变后，让面板重绘
        this.repaint();


    }

    //当某个键释放(松开)，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {
    }

    
}
