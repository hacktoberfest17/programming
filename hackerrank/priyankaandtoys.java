package cc;

import java.util.Scanner;

public class priyankaandtoys {
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

		// code 1--if scheme can be used onl once;
		int val = a[0];
		// int count = 0, max = 0;
		// for (int i = 0; i < a.length; ++i) {
		// val = a[i] + 4;
		// for (int j = i; (j < a.length)&&(a[j] <= val) ; ++j)
		// ++count;
		// if (count > max)
		// max = count;
		// count = 0;
		// }

		// System.out.println(n-max+1);

		// for hackr rank

		int price = 1, initial = a[0], max = initial + 4;
		for (int i = 0; i < a.length; ++i) {
			if (a[i] >= initial && a[i] <= max) {
				continue;
			} else {
				initial = a[i];
				max = initial + 4;
				++price;
			}
		}

		System.out.println(price);
	}

}
