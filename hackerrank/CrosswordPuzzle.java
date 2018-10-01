package cc;

import java.util.Scanner;

public class CrosswordPuzzle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = 1;
		String[] matrix = new String[10];
		for (int i = 0; i < 10; ++i) {
			matrix[i] = scan.nextLine();

		}
		String str = scan.nextLine();
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) == ';')
				++n;
		}
		int k = 0;
		String[] arr = new String[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = "";
		}
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) == ';')
				++k;
			else
				arr[k] += str.charAt(i);

		}

		puzzle(arr, matrix, 0, 0, 0);

		scan.close();
	}

	private static void puzzle(String[] arr, String[] matrix, int row, int col, int placed) {
		if (row >= 10)
			return;
		if (row == 9&&col==9) {
			// if (placed == arr.length) {
			if (true) {
				for (String s : matrix) {
					System.out.println(s);
				}
			}
			return;
		}
		if (col == 10) {
			puzzle(arr, matrix, row + 1, 0, placed);
		}

		int hor = CheckHor(row, col, matrix);
		int ver = CheckVer(row, col, matrix);
		String temp = "";
		//for vertical
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i].length() == ver) {
				
			}

		}
		
		
		//for horizontal
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i].length() == hor) {
				if (matrix[row].charAt(col) == '-'|| matrix[row].charAt(col) == arr[i].charAt(0)) {
					temp = arr[i];
					matrix[row] = matrix[row].substring(0, col) + temp + matrix[row].substring(col + temp.length());
					arr[i] = "";
					puzzle(arr, matrix, row, col + temp.length(), placed + 1);
					arr[i] = temp;
				}
			}
		}

		puzzle(arr, matrix, row, col + 1, placed);

	}

	private static int CheckHor(int row, int col, String[] matrix) {
		int rv = 0;
		if (matrix[row].charAt(col) != '+') {
			++rv;
			for (int i = col + 1; i < matrix[0].length(); ++i) {
				if (matrix[row].charAt(i) == '-')
					++rv;
				else
					break;
			}
		}
		return rv;
	}

	private static int CheckVer(int row, int col, String[] matrix) {
		int rv = 0;
		if (matrix[row].charAt(col) != '+') {
			++rv;
			for (int i = row + 1; i < matrix.length; ++i) {
				if (matrix[i].charAt(col) == '-')
					++rv;
				else
					break;
			}
		}
		return rv;
	}

}
