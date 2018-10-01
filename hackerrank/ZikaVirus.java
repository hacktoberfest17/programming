package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class ZikaVirus {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		 int count = 0, num = 0;
		 BigInteger square;
		 String s;
		 while (count != n) {
		 ++num;
		 BigInteger num1 = BigInteger.valueOf(num);
		 square = num1.multiply(num1);
		
		 s = square.toString();
		 for (int i = 1; i < s.length(); ++i) {
		 BigInteger p, q;
		 p = new BigInteger(s.substring(0, i));
		 q = new BigInteger(s.substring(i));
		 if (p.add(q).compareTo(BigInteger.valueOf(num)) == 0) {
		 ++count;
         System.out.print(num+",");
		// if (count == n)
		// System.out.println(p + " " + q);
		 continue;
		 }
		
		 }
		 }
		 System.out.println(num);
		 scan.close();

//		int[] arr = { 0, 1, 9, 45, 55, 99, 100, 297, 703, 999, 1000, 2223, 2728, 4879, 4950, 5050, 5292, 7272, 7777,
//				9999, 10000, 17344, 22222, 38962, 77778, 82656, 95121, 99999, 100000, 142857, 148149, 181819, 187110,
//				208495, 318682, 329967, 351352, 356643, 390313, 461539, 466830, 499500, 500500, 533170, 538461, 609687,
//				627615, 643357, 648648, 670033, 681318, 791505, 812890, 818181, 851851, 857143, 961038, 994708, 999999,
//				1000000, 4444444, 4444444 };
//		System.out.println(arr[n]);

	}

}
