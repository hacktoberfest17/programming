import java.util.Scanner;

class Fibonacci {
  public static void main(String[] args) {
    System.out.print("Enter the number of terms: ");
    Scanner scan = new Scanner(System.in);
    long num = scan.nextLong();
    printFibonacciSeries(num);
  }

  private static void printFibonacciSeries(long num) {
    long fibnminus1 = 1, fibnminus2 = 1;
    StringBuilder stringbuilder = new StringBuilder();
    while (num-- > 0) {
      stringbuilder.append(fibnminus1);
      if (num > 0) {
        stringbuilder.append(", ");
      }
      long fibntmp = fibnminus1;
      fibnminus1 = fibnminus2;
      fibnminus2 = fibnminus2 + fibntmp;
    }
    System.out.println(stringbuilder);
  }
}
