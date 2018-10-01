package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class BirthdayBar {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] s = new int[n];
		for (int s_i = 0; s_i < n; s_i++) {
			s[s_i] = in.nextInt();
		}
		int d = in.nextInt();
		int m = in.nextInt();
		int count = 0, sum;
		for (int i = 0; i <= n - m ; ++i) {
			sum = 0;
			for (int j = 0; j < m; ++j) {
				sum += s[j+i];
			}
			if (sum == d)
				++count;
		}
	
		System.out.println(count);
		in.close();
	}
}
