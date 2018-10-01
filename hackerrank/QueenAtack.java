package cc;

import java.util.Scanner;

public class QueenAtack {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int r = in.nextInt();
		int c = in.nextInt();
		int count = 0, cr = c, cl = c, ru = r, rd = r, rd1 = r, cd1 = c, rd2 = r, cd2 = c, rd1m = r, cd1m = c, rd2m = r,
				cd2m = c;
		int[][] data = new int[k][2];
		for (int i = 0; i < k; ++i) {
			data[i][0] = in.nextInt();
			data[i][1] = in.nextInt();

			if (data[i][0] == r && data[i][1] > c) {
				if (data[i][1] > cr)
					cr = data[i][1]; // right
			}
			if (data[i][0] == r && data[i][1] < c) {
				if (data[i][1] < cl)
					cl = data[i][1]; // left
			}
			if (data[i][0] > r && data[i][1] == c) { // up
				if (data[i][0] > ru)
					ru = data[i][0];
			}
			if (data[i][0] < r && data[i][1] == c) { // down
				if (data[i][0] < rd)
					rd = data[i][0];
			}

			// upper diagonal 1
			if ((r - c == data[i][0] - data[i][1]) && rd1 < data[i][0] && cd1 < data[i][1]) {
				rd1 = data[i][0];
				cd1 = data[i][1];
			}

			// lower diagonal 1
			if ((r - c == data[i][0] - data[i][1]) && rd1 > data[i][0] && cd1 > data[i][1]) {
				rd1m = data[i][0];
				cd1m = data[i][1];
			}

			// upper d2
			if ((r + c == data[i][0] + data[i][1]) && rd2 > data[i][0] && cd2 < data[i][1]) {
				rd2 = data[i][0];
				cd2 = data[i][1];
			}

		}

		if (rd != r)
			count += r - rd - 1;
		else
			count += r - 1;

		if (ru != r)
			count += ru - r - 1;
		else
			count += n - r;

		if (cr != c)
			count += cr - c - 1;
		else
			count += n - c;

		if (cl != c)
			count += c - cl - 1;
		else
			count += c - 1;

		// upper d1
		if (cd1 != c)
			count += cd1 - c - 1;
		else {
			while (rd1 <n && cd1 <n) {
				++count;
				++rd1;
				++cd1;
			}
		}

		// lower d1
		if (cd1m != c)
			count += c - cd1m - 1;
		else
		{
			while (rd1 >=1 && cd1 >=1) {
				++count;
				--rd1;
				--cd1;
			}
		}

		// upper d2
		if (cd1 != c)
			count += rd2 - r - 1;
		else {
			while (rd2 <n && cd2 >1) {
				++count;
				++rd2;
				--cd2;
			}
		}

		// lower d2
		if (cd2 != c)
			count += cd2 - c - 1;
		else {
			while (rd2 >1 && cd2 < n) {
				++count;
				--rd2;
				++cd2;
			}
		}

		System.out.println(count);
	}

	private static void bekar() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int r = in.nextInt();
		int c = in.nextInt();
		boolean[][] arr = new boolean[n + 1][n + 1];
		// Arrays.fill(arr, true);
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				arr[i][j] = true;
			}
		}
		for (int i = 0; i <= n; ++i) {
			arr[0][i] = false;
			arr[i][0] = false;
		}
		arr[r][c] = false;
		int[][] data = new int[k][2];
		for (int i = 0; i < k; ++i) {
			// data[i][0] = in.nextInt();
			// data[i][1] = in.nextInt();
			// arr[data[i][0]][data[i][1]] = false;
			arr[in.nextInt()][in.nextInt()] = false;

		}

		int count = 0;

		// up
		for (int i = r + 1; i <= n; ++i) {
			if (arr[i][c] == false)
				break;
			++count;
		}

		// down
		for (int i = r - 1; i > 0; --i) {
			if (arr[i][c] == false)
				break;
			++count;
		}

		// right
		for (int i = c + 1; i <= n; ++i) {
			if (arr[r][i] == false)
				break;
			++count;
		}

		// left
		for (int i = c - 1; i > 0; --i) {
			if (arr[r][i] == false)
				break;
			++count;
		}

		// upper diagonal 1

		for (int i = r + 1, j = c + 1; i <= n && j <= n; ++i, ++j) {
			if (arr[i][j] == false)
				break;
			++count;
		}

		// lower diagonal 1

		for (int i = r - 1, j = c - 1; i > 0 && j > 0; --i, --j) {
			if (arr[i][j] == false)
				break;
			++count;
		}

		// upper diagonal 2

		for (int i = r + 1, j = c - 1; i <= n && j > 0; ++i, --j) {
			if (arr[i][j] == false)
				break;
			++count;
		}

		// lower diagonal 2

		for (int i = r - 1, j = c + 1; i > 0 && j <= n; --i, ++j) {
			if (arr[i][j] == false)
				break;
			++count;
		}
		System.out.println(count);
	}
}