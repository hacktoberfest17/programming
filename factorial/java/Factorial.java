import java.util.Scanner;
/**
 * Created by buddhimah on 10/16/2017.
 */
public class Factorial {
    public static  int fac(int number){
        if(number == 1){
            return 1;
        }
        return ( fac(number - 1)*number);
        
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
