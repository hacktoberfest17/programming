package cc;

import java.util.Scanner;

public class littleChefAndSums {

	public static void main(String[] args) {
		int t, n;
		Scanner scan = new Scanner(System.in);
		t = scan.nextInt();
		while (t > 0) {
			n = scan.nextInt();
			int[] arr = new int[n];
			int min = Integer.MAX_VALUE, index = 0;
			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
				if (arr[i] < min) {
					min = arr[i];
					index = i;
				}
			}
			System.out.println(index + 1);
			--t;
		}
	}

}
