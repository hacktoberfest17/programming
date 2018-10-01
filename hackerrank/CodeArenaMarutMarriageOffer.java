package cc;

import java.util.Scanner;

public class CodeArenaMarutMarriageOffer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] quality = new int[n];
		for (int i = 0; i < n; ++i) {
			quality[i] = scan.nextInt();
		}
		int m = scan.nextInt();
		boolean[][] table = new boolean[m][1000];
		for (int i = 0; i < m; ++i) {
			String str = scan.nextLine();
			String temp = new String();
			int num;
			for (int k = 0; k < str.length(); ++k) {
				if (str.charAt(k) == ' ') {
				num = Integer.parseInt(temp);
					temp = new String();
					table[i][num] = true;
					continue;
				}
				temp += str.charAt(k);
			}
		}

		int count = 0;

		for (int m1 = 0; m1 < m; ++m1) {
			for (int i = 0; i < quality.length && m1 < m; ++i) {
				if (table[m1][i] == false) {
					m1++;
					i = 0;
				}
			}
			++count;
		}

		System.out.println(count);
	}

}