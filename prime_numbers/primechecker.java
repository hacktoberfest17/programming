/**
 * Author: Aman Vishnani
 * Github: http://github.com/amanvishnani
 */
public class primechecker {

    public static void main(String Args[]) {
        System.out.println(isPrime(71));
    }
    
    public static boolean isPrime(long number)
    {
        if(number == 2 ||number == 3)
            return true;
        else {
            for (long i = 1; (6 * i - 1) <= Math.sqrt(number); i++) {
                if ((6 * i - 1) <= Math.sqrt(number) && number % (6 * i - 1) == 0)
                    return false;
                if ((6 * i + 1) <= Math.sqrt(number)&& number % (6 * i + 1) == 0)
                    return false;
            }
        }
        return true;
    }
}