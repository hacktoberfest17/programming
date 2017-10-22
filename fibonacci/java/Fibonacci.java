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
