package cc;

import java.util.Scanner;

public class CodeArenaDayNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t > 0) {
			int n = scan.nextInt();

			int[] arr = new int[n + 1];

			for (int i = 1; i <= n; ++i) {

				arr[i] = scan.nextInt();
			}
			long milestone = scan.nextLong();

			long vsf = 0;
			while (true) {
				if (vsf * 2 < milestone) {
					vsf *= 2;
				}
				for (int i = 1; i <= n; ++i) {
					vsf += arr[i];
					if (vsf >= milestone) {
						System.out.println(i);
						break;
					}
				}
				if (vsf >= milestone) {
					break;
				}

			}
			--t;
		}

		scan.close();
	}

}
