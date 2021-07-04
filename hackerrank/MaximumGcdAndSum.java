package cc;

import java.util.Random;
import java.util.Scanner;

public class MaximumGcdAndSum {
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

	public static int gcd(int divident, int divisor) {
		int rem = -1, gcd = 1;
		while (rem != 0) {
			rem = divident % divisor;
			gcd = divisor;
			divident = divisor;
			divisor = rem;
		}
		return gcd;

	}

	public static void main(String[] args) {
//		Random in = new Random();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int[] A = new int[n];
		for (int A_i = 0; A_i < n; A_i++) {
			A[A_i] = in.nextInt();
		}
		int[] B = new int[n];
		for (int B_i = 0; B_i < n; B_i++) {
			B[B_i] = in.nextInt();
		}
		// B = mergesort(n - 1, 0, B);
		// A = mergesort(n - 1, 0, A);

		System.out.println(sum(A, B, n));
//		in.close();
	}

	private static int sum(int[] A, int[] B, int n) {
		int max = 0, gcd = 0, sum = 0;
		for (int i = n - 1; i >= 0; --i) {
			if (gcd > B[i])
				continue;
			for (int j = n - 1; j >= 0; --j) {
				if (gcd > A[j]) {
					continue;
				}
				gcd = gcd(A[j], B[i]);
				if (gcd > max) {
					max = gcd;
					sum = A[j] + B[i];
				}

			}
		}
		return sum;
	}

}
