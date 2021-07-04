package cc;

import java.util.Scanner;

public class ElectonicShop {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int n = in.nextInt();
		int m = in.nextInt();
		int[] keyboards = new int[n];
		for (int keyboards_i = 0; keyboards_i < n; keyboards_i++) {
			keyboards[keyboards_i] = in.nextInt();
		}
		int[] drives = new int[m];
		for (int drives_i = 0; drives_i < m; drives_i++) {
			drives[drives_i] = in.nextInt();
		}
		int sum = -1, sum1;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				sum1 = keyboards[i] + drives[j];
				if (sum1 > s)
					continue;
				if (sum1 > sum)
					sum = sum1;
			}
		}
		System.out.println(sum);
		in.close();
	}
}
