package cc;

import java.util.Arrays;
import java.util.Scanner;

public class CrownIt {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String[][] arr = new String[4][4];
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				arr[i][j] = scan.next();
			}
		}
		Boolean[][] bool = new Boolean[4][4];
		// Arrays.fill(bool, true);
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				bool[i][j] = true;
			}
		}
		print(arr, bool, 0, 0, "");
	}

	public static int count = 0;

	private static void print(String[][] arr, Boolean[][] bool, int row, int col, String word) {
		if (word.length() > 5)
//			return;
		if (word.length() > 2) {
			++count;
			System.out.println(count + "=>" + word);
		}
//		if (AdjAvail(row, col, bool) == false)
//			return;

		if (bool.length > row + 1 && bool[row].length > col + 1 && bool[row + 1][col + 1] == true) {
			bool[row + 1][col + 1] = false;
			print(arr, bool, row + 1, col + 1, word + "" + arr[row][col]);
			bool[row + 1][col + 1] = true;
		}

		if (bool.length > row + 1 && bool[row + 1][col] == true) {
			bool[row + 1][col] = false;
			print(arr, bool, row + 1, col, word + arr[row][col]);
			bool[row + 1][col] = true;
		}

		if (bool.length > row + 1 && col - 1 >= 0 && bool[row + 1][col - 1] == true) {
			bool[row + 1][col - 1] = false;
			print(arr, bool, row + 1, col - 1, word + arr[row][col]);
			bool[row + 1][col - 1] = true;
		}

		if (row - 1 >= 0 && bool[row].length > col + 1 && bool[row - 1][col + 1] == true) {
			bool[row - 1][col + 1] = false;
			print(arr, bool, row - 1, col + 1, word + arr[row][col]);
			bool[row - 1][col + 1] = true;
		}

		if (row - 1 >= 0 && bool[row - 1][col] == true) {
			bool[row - 1][col] = false;
			print(arr, bool, row - 1, col, word + arr[row][col]);
			bool[row - 1][col] = true;
		}
		if (row - 1 >= 0 && col - 1 >= 0 && bool[row - 1][col - 1] == true) {
			bool[row - 1][col - 1] = false;
			print(arr, bool, row - 1, col - 1, word + arr[row][col]);
			bool[row - 1][col - 1] = true;
		}

		if (bool[row].length > col + 1 && bool[row][col + 1] == true) {
			bool[row][col + 1] = false;
			print(arr, bool, row, col + 1, word + arr[row][col]);
			bool[row][col + 1] = true;
		}
		if (col - 1 >= 0 && bool[row][col - 1] == true) {
			bool[row][col - 1] = false;
			print(arr, bool, row, col - 1, word + arr[row][col]);
			bool[row][col - 1] = true;
		}
		return;
	}

	private static boolean AdjAvail(int row, int col, Boolean[][] bool) {
		if (bool.length > row + 1 && bool[row].length > col + 1 && bool[row + 1][col + 1] == true)
			return true;
		if (bool.length > row + 1 && bool[row + 1][col] == true)
			return true;
		if (bool.length > row + 1 && col - 1 >= 0 && bool[row + 1][col - 1] == true)
			return true;

		if (row - 1 >= 0 && bool[row].length > col + 1 && bool[row - 1][col + 1] == true)
			return true;
		if (row - 1 >= 0 && bool[row - 1][col] == true)
			return true;
		if (row - 1 >= 0 && col - 1 >= 0 && bool[row - 1][col - 1] == true)
			return true;

		if (bool[row].length > col + 1 && bool[row][col + 1] == true)
			return true;
		if (col - 1 >= 0 && bool[row][col - 1] == true)
			return true;

		return false;
	}

}
