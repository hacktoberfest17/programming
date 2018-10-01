package cc;

import java.util.Scanner;

public class MaximumXOR {

	public static void main(String[] args) {
		int a, b;
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextInt();
		int max = 0, temp = 0;
		for (int i = a; i < b; ++i) {
			for (int j = i; j < b; ++j) {
				temp = i ^ j;
				if (temp > max)
					max = temp;
			}
		}
		scan.close();
		System.out.println(max);
	}

}
