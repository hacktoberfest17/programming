package cc;

import java.util.Scanner;

public class gcd {

	public static int gcdiv(int divident, int divisor) {
		int rem = -1, gcd = 1;
		while (rem != 0) {
			rem = divident % divisor;
			gcd = divisor;
			divident = divisor;
			divisor = rem;
		}
		return gcd;

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		System.out.println(gcdiv(n, m));
		scan.close();
	}

}
