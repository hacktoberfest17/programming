package cc;

import java.util.Scanner;

public class HalloweenSale {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int d = in.nextInt();
		int m = in.nextInt();
		int s = in.nextInt();
		int answer = howManyGames(p, d, m, s);
		System.out.println(answer);
		in.close();
	}

	private static int howManyGames(int p, int d, int m, int s) {
		int n = 0;
		while (s - p >= 0) {
			s -= p;
			++n;
			p -= d;
			if (p < m) {
				p = m;
			}
		}

		return n;
	}

}
