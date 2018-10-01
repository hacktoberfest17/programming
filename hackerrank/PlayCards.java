package cc;

import java.util.Scanner;

public class PlayCards {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt();
		int n=10000000;
		int[] arr1 = new int[n];
		for (int i = 0; i < n; ++i) {
			arr1[i] = scan.nextInt();
		}
		int m = scan.nextInt();
		int max = Integer.MIN_VALUE;
		int[] arr2 = new int[n];
		for (int i = 0; i < m; ++i) {
			arr2[i] = scan.nextInt();
			if (max < arr2[i]) {
				max = arr2[i];
			}
		}
		long sum = 0;
		for (int i = 0; i < n; ++i) {
			if (arr1[i] <= max + 1) {
				sum += max + 1 - arr1[i];
			}
		}

		System.out.println(sum);
	}

}
