package cc;

import java.util.Scanner;

public class GreaterXor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		while (q > 0) {
			long n = in.nextLong();
			System.out.println(binary(n));
			--q;
		}
		in.close();
	}

	private static long solve(long n) {
		int rv = 0;
		for (long i = 0; i < n; ++i) {
			if ((i ^ n) > n) {
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

	private static int binary(long n) {
		int rv = 0, mul = 1, digit = 1;
		long x;
		long binary = 0;
		while (n != 0) {
			x = (n % 2);
			binary = x * mul + binary;
			mul *= 10;
			n /= 2;
			if (x == 0) {
				rv -= power(2, digit);
				// System.out.println(rv);

			}
			++digit;

		}
		String b = Long.toString(binary);
		int i = 0;
		while (i != b.length()) {
			if (b.charAt(i) == '0') {
				break;
			}
			++i;
			--digit;
		}
		// System.out.println(b);
		rv += power(2, digit);
		// System.out.println(binary + " " + digit);
		return rv - 1;
	}

}
