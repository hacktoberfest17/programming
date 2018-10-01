package cc;

import java.util.Scanner;

public class larryArray {
	public static void shift(int[] arr, int i) {
		int temp = arr[i];
		arr[i] = arr[i + 2];
		arr[i + 2] = temp;
		temp = arr[i];
		arr[i] = arr[i + 1];
		arr[i + 1] = temp;

	}

	public static boolean check(int[] arr, int i) {
		if (arr[i + 1] > arr[i] && arr[i + 1] > arr[i + 2])
			return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			int n = in.nextInt();

			int[] ar = new int[n];

			for (int ar_i = 0; ar_i < n; ar_i++) {
				ar[ar_i] = in.nextInt();
			}
			int j, k = 0;
			for (int i = 0; i < 2 * (n - 2); ++i) {
				j = i / 2;
				if (check(ar, j)) {
					System.out.println("NO");
					k = 1;
					break;
				}
				shift(ar, j);                                         /////WRoNG!!!
			}
			if (k == 0)
				System.out.println("YES");
			--t;
		}
		in.close();
	}

}
	