package cc;

import java.util.Scanner;

public class MinimumGoodPermutation {

	public static void main(String[] args) {

		int t, n;
		Scanner scan = new Scanner(System.in);
		t = scan.nextInt();
		int[] arr = new int[2];
		while (t > 0) {
			n = scan.nextInt();
			int i;
			for (i = 1; i < n - 2; i += 2) {
				System.out.print(i + 1 + " " + i + " ");
			}
			if (n % 2 == 0) {
				System.out.print(i + 1 + " " + i);
			} else {
				System.out.print(i +1 + " " + (i + 2) + " " + (i ));
			}

			System.out.println();
			--t;
		}

	}

}
