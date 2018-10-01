package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class MathDay {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			int a = scan.nextInt();
			int n = scan.nextInt();
			int p = scan.nextInt();

			BigInteger ans = new BigInteger("1");

			int i = 1;
			while (i <= n) {

				ans = ans.multiply(BigInteger.valueOf((long) Math.pow(a, i)));
				ans = ans.mod(BigInteger.valueOf(p));
				++i;
			}

			System.out.println(ans.mod(BigInteger.valueOf(p)));
			--t;
		}

		// while (t > 0) {
		// int a = scan.nextInt();
		// int n = scan.nextInt();
		// int p = scan.nextInt();
		//
		// long ans = 1;
		// int i = 1;
		// while (i <= n) {
		//
		// ans *= Math.pow(a, i);
		// ans = ans % p;
		// ++i;
		// }
		//
		// System.out.println(ans % p);
		// --t;
		// }
	}
}
