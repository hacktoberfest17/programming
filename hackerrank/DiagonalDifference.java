package cc;

import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), d1 = 0, d2 = 0;
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				arr[i][j] = in.nextInt();
				if (i == j) {
					d1 += arr[i][i];
				}
				if (i + j == n - 1) {
					d2 += arr[i][j];
				}
			}
		}

		System.out.println(Math.abs(d1-d2));
	}

}
