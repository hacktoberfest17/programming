package cc;

import java.util.Scanner;

public class hackerrankInString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String que = "hackerrank";
		int q = in.nextInt();
		while (q > 0) {
			String s = in.next();
			int j = 0, i;
			for (i = 0; i < s.length(); ++i) {
				if (s.charAt(i) == que.charAt(j)) {
					++j;
				}
				if (j == que.length())
					break;
			
			}
			if (j == que.length())
				System.out.println("YES");
			else
				System.out.println("NO");
			--q;
		}
		in.close();
	}
}
