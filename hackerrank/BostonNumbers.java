package cc;

import java.util.Scanner;

public class BostonNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long temp = n;
		long sum = 0;
		long i = 1;
		while (temp != 1) {
			++i;
			if (temp % i == 0) {
				temp /= i;
				sum += i;
				i = 2;
			}

		}
		temp = n;
		int rem = 0;
		while (temp != 0) {
			rem += temp % 10;
			temp /= 10;
		}

		if (sum == rem)
			System.out.println("1");
		else
			System.out.println("0");
		scan.close();
	}

}
