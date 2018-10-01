package cc;

import java.util.Scanner;

public class Kconkcat {

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
			long[] arr2 = new long[2 * n];
			long[] arr3 = new long[3 * n];

			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextLong();
			}

			for (int i = 0; i < 2 * n; ++i) {
				arr2[i] = arr[i % n];
			}

			for (int i = 0; i < 3 * n; ++i) {
				arr3[i] = arr[i % n];
			}

			long temp = Kadane(arr);
			long temp2 = Kadane(arr2);
			long temp3 = Kadane(arr3);

			if (k >= 2)
				System.out.println((k - 2) * (temp3 - temp2) + temp2);
			else
				System.out.println(temp);

		}

		scan.close();
	}

}
