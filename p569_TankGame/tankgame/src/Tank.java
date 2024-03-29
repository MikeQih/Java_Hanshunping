public class Tank {
    private int x; //坦克横坐标
    private int y; //坦克纵坐标
    private int dir; //0 1 2 3 上右下左
    private int speed = 5; //坦克速度
    boolean isLive = true;

    
    public void moveUp(){
        y -= speed; 
    }
    public void moveRight(){
        x += speed;
    }
    public void moveDown(){
        y += speed;
    }
    public void moveLeft(){
        x -= speed;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getDir() {
        return dir;
    }
    public void setDir(int dir) {
        this.dir = dir;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
}
