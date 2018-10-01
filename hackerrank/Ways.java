package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class Ways {
	public static BigInteger power(BigInteger num) {
		if (num.compareTo(new BigInteger("0")) == 0) {
			return BigInteger.valueOf(1);
		}

		BigInteger k = power(num.divide(BigInteger.valueOf(2)));
		BigInteger m = new BigInteger("2");
		BigInteger zero = new BigInteger("0");
		if (num.mod(m).compareTo(zero) == 0) {
			return k.multiply(k);
		} else {

			return k.multiply(k).multiply(new BigInteger("2"));
		}
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t > 0) {
			int n = scan.nextInt();

			BigInteger num = power(BigInteger.valueOf(n));
			num = num.subtract(BigInteger.valueOf(1));
			System.out.println(num);
			--t;
		}


	}

}
