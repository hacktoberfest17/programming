package cc;

import java.util.Scanner;

public class SumVsXor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long p = (long) (1099511627776.0);
		if (n == p) {
			System.out.println(n);
		} else {
//			long result = solveBinary(n);
//			
//			System.out.println(result);
			System.out.println(solve(n));
		}
		in.close();
	}

	private static long solve(long n) {
		int rv = 0;
		for (long i = 0; i <= n; ++i) {
			if (i + n == (i ^ n)) {
				++rv;
				System.out.println(i);
			}
		}
		return rv;
	}

	public static int power(int x, int y) {
		if (y == 0)
			return 1;
		int k = power(x, y / 2);
		if (y % 2 == 0) {
			return k * k;
		} else {

			return k * k * x;
		}
	}

	private static int solveBinary(long n) {
		int rv = 0;
		while (n != 0) {
			if (n % 2 == 0) {
				++rv;
			}
			n /= 2;
		}

		return power(2, rv);
	}

}
