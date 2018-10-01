package cc;

import java.util.Scanner;

public class EruptingVolcanoes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n][n];
		int diff = 0;
		int m = in.nextInt();
		for (int a0 = 0; a0 < m; a0++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int w = in.nextInt();

			diff = w;
			arr[x][y] += diff;
int k=0;
			while (diff != 0) {
				--diff;
				++k;
				if (y - k >= 0)
					arr[x][y - k] += diff;

				if (y + k < n)
					arr[x][y + k] += diff;

				if (x - k >= 0 && y + k < n)
					arr[x - k][y + k] += diff;

				if (x - k >= 0 && y - k >= 0)
					arr[x - k][y - k] += diff;

				if (x - k >= 0)
					arr[x - k][y] += diff;

				if (x + k < n)
					arr[x + k][y] += diff;

				if (x + k < n && y - k >= 0)
					arr[x + k][y - k] += diff;

				if (x + k < n && y + k < n)
					arr[x + k][y + k] += diff;
			}
		}
		int max = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (arr[i][j] > max)
					max = arr[i][j];
			}
		}
		System.out.println(max);
		in.close();
	}

}
