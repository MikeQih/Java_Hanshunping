import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JFrame;

public class Game01 extends JFrame{
    MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Game01 game01 = new Game01();
    }
    public Game01(){
        System.out.println("请输入选择：1.新游戏 2.继续上局游戏");
        String key = scanner.next();
        mp = new MyPanel(key);
        //将mp放入到Thread，并启动
        Thread thread = new Thread(mp);
        thread.start();
        
        this.add(mp); //面板(游戏区域)
        this.setSize(1300,750);
        this.addKeyListener(mp); //让JFrame 监听mp的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //在JFrame中增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
//到p652