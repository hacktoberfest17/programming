package cc;

import java.util.Scanner;

public class BetweenTwoSets {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int[] b = new int[m];

		for (int b_i = 0; b_i < m; b_i++) {
			b[b_i] = in.nextInt();

		}
		int gdc = b[0];
		for (int b_i = 1; b_i < m; b_i++) {
			gdc = hcf(gdc, b[b_i]);
		}
		int total = getTotalX(a, gdc);
		System.out.println(total);
		in.close();
	}

	private static int getTotalX(int[] a, int b) {
		int x = 0;
		int t = 1;
		for (t = 1; t <= b; ++t) {
			if (b % t != 0)
				continue;
			for (int i = 0; i < a.length; ++i) {
				if (t % a[i] != 0)
					break;
				if (i == a.length - 1)
					++x;
			}

		}
		return x;
	}

	public static int hcf(int a, int b) {
		int divisor = a;
		int divident = b;
		int rem = 1, hcf = 0;
		while (rem != 0) {
			hcf = divisor;
			rem = divident % divisor;
			divident = divisor;
			divisor = rem;
		}
		return hcf;
	}
}
