package Programming.programming.count_prime_numbers;

import java.util.Scanner;

public class prime_number_count {


        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the Lower Bound");
            int lowerBound = in.nextInt();
            System.out.println("Enter the Upper Bound");
            int upperBound = in.nextInt();

            int count = countPrimes(lowerBound, upperBound);

            System.out.println("The number of prime numbers between " + lowerBound + " and " + upperBound + " is: " + count);
        }

        // Function to check if a number is prime
        public static boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }
            if (number <= 3) {
                return true;
            }
            if (number % 2 == 0 || number % 3 == 0) {
                return false;
            }
            for (int i = 5; i * i <= number; i += 6) {
                if (number % i == 0 || number % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }

        // Function to count prime numbers between two integers
        public static int countPrimes(int lower, int upper) {
            int count = 0;
            for (int i = lower; i <= upper; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            return count;
        }
    }




