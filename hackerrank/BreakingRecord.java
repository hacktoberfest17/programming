package cc;

import java.util.Scanner;

public class BreakingRecord {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] s = new int[n];
		for (int s_i = 0; s_i < n; s_i++) {
			s[s_i] = in.nextInt();
		}
		int min = s[0], max = s[0], count = 0, countmin = 0;
		for (int i = 1; i < s.length; ++i) {
			if (max < s[i]) {
				++count;
				max = s[i];
			}
			if (min >s[i]) {
				min = s[i];
				++countmin;
			}
		}
		
		System.out.println(count+" "+countmin);
	}
}
