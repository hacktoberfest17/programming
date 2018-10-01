package cc;

import java.util.Scanner;

public class TheStrangeFunction {
	public static int gcd(int divident, int divisor) {
		if (divisor == 0 || divident == 0) {
			return 0;
		}
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
		int[] arr = new int[n + 1];
		int[][] sum = new int[n + 1][n + 1];
		int[][] gcdarr = new int[n + 1][n + 1];
		int[][] greatest = new int[n + 1][n + 1];
		int max = Integer.MIN_VALUE;
		int temp = 0;
		int maximise = Integer.MIN_VALUE;

		for (int i = 1; i <= n; ++i) {
			arr[i] = scan.nextInt();
		}

		// greatest in l-r
		for (int i = 1; i <= n; ++i) {
			max = arr[i];
			for (int j = i; j <= n; ++j) {
				if (max <= arr[j]) {
					max = arr[j];
				}
				greatest[i][j] = max;

			}
		}

		// gcd l-r
		for (int i = 1; i <= n; ++i) {
			gcdarr[i][i] = Math.abs(arr[i]);
			for (int j = i + 1; j <= n; ++j) {
				gcdarr[i][j] = gcd(Math.abs(gcdarr[i][j - 1]), Math.abs(arr[j]));

			}
		}

		// sum l-r
		for (int i = 1; i <= n; ++i) {
			temp = 0;
			for (int j = i; j <= n; ++j) {
				temp += arr[j];
				sum[i][j] = temp;
			}
		}

		// finding all combinations
		for (int i = 1; i < n; ++i) {
			for (int j = i; j <= n; ++j) {
				temp = 0;
				temp = gcdarr[i][j] * ((sum[i][j]) - greatest[i][j]);
				if (temp > maximise) {
					maximise = temp;
				}
			}
		}

		System.out.println(maximise);
		scan.close();
	}

}
