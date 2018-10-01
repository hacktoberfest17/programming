package cc;

import java.util.Scanner;

public class absoluteDifference {

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

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		in.close();
		a = mergesort(a.length - 1, 0, a);
		int min = a[1] - a[0];

		if (a[0] >= 0) {

			System.out.println(min);
			return;
		}
		int i = 0;
		while (a[i] < 0) {
			++i;
		}
		int m = a[n-1] - a[0];
		for (int j = 1; j <=i; ++j) {
			if (m > a[j] - a[j - 1])
				m = a[j] - a[j - 1];

		}
		for (int j = i; j < n-1; ++j) {
			if (m > a[j + 1] - a[j])
				m = a[j + 1] - a[j];

		}
		System.out.println(m);

	}

}
