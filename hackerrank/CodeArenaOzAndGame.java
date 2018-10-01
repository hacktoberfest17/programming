package cc;

import java.util.Arrays;
import java.util.Scanner;

public class CodeArenaOzAndGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {

				arr[i] = scan.nextInt();
			}

			Arrays.sort(arr);
			int count = 0;

			for (int i = 1; i < n - 1; ++i) {
				if (arr[i - 1] != arr[i] - 1 && arr[i + 1] != arr[i] + 1) {
					++count;
				}
			}
			System.out.println(count);

			--t;
		}
	}

}
