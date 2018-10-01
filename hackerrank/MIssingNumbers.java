package cc;

import java.util.Scanner;

public class MIssingNumbers {

	public static void main(String[] args) {
		int[] arr = new int[10001];
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 0; i < n; ++i) {
			arr[scan.nextInt()]++;
		}
		int m = scan.nextInt();
		for (int i = 0; i < m; ++i) {
			arr[scan.nextInt()]--;
		}

		for (int i = 0; i < 10001; ++i) {
			if (arr[i] < 0)
				System.out.print(i + " ");
		}
		scan.close();
	}

}
