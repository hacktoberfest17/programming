package cc;

import java.util.Scanner;

public class Kconcat {
	private static long Kadane(long[] arr) {
		long max_global = Integer.MIN_VALUE, max_current = 0;

		for (int i = 0; i < arr.length; ++i) {

			max_current = Math.max(arr[i], max_current + arr[i]);

			if (max_global < max_current) {
				max_global = max_current;
			}
		}

		return max_global;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			--t;
			int n = scan.nextInt();
			int k = scan.nextInt();
			long[] arr = new long[n];

			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextLong();
			}

			long[] arr3 = new long[n * k];
			for (int i = 0; i < k * n; ++i) {
				arr3[i] = arr[i % n];
			}
			System.out.println(Kadane(arr3));
		}

		scan.close();
	}

}
