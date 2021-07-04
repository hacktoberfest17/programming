package cc;

import java.util.Scanner;

public class KillTheBirds {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();
		while (t > 0) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int n = scan.nextInt();
			int w = scan.nextInt();
			double p1 = scan.nextLong();
			double p2 = scan.nextLong();
			p1 /= 100;
			p2 /= 100;

			double ans = calc(x, y, w, n, p1, p2, 0) * 100;
			System.out.printf("%.6f", ans);
			--t;
		}

		scan.close();
	}

	private static double calc(int x, int y, int w, int n, double p1, double p2, int minPoint) {
		if (n == 0) {
			if (w > 0)
				return 0;

			return 1;
		}
		if (w < 0) {
			return 1;
		}

		double ans1 = calc(x, y, w - x, n - 1, p1, p2, minPoint) * p1;
		double ans2 = calc(x, y, w - y, n - 1, p1, p2, minPoint) * p2;

		return Math.max(ans1, ans2);
	}

}
