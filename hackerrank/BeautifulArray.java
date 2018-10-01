package cc;

import java.util.Scanner;

public class BeautifulArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t > 0) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
			}

			int ans = 0, n3 = 0, n2 = 0, n1 = 0;
			for (int i = 0; i < n; ++i) {
				arr[i] %= 4;
				if (arr[i] == 1)
					++n1;
				else if (arr[i] == 2)
					++n2;
				else if (arr[i] == 3)
					++n3;
			}

			if (n2 % 2 == 0) {
				ans += n2 / 2;
				if (n1 == n3) {
					ans += n1;
				} else if (n1 > n3) {
					ans += n3;
					n1 -= n3;
					if (n1 % 4 == 0)
						ans += (n1 / 4) * 3;
					else
						ans = -1;
				} else {
					ans += n1;
					n3 -= n1;
					if (n3 % 4 == 0) {
						ans += (n3 / 4) * 3;
					} else {
						ans = -1;
					}
				}

			} else {
				ans += n2 / 2;
				if (n1 == n3) {
					ans += n1;
				} else if (n1 > n3) {
					ans += n3;
					n1 -= n3;
					if (n1 % 4 == 0)
						ans += (n1 / 4) * 3;
					else if (n1 % 4 == 2) {
						ans += 2;
					} else
						ans = -1;
				} else {
					ans += n1;
					n3 -= n1;
					if (n3 % 4 == 0) {
						ans += (n3 / 4) * 3;
					} else if (n3 % 4 == 2) {
						ans += 2;
					} else {
						ans = -1;
					}
				}
			}
			System.out.println(ans);
			--t;
		}
	}

}
