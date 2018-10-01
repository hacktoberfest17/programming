package cc;

import java.util.Scanner;

public class TargetSumPair {
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
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i)
			arr[i] = scan.nextInt();
		int target = scan.nextInt();
		arr = mergesort(n - 1, 0, arr);
		for (int i = 0; i < n - 2; ++i) {
			if (arr[i] == arr[i + 1])
				continue;
			for (int j = i + 1; j < n - 1; ++j) {
				if (j > 0) {
					if (arr[j] == arr[j - 1])
						continue;
				}
				if (arr[i] + arr[j] == target)
					System.out.println(arr[i] + " and " + arr[j]);
				if (arr[i] + arr[j] > target)
					break;
			}
		}
		scan.close();
	}

}
