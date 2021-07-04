package cc;

import java.util.Arrays;
import java.util.Scanner;

public class CodeArenaDexterAndBattery {

	static int ans = 0;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t > 0) {
			--t;
			int n = scan.nextInt();
			int m = scan.nextInt();

			boolean[] arr = new boolean[m + 1];
			Arrays.fill(arr, true);

			for (int i = 2; i < m + 1; ++i) {
				if (arr[i] == false)
					continue;

				int k = 2;
				while (k * i < m) {
					arr[k * i] = false;
					++i;
				}
			}
			ans = 0;

			System.out.println(ans);
		}
		scan.close();

	}

}
