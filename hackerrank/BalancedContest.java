package cc;

import java.util.Scanner;

public class BalancedContest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {

			int n, p, pd, pe, temp, cakewalk = 0, difficult = 0;
			n = scan.nextInt();
			p = scan.nextInt();
			pd = p / 10;
			pe = p / 2;
			for (int i = 0; i < n; ++i) {
				temp = scan.nextInt();
				if (temp >= pe)
					++cakewalk;
				if (temp <= pd)
					++difficult;
			}
			if (cakewalk == 1 && difficult == 2)
				System.out.println("yes");
			else
				System.out.println("no");

			--t;
		}
		scan.close();
	}

}
