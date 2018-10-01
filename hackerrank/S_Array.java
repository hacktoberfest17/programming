package cc;

import java.util.Scanner;

public class S_Array {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int j = 0;
		String[] ans = new String[t];
		while (t > j) {
			int sum = 0;
			int n = scan.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
				sum += arr[i];
			}
			if (n == 1)
				ans[j] = "YES";
			else
				ans[j] = check(arr, sum);
			++j;
		}
		for (String s : ans)
			System.out.println(s);
		scan.close();

	}

	public static String check(int[] arr, int sum) {
		int i, chk = 0;
		for (i = 1; i < arr.length; ++i) {
			chk += arr[i - 1];
			if (2 * chk == sum - arr[i])
				return "YES";
			if (2 * chk > sum - arr[i])
				return "NO";
		}
		return "NO";
	}
}
