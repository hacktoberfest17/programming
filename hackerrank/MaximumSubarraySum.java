package cc;

import java.util.Scanner;

public class MaximumSubarraySum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			int n = in.nextInt();
			long m = in.nextLong();
			long[] a = new long[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextLong();
			}
			int ans = 0, sum = 0;
			for (int i = 0; i < n; ++i) {
				for (int j = i; j < n; ++j) {
					sum = 0;
					for (int p = i; p <= j; ++p) {
						sum += a[p];
					}
					sum %= m;
					if (sum > ans)
						ans = sum;
					if (ans == m - 1)
						break;
				}
			}
			System.out.println(ans);
			--t;
		}
		in.close();
	}
}
