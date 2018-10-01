package cc;

import java.util.Scanner;

public class ArithmaticOperation {

	public static boolean calc(int[] arr, String ans, int vidx, int sum) {
		if (vidx == arr.length) {
			if (sum % 101 == 0) {
				System.out.println(ans);
				// System.out.println(sum);
				return true;
			}
			return false;
		}
		boolean result;
		for (int i = 0; i < 3; ++i) {
			result = calc(arr, ans + "+" + arr[vidx], vidx + 1, sum + arr[vidx]);
			if (result) {
				return true;
			}
			result = calc(arr, ans + "-" + arr[vidx], vidx + 1, sum - arr[vidx]);
			if (result) {
				return true;
			}
			result = calc(arr, ans + "*" + arr[vidx], vidx + 1, sum * arr[vidx]);
			if (result) {
				return true;
			}

		}

		return false;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = scan.nextInt();
		}

		calc(arr, "" + arr[0], 1, arr[0]);
	}

}
