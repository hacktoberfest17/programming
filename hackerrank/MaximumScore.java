package cc;

import java.util.Scanner;

public class MaximumScore {

	public static int retIndex(int[][] arr, int row, int uLimit) {
		int temp = Integer.MIN_VALUE, index = -1;
		for (int i = 0; i < arr[row].length; ++i) {

			if (temp < arr[row][i] && arr[row][i] < uLimit) {
				temp = arr[row][i];
				index = i;
			}
		}

		return index;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {

			int n = scan.nextInt();

			int[][] arr = new int[n][n];

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					arr[i][j] = scan.nextInt();
				}
			}

			int index = 0, uLimit = Integer.MAX_VALUE;
			long maxSum = 0;

			for (int i = n - 1; i >= 0; --i) {
				index = retIndex(arr, i, uLimit);
				if (index == -1) {
					maxSum = -1;
					break;
				}
				uLimit = arr[i][index];
				maxSum += uLimit;
			}

			System.out.println(maxSum);

			--t;
		}
		scan.close();
	}

}
