package cc;

import java.util.Scanner;

public class CodeArenaJUnglyMathematics {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int count = 0;

		for (int i = 0; i < n; ++i) {
			a[i] = scan.nextInt();
			b[i] = scan.nextInt();
			c[i] = scan.nextInt();
		}

		for (int i = 0; i < n; ++i) {

			if ((b[i] * b[i] - 4 * a[i] * c[i]) >= 0) {
				++count;
			}
		}
		System.out.println(count);

	}

}
