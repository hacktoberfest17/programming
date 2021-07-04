package cc;

import java.util.Scanner;

public class ASmallStepTowardsCalculation {

	static int solve(String opr) {
		int n1 = opr.charAt(0) - 48;
		int n2 = opr.charAt(2) - 48;
		switch (opr.charAt(1)) {
		case '+':
			return n1 + n2;
		case '-':
			return n1 - n2;
		case '*':
			return n1 * n2;
		case '/':
			return n1 / n2;

		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String opr = in.next();
		int result = solve(opr);
		System.out.println(result);
		in.close();
	}
}
