public class nmnbl_shijian {
    public static void main(String[] args) {
        //匿名内部类当作参数直接传递
        f1(new IA() {
            @Override
            public void show(){
                System.out.println("这是一幅名画");
            }
        });

        f1(new lei());
        
        cellPhone c = new cellPhone();
        c.alarmBlock(new Bell() {
            public void ring(){
                System.out.println("懒猪起床了");
            }
        });
    }
    
    public static void f1(IA ia){
        ia.show();
    }
}
class cellPhone{
    public void alarmBlock(Bell bell){
        bell.ring();
    }

}
interface Bell{
    void ring();
}
interface IA{
    void show();
}
class lei implements IA{
    public void show(){
        System.out.println("这是一幅名画哈哈哈");
    }
}