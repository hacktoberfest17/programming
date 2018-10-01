package cc;

import java.util.Arrays;
import java.util.Scanner;

public class DaysOWeek {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t > 0) {
			int n = scan.nextInt();
			String str = scan.nextLine();

			int[] days = new int[7];
			int num = n / 7;
			Arrays.fill(days, num);

			int k;
			if (str.equals(" mon")) {
				k = 0;
			} else if (str.equals(" tues")) {
				k = 1;
			} else if (str.equals(" wed")) {
				k = 2;
			} else if (str.equals(" thurs")) {
				k = 3;
			} else if (str.equals(" fri")) {
				k = 4;
			} else if (str.equals(" sat")) {
				k = 5;
			} else {
				k = 6;
			}

			num = n % 4;
			while (num > 0) {
				days[k]++;
				num--;
				k++;
				if (k >= 7)
					k = 0;
			}

			for (int x : days) {
				System.out.print(x + " ");
			}
			System.out.println();
			--t;
		}
	}

}
