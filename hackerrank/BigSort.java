package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class BigSort {
	public static BigInteger[] merge(BigInteger[] one, BigInteger[] two) {
		BigInteger[] arr = new BigInteger[one.length + two.length];
		int i = 0, j = 0, k = 0;
		while (i < one.length && j < two.length) {
			if (one[i].compareTo(two[j]) < 0) {
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

	public static BigInteger[] mergesort(int hi, int lo, BigInteger arr[]) {
		if (hi == lo) {
			BigInteger[] a = new BigInteger[1];
			a[0] = arr[hi];
			return a;
		}

		int mid = (hi + lo) / 2;
		BigInteger[] one = mergesort(hi, mid + 1, arr);
		BigInteger[] two = mergesort(mid, lo, arr);
		BigInteger[] result = merge(one, two);
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		BigInteger[] arr = new BigInteger[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = in.nextBigInteger();
		}
		arr = mergesort(n - 1, 0, arr);
		for (BigInteger val : arr) {
			System.out.println(val);

		}
		in.close();
	}

}
