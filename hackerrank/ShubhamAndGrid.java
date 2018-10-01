package cc;

import java.util.Scanner;

public class ShubhamAndGrid {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] board = new int[n][m];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				String str = scan.next();
				if (str.charAt(0) == 'a') {
					board[i][j] = 1;
				}
				if (str.charAt(0) == 'b') {
					board[i][j] = 2;
				}
				if (str.charAt(0) == 'c') {
					board[i][j] = 3;
				}
				if (str.charAt(0) == 'd') {
					board[i][j] = 4;
				}

			}
		}

	}

	// public static boolean find(int hor,int ver,int[][] board,boolean
	// found1,boolean found2,boolean found3,boolean found4) {
	//
	// if(hor>=board.length||ver>=board[0].length) {
	// return false;
	// }
	//
	// if(board[hor][ver]==1&&found1==true) {
	// return false;
	// }
	// if(board[hor][ver]==2&&found2==true) {
	// return false;
	// }
	// if(board[hor][ver]==3&&found3==true) {
	// return false;
	// }
	// if(board[hor][ver]==4&&found4==true) {
	// return false;
	// }
	// //check for 2
	// if(found1==true) {
	//
	// }
	//
	// }

	public static boolean find(int hor, int ver, int[][] board) {
		if (hor >= board.length || ver >= board[0].length)
			return 0;

		int temp = board[hor][ver];
		board[hor][ver] = 11;
		int found = 0;
		if (board[hor][ver] == 1) {

			if (hor + 1 < board.length && board[hor + 1][ver] == 2) {

				found = find(hor + 1, ver, board);
			}
			if (ver + 1 < board[0].length && board[hor][ver + 1] == 2) {

				found = find(hor + 1, ver, board);
			}
			if (hor - 1 >= 0 && board[hor - 1][ver] == 2) {

				found = find(hor + 1, ver, board);
			}
			if (ver - 1 >= 0 && board[hor][ver - 1] == 2) {

				found = find(hor + 1, ver, board);
			}
		} else if (board[hor][ver] == 2) {
			if (hor + 1 < board.length && board[hor + 1][ver] == 3) {

				found = find(hor + 1, ver, board);
			}
			if (ver + 1 < board[0].length && board[hor][ver + 1] == 3) {

				found = find(hor + 1, ver, board);
			}
			if (hor - 1 >= 0 && board[hor - 1][ver] == 3) {

				found = find(hor + 1, ver, board);
			}
			if (ver - 1 >= 0 && board[hor][ver - 1] == 3) {

				found = find(hor + 1, ver, board);
			}
			else if(board[hor][ver]==4){
				if (hor + 1 < board.length && board[hor + 1][ver] == 4) {
					return true;

				}
				if (ver + 1 < board[0].length && board[hor][ver + 1] == 4) {
					return true;

				}
				if (hor - 1 >= 0 && board[hor - 1][ver] == 4) {
					return true;

					
				}
				if (ver - 1 >= 0 && board[hor][ver - 1] == 4) {
					return true;
					
				}
				return false;

			}

		board[hor][ver] = temp;
		return false;

	}
}
