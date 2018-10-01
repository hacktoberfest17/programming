package cc;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {
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
		int k = in.nextInt();
		int[] a = new int[n];
		long sum = 0;
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();

		}
		in.close();
		a = mergesort(n - 1, 0, a);

		if (k >= n) {
			for (int a_i = 0; a_i < n; a_i++) {
				sum += a[a_i];

			}

		} else {
			int[] time = new int[n];
			Arrays.fill(time, 2);
			int num = n;
			for (int i = 0; i < n; ++i) {
				sum += a[i];
				--num;
			}

			while (num > 0) {
				for (int i = 0; (i < n - 1)&&num>=0; ++i) {
					if (a[i] * time[i] < a[i + 1] * time[i + 1]) {
						sum += a[i] * time[i];
						++time[i];
						--num;
						--i;
					}
					if(num==0)
						break;
					if(a[n-1] * time[n-1] < a[n-2] * time[n-2]){
						
						sum += a[n-1] * time[n-1];
						++time[n-1];
						--num;
					}
				}
			}
		}
		System.out.println(sum);
	}

}
