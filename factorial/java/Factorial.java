import java.util.Scanner;
/**
 * Created by buddhimah on 10/16/2017.
 */
public class Factorial {
    public static  int fac(int number) {
        int result;
        if (number == 1) {
            return 1;
        }
        result = fac(number - 1) * number;
        return result;
    }
    
   public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        try {
            int num = sc.nextInt();
            System.out.println(fac(num));
        } catch (Exception e) {
            System.err.println("Illegal number: " + sc.next() + "!");
        }
    }
}
