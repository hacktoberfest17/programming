package cc;

import java.util.Scanner;

public class treelength {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t > 0) {
			int ans = 1, n = in.nextInt();
			for (int i = 0; i < n; ++i) {
				if (i % 2 == 0)
					ans *= 2;
				else
					ans += 1;
			}
			System.out.println(ans);
			--t;
		}
		in.close();
	}
}
