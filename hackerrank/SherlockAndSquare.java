package cc;

import java.util.Scanner;

public class SherlockAndSquare {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			float a0 = (float) Math.sqrt(a);
			float b0 = (float) Math.sqrt(b);

			if (a0 - (int) a0 > 0) {
				a0 = (int) (1 + a0);
			}
			if (b0 - (int) b0 > 0) {
				b0 = (int) (b0);
			}
			System.out.println((int)(b0 - a0)+1);
			--t;
		}
	}

}
