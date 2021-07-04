package cc;

import java.util.Scanner;

public class Encryption {
	public static int power(int n) {
		int i = 0;
		while (i * i <= n) {
			++i;
		}
		return i;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		scan.close();
		int count = 0;
		StringBuilder que = new StringBuilder();
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) != ' ') {
				que.append(s.charAt(i));
				++count;
			}
		}
		s = que.toString();
		int col = (int) Math.sqrt(count);
		int row = power(count);
		for (int i = 0; i < col+1; ++i) {
			for (int j = i; j < count; j += row) {
				System.out.print(s.charAt(j));
			}
			System.out.print(" ");
		}

	}
}
