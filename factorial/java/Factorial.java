import java.util.Scanner;
/**
 * Created by buddhimah on 10/16/2017.
 */
public class Factorial {
    int result[10000];
    public static  int fac(int number){
        if (number >= 0) {
          result[0] = 1;
          for (int i = 1; i <= n; ++i) {
             result[i] = i * result[i - 1];
          }
          return result[n];
        }
   }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num =sc.nextInt();
        if(num < 0){
            Error a = new Error("factorial for negative numbers is undefined");
            System.out.println(a.getMessage());
            Factorial.main(new String[1]);
        }else {
            System.out.println(fac(num));
        }
    }
}
