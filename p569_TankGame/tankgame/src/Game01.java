import javax.swing.JFrame;

public class Game01 extends JFrame{
    MyPanel mp = null;
    public static void main(String[] args) {
        Game01 game01 = new Game01();
    }
    public Game01(){
        mp = new MyPanel();
        this.add(mp); //面板(游戏区域)
        this.setSize(1000,750);
        this.addKeyListener(mp); //让JFrame 监听mp的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
