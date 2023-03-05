public class p424_3_1_test {
    public p424_3_1_test(){
        Inner i1 = new Inner();
        i1.x = 10;

        Inner i2 = new Inner();
        System.out.println(i2.x);

    }
    class Inner{
        private int x=5;
    }
    public static void main(String[] args) {
        p424_3_1_test test = new p424_3_1_test();
        Inner i3 = test.new Inner();
        System.out.println(i3.x);
    }
}


