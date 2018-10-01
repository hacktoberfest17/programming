package cc;

import java.util.Scanner;

public class CodeArenaLuckyPermutation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		boolean[][] graph = new boolean[n + 2][n + 2];

		for (int i = 0; i < m; ++i) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			graph[x][y] = graph[y][x] = true;

		}
		int count = 0;

		for (int i = 1; i < n; ++i) {
			if (graph[i][i + 1]) {
				++count;
			}
		}

		System.out.println(count);
	}
}