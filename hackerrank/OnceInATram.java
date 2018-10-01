package cc;

import java.util.Scanner;

public class OnceInATram {
	public static int sum(int n) {
		int sum = 0;
		while (n != 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String ch = in.next();
		int one = Integer.parseInt(ch.substring(0, 3));
		int two = Integer.parseInt(ch.substring(3));
		int sum1 = sum(one);
		int sum2 = sum(two);
		do {
			if (two == 999) {
				++one;
				sum1 = sum(one);
				two = 0;
			}
			++two;
			sum2 = sum(two);
		} while (sum2 != sum1);

		if (two < 100) {
			if (two < 10) {
				one *= 100;
			} else
				one *= 10;

		}
		System.out.println(one + "" + two);

		in.close();

	}

}
