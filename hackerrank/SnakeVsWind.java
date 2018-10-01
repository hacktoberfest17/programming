package cc;

import java.util.Scanner;

public class SnakeVsWind {

	public static int path(int x, int y, int[][] board, int dir, int count) {
		if (x >= board.length || y >= board.length)
			return 0;
		int rv1 = 0, rv2 = 0, rv3 = 0, rv4 = 0;
		if (y + 1 < board.length && board[x][y + 1] == 0) {
			board[x][y + 1] = count;
			rv1 = path(x, y + 1, board, dir, count + 1);
			board[x][y + 1] = 0;
			if (dir == 1)
				rv3++;
		} else if (y - 1 >= 0 && board[x][y - 1] == 0) {
			board[x][y - 1] = count;
			rv2 = path(x, y - 1, board, dir, count + 1);
			board[x][y - 1] = 0;
			if (dir == 2)
				rv4++;
		} else if (x - 1 >= 0 && board[x - 1][y] == 0) {
			board[x - 1][y] = count;
			rv3 = path(x - 1, y, board, dir, count + 1);
			board[x - 1][y] = 0;
			if (dir == 3)
				rv1++;
		} else if (x + 1 < board.length && board[x + 1][y] == 0) {
			board[x + 1][y] = count;
			rv4 = path(x + 1, y, board, dir, count + 1);
			board[x + 1][y] = 0;
			if (dir == 4)
				rv2++;
		}

		else
			return 0;

		if (rv1 < rv2 && rv1 < rv3 && rv1 < rv4) {
			board[x][y + 1] = count;
			return rv1;
		} else if (rv2 < rv1 && rv2 < rv3 && rv2 < rv4) {
			board[x][y - 1] = count;
			return rv2;
		} else if (rv3 < rv2 && rv3 < rv1 && rv3 < rv4) {
			board[x - 1][y] = count;
			return rv3;
		} else {
			board[x + 1][y] = count;
			return rv4;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String d = "eaj";
		int x = in.nextInt();
		int y = in.nextInt();
		int dir = 0;
		int[][] board = new int[n][n];
		if (d.charAt(0) == 'n')
			dir = 2;
		else if (d.charAt(0) == 'w')
			dir = 3;
		else if (d.charAt(0) == 'e')
			dir = 4;
		else
			dir = 1;
		path(x, y, board, dir, 0);
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		in.close();
	}
}
