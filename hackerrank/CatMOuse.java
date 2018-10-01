package cc;

import java.util.Scanner;

public class CatMOuse {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int z = in.nextInt();

			int i = Math.abs(x - z);

			int j = Math.abs(y - z);

			if (i == j) {
				System.out.println("Mouse C");
			} else if (i > j) {
				System.out.println("Cat B");
			} else {
				System.out.println("Cat A");
			}
		}
in.close();
	}

}
