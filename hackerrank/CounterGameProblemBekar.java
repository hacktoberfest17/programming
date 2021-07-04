package cc;

import java.util.Scanner;

public class CounterGameProblemBekar {

	public static int check(int n) {
		int num = 1;
		while (num * 2 < n) {
			num = num * 2;
		}
		return num;

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			player(scan.nextInt(), "Louise");
			--t;
		}
		scan.close();
	}

	private static void player(int n, String s) {
		if (n == 1) {
			System.out.println(s);
			return;
		}
		if (s.equals("Louise"))
			s = "Richard";
		else
			s = "Louise";

		player(check(n), s);

	}

}
