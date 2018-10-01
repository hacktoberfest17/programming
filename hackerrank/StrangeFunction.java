package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class StrangeFunction {
	static BigInteger ten;
	static BigInteger zero;

	// y=n
	public static BigInteger power(BigInteger x, long y) {
		if (y == 0)
			return BigInteger.valueOf(1);
		BigInteger k = power(x, y / 2);
		if (y % 2 == 0) {
			return k.multiply(k);
		} else {
			return k.multiply(k).multiply(x);
		}
	}

	public static BigInteger sum(BigInteger number) {
		BigInteger temp = new BigInteger("0");
		while (number.compareTo(zero) == 1) {
			temp = temp.add(number.mod(BigInteger.valueOf(10)));
			number = number.divide(BigInteger.valueOf(10));
		}

		return temp;
	}

	public static int sum1(BigInteger num) {
		int rv = 0;
		String str = num.toString();
		int i = 0;
		int length = str.length();
		while (i < length) {
			rv += Integer.parseInt(str.substring(i, i + 1));
			++i;
		}
		return rv;

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		ten = new BigInteger("10");
		zero = new BigInteger("0");

		while (t > 0) {
			long a = scan.nextLong();
			long n = scan.nextLong();
			BigInteger num = power(BigInteger.valueOf(a), n);

			while (num.compareTo(ten) == 1) {
				num = sum(num);
			}
			if (num.equals(ten)) {
				System.out.println(1);
			} else
				System.out.println(num);
			--t;
		}
		scan.close();
	}

}
