import java.util.Scanner;

class Fibonacci {
  public static void main(String[] args) {
    System.out.print("Enter the number of terms: ");
    Scanner scan = new Scanner(System.in);
    long num = scan.nextLong();
    printFibonacciSeries(num);
  }

  private static void printFibonacciSeries(long num) {
    long a = 1, b = 1;
      
      if (num == 1) 
        System.out.println(a);
      else if(num==2)
        System.out.println(a+","+b);
      else{
      for(int i=3;i<=num;i++)
      {
         long tmp = a+b;
        a=b;
        b=tmp;
        System.out.println(","+tmp);
      }
  }
}
}
