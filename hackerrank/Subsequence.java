package cc;

import java.util.Arrays;

public class Subsequence {

	public static void longestSubSequenceLength(int[][] arr, String str1, String str2) {

		for (int i = 1; i <= str1.length(); ++i) {
			for (int j = 1; j <= str2.length(); ++j) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					filler(i, j, arr, str1, str2);
				}
			}
		}
	}

	private static void filler(int row, int col, int[][] arr, String str1, String str2) {

		for (int i = row; i <= str1.length(); ++i) {
			for (int j = col; j <= str2.length(); ++j) {
				arr[i][j]++;
			}
		}
	}

	public static String longestSubsequence(String str1, String str2) {
		String[][] arr = new String[str1.length() + 1][str2.length() + 1];
		// Arrays.fill(arr, "");
		for (int i = 0; i <= str1.length(); ++i) {
			for (int j = 0; j <= str2.length(); ++j) {
				arr[i][j] = "";
			}
		}
		for (int i = 1; i <= str1.length(); ++i) {
			for (int j = 1; j <= str2.length(); ++j) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					Stringfiller(i, j, arr, str1, str2);
				}
			}
		}

		return arr[str1.length()][str2.length()];

	}

	private static void Stringfiller(int row, int col, String[][] arr, String str1, String str2) {
		for (int i = row; i <= str1.length(); ++i) {
			for (int j = col; j <= str2.length(); ++j) {
				arr[i][j] = arr[i][j] + str1.charAt(row - 1);
			}
		}
	}

	public static void main(String[] args) {

		String str1 = "ABCDGH";
		String str2 = "AEDFHR";
		int[][] arr = new int[str1.length() + 1][str2.length() + 1];
		longestSubSequenceLength(arr, str1, str2);
		System.out.println(arr[str1.length()][str2.length()]);
		System.out.println(longestSubsequence(str1, str2));

	}

}
