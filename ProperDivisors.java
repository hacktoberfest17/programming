public class ProperDivisors{
  public static void main(String[] cmdLn){
    int n = Integer.parseInt(cmdLn[0]);
    System.out.println("i Number Proper divisors");
    // For all i from 2 to n:
    for(int i = 2; i <= n; i++){
      // Count the number of proper divisors of i:
      int pd = 0;
      for(int k = 2; k < i; k++){
        // if k divides i (k is a divisor of i) we will count one more npd!
        if(i % k == 0){
          pd = pd + 1;
        }
      }
      // print i and the number of proper divisors of i:
      System.out.println(i + " " + pd);
    }
  }
}

