import java.util.Scanner;

class Fibonacci {
  public static void main(String[] args) {
    System.out.print("Enter the number of terms: ");
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(reader);
    String num = Long.parseLong();
   
    printFibonacciSeries(num);
  }

  private static void printFibonacciSeries(long num) {
    long a = 1, b = 1;
    StringBuilder sb = new StringBuilder();
    while (num-- > 0) {
      sb.append(a);
      if (num > 0) {
        sb.append(", ");
      }
      long tmp = a;
      a = b;
      b = b + tmp;
    }
    System.out.println(sb);
  }
}
