import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {
        // Scanner num = new Scanner(System.in);
        // System.out.println("请输入两个整数：");
        try{
            if(args.length!=2){
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            int n1 = Integer.parseInt(args[0]); //直接在命令行输入: cd "/Users/hengchangqi/c_vscode/Java_Hanshunping/p444_Exception/src/" && javac hw1.java && java hw1 20 2
            int n2 = Integer.parseInt(args[1]);
            double res = cal(n1, n2);
            System.out.println(res);
            // int i = Integer.parseInt(num.next());
            // int j = Integer.parseInt(num.next());
            // System.out.println("result= "+cal(i, j));
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
    public static double cal(int n1, int n2){
        return n1/n2;
    }
}
/*
13:45
*/

