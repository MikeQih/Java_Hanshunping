import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings({"all"})
public class draw_circle extends JFrame{ //JFrame对应窗口，可以理解成一个画框
    //定义一个面板
    private MyPanel mp = null;
    public static void main(String[] args) {
        new draw_circle();
        
    }
    public draw_circle(){ //构造器
        mp = new MyPanel();
        this.add(mp); //把面板放到窗口中
        this.setSize(400,300); //设置窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //点击左上角的"x"，程序退出
        this.setVisible(true);

    }
}
//先定义一个MyPanel，继承JPanel类，画图形，在面板上面
class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g) { //绘图方法
        super.paint(g); //调用父类的方法完成初始化
        // g.drawOval(10, 10, 100, 100);


        // g.drawLine(10, 10, 100, 100);
        // g.setColor(Color.BLUE);
        // g.fillRect(10, 10, 100, 100); //填充矩形

        // g.fillOval(10, 10, 100, 100); //填充椭圆

        //画图片
        // Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("yizi.png"));
        // g.drawImage(image, 10, 10, 100,100,this);

        //画字符串 drawString
        //给画笔设置颜色和字体
        // g.setColor(Color.RED);
        // g.setFont(new Font("隶书",Font.BOLD,50));
        // g.drawString("mike你好", 100, 100); //x,y坐标对应左下角

        //画坦克：两个长矩形，一个圆，一个宽矩形，一条线
        g.setColor(Color.BLUE);
        g.fillRect(10, 10, 10, 60);
        g.fillRect(40, 10, 10, 60);
        g.setColor(Color.RED);
        g.drawOval(20, 30, 20, 20);
        g.setColor(Color.GREEN);
        g.fillRect(20, 20, 20, 40);
        g.fillRect(30, 10, 2, 40);


    }
}
/*
drawOval(int x,int y,int width,int height)
画椭圆，x和y对应椭圆左上角的x，y坐标，width是宽度，height是高度。(width=height时就是圆)

Component类提供了两个和绘图相关的重要方法：
1.paint(Graphics g)绘制组件的外观
2.repaint()刷新组件的外观

组件第一次在屏幕显示的时候，程序会自动调用paint()方法来绘制组件
以下情况paint()会被调用：
1.窗口最小化，再最大化
2.窗口的大小发生变化
3.repaint方法被调用

Java事件处理机制：
采取“委派事件模型“。当事件发生时，产生事件的对象，会把此“消息”传递给"事件的监听者"处理，
这里说的“信息”实际上就是java.awt.event事件类库里某个类所创建的对象，把它称为“事件的对象”。
(事件源会产生一个事件，把该事件/对象 交给监听者处理)

事件源：产生事件的对象 eg.按钮，窗口...
事件：承载事件源状态改变时的对象
事件类型：eg.KeyEvent,ActionEvent,MouseEvent,WindowEvent...
事件监听者接口：事件监听者实际上就是一个类，该类实现了某个事件监听器接口 eg.MyPanel就可以作为一个事件监听者，因为它实现了KeyListener接口

*/
