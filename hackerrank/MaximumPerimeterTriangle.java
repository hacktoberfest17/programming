package cc;

import java.util.Scanner;

public class MaximumPerimeterTriangle {
	public static int[] merge(int[] one, int[] two) {
		int[] arr = new int[one.length + two.length];
		int i = 0, j = 0, k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				arr[k] = one[i];
				++i;

			} else {
				arr[k] = two[j];
				++j;
			}
			++k;
		}
		while (i < one.length) {
			arr[k] = one[i];
			++i;
			++k;
		}
		while (j < two.length) {
			arr[k] = two[j];
			++j;
			++k;
		}
		return arr;
	}

	public static int[] mergesort(int hi, int lo, int arr[]) {
		if (hi == lo) {
			int[] a = new int[1];
			a[0] = arr[hi];
			return a;
		}

		int mid = (hi + lo) / 2;
		int[] one = mergesort(hi, mid + 1, arr);
		int[] two = mergesort(mid, lo, arr);
		int[] result = merge(one, two);
		return result;
	}

	public static boolean check(int a, int b, int c) {
		if (a >= b + c)
			return false;
		if (b >= a + c)
			return false;
		if (c >= a + b)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		in.close();
		a = mergesort(a.length - 1, 0, a);
		for (int i = n - 1; i >= 2; --i) {
			for (int j = i - 1; j >= 1; --j) {
				for (int k = j - 1; k >= 0; --k) {
					if (check(a[i], a[j], a[k])) {
						System.out.println(a[k] + " " + a[j] + " " + a[i]);
						return;
					}
				}
			}
		}

	System.out.println("-1");
	}

}
