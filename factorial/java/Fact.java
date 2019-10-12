import java.util.*;

public class Fact{
  public static int fact(int n){
    if(n==0) return 1;
    else return(n * fact(n-1));
  }

  public static void main(String [] args){
    System.out.print("Please input your number ");
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    System.out.println("Factorial of "+ n +" is "+ fact(n));
  }
}