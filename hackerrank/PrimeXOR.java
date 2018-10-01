package cc;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeXOR {

	public static int ans = 0;

	public static int power(int x, int y) {
		if (y == 0)
			return 1;
		int k = power(x, y / 2);
		if (y % 2 == 0) {
			return k * k;
		} else {

			return k * k * x;
		}
	}

	public static void main(String[] args) {

		Boolean[] arr = new Boolean[10001];
		Arrays.fill(arr, true);
		arr[0] = arr[1] = false;
		for (int i = 2; i < 1000; ++i) {
			if (arr[i]) {
				for (int j = 2; j < 1000; ++j) {
					if (i * j < 10001)
						arr[i * j] = false;
				}
			}
		}

		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		int n, x;
		int[] temp = new int[1000];
		while (q > 0) {
			n = scan.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; ++i) {
				a[i] = x = scan.nextInt();
				temp[x - 3500]++;
			}
			// for (int i = 0; i < n; ++i) {
			// x = scan.nextInt();
			// temp[x - 3500]++;
			// }
			for (int i = 0; i < 1000; ++i) {
				if (temp[i] >= 2) {
					if (arr[i + 3500])
						ans += (temp[i] + 1) / 2;
//					ans -= power(2, temp[i]);
					arr[i+3500]=false;
				}
			}
			count(a, 0, arr, 0);
			System.out.println(ans%1000000007);
			ans = 0;
			--q;
			temp = new int[1000];
		}
		scan.close();

	}

	private static void count(int[] a, int vidx, Boolean[] arr, int xor) {
		if (vidx == a.length) {
			if (arr[xor] == true) {
				++ans;
				// System.out.println(xor);
			}
			return;
		}
		if (a[vidx] == 0)
			++vidx;

		count(a, vidx + 1, arr, xor);
		count(a, vidx + 1, arr, xor ^ a[vidx]);

	}

}
