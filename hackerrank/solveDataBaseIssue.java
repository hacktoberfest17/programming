package cc;

import java.util.Scanner;

public class solveDataBaseIssue {

	public static void main(String[] args) {
		int n, divisor, rem = -1, divident, gcd, n1, n2;
		// System.out.println("enter the number n1");
		Scanner scan = new Scanner(System.in);
		divisor = scan.nextInt();
		n1 = divisor;
		// System.out.println("enter the number n2");
		divident = scan.nextInt();
		n2 = divident;
		while (divisor != 0) {
			rem = divident % divisor;
			divident = divisor;
			divisor = rem;
		}
		int lcm = (n1 * n2) / divident;
		lcm--;
		System.out.println(lcm % 1000000007);
	}

}
