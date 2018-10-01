package cc;

import java.util.Scanner;

public class booksstudentspages {
	public static int min(int a, int b) {
		if (a > b)
			return b;
		else
			return a;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int max = 0, i, m = scan.nextInt();
		int[] arr = new int[n];
		for (i = 0; i < n; ++i)
			arr[i] = scan.nextInt();
		if (n == m)
			max = (arr[n - 1]);
		else if (m == 1){
			for (i = 0; i < n; ++i) {
				max += arr[i];
			}
		}
		else {
			for (i = 0; i <= n - m; ++i) {
				max += arr[i];
			}
			max = min(max, arr[i] + arr[i - 1]);

			if (max < arr[arr.length - 1])
				max = arr[arr.length - 1];
		}

		System.out.println(max);
	scan.close();
	}

}
