package cc;

import java.util.Scanner;

public class MatrixRotation {
	public static void rotate(int[][] arr) {
		int rmax = arr.length, rmin = 0, cmin = 0, cmax = arr[0].length, temp;
		int count = (rmax) * (cmax)-1;
		while (count > 0) {
			temp = arr[rmin][cmin];
			for (int col = cmin; col < cmax - 1 && count > 0; ++col) {
				arr[rmin][col] = arr[rmin][col + 1];
				--count;
			}
			++rmin;

			for (int row = rmin; row < rmax && count > 0; ++row) {
				arr[row - 1][cmax - 1] = arr[row][cmax - 1];
				--count;
			}
			--cmax;

			for (int col = cmax; col > cmin && count > 0; --col) {
				arr[rmax - 1][col] = arr[rmax - 1][col - 1];
				--count;
			}
			--rmax;

			for (int row = rmax; row > rmin && count > 0; --row) {
				arr[row][cmin] = arr[row - 1][cmin];
				--count;
			}
			++cmin;
			arr[rmin][cmin - 1] = temp;
			count--;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				arr[i][j] = scan.nextInt();
			}
		}
//		k = k % ((2 * m) + 2 * (n - 2));
		while (k > 0) {
			rotate(arr);
			--k;
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		scan.close();
	}

}
