package cc;

import java.util.Scanner;

public class SubhamAndSubarrayXOR {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int[] arr = new int[n];
		int total = 0;
		for (int i = 0; i < n; ++i) {
			arr[i] = scan.nextInt();
			total += arr[i];
		}
		int suml = 0, sumr = 0, max = Integer.MIN_VALUE;
		for (int i = 1; i < n; ++i) {
			suml = 0;
			for (int j = 0; j < i; ++j) {
				suml += arr[j];
			}
			sumr = total - suml;
			if (max < (suml ^ sumr)) {
				max = suml ^ sumr;
			}
		}
		System.out.println(max);
	}

}
