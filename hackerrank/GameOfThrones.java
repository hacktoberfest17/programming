package cc;

import java.util.Scanner;

public class GameOfThrones {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		in.close();
		int[] arr = new int[26];
		for (int i = 0; i < s.length(); ++i) {
			arr[s.charAt(i) - 'a']++;
		}
		int odd = 0;
		for (int i = 0; i < 26; ++i) {
			if (arr[i] % 2 != 0) {
				++odd;
				if (odd == 2) {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
	}

}
