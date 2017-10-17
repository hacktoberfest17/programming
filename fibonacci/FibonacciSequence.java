
import java.util.LinkedList;
import java.util.List;
/**
 * Created by trustgeek on 10/15/2017 {4:08 PM}.
 */
public class FibonacciSequence {
    /*
    * Fibonacci sequence:
    * -------
    * Return 0 if n is 0
    * Return 1 for case 1 and 2
    * */
    public static int fibonacci(int n) {
        if (n < 1) return n;
        if (n == 1 || n == 2) return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /*
    * (n - 1) since has preceeding 0
    * */
    public static int getFibonacciAt(int n) {
        return fibonacci(n - 1);
    }

    /*
    * get list of the fibonacci upto n terms
    * */
    public static List<Integer> getFibonacci(int n) {
        List<Integer> fibonacciSeq = new LinkedList<Integer>();
        for (int i = 0; i < n; i++)
            fibonacciSeq.add(fibonacci(i));
        return fibonacciSeq;
    }

    /*
    * get fibonacci sequence upto the number n
    * */
    public static List<Integer> getUptoFibonacci(int n) {
        int i = 0, fib = 0;
        List<Integer> fibonacciSeq = new LinkedList<Integer>();
        while (fib <= n) {
            fib = fibonacci(i);
            if (fib <= n) fibonacciSeq.add(fib);
            i++;
        }
        return fibonacciSeq;
    }

    public static void main(String[] args) {
        int n = 20;

        System.out.println("Fibonacci at position n = " + getFibonacciAt(n));
        System.out.println("Fibonacci upto nth terms = " + getFibonacci(n));
        System.out.println("Fibonacci upto n value = " + getUptoFibonacci(n));

    }
}
