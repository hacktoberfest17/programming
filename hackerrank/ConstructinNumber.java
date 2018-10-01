package cc;

import java.util.Scanner;

public class ConstructinNumber {

	public static int retDigit(int num) {
		int temp = 0;
		while (num > 0) {
			temp += num % 10;
			num /= 10;
		}
		return temp;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			int n = scan.nextInt();
			int sum = 0;
			for (int i = 0; i < n; ++i) {
				int temp = scan.nextInt();
				sum += retDigit(temp);
			}
			if (sum % 3 == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			--t;

		}
		scan.close();
	}

}
