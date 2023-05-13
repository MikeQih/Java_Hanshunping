public class InputAndOutput {
    public static void main(String[] args) {
        //System.in 表示输入 键盘
        //编译类型：InputStream，运行类型：BufferedInputStream
        //eg. Scanner scanner = new Scanner(System.in); 键盘输入
        System.out.println(System.in.getClass());

        //System.out 输出 显示器(控制台)
        //编译类型：PrintStream，运行类型：PrintStream
        System.out.println(System.out.getClass());
    }
}
