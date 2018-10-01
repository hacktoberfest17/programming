package cc;

import java.util.Scanner;

public class ColourfulKnapsap {

	public static boolean knapsap(int vidx, int[] w, int[] colours, int[] c, int m, int number, int weight, int x) {
		if (weight > x)
			return false;
		if (vidx == w.length) {
			if (number == m)
				return true;
			else
				return false;
		}

		boolean rv;

		if (colours[c[vidx]] != 0) {
			return false;
		}
		weight += w[vidx];
		colours[c[vidx]] = 1;
		rv = knapsap(vidx + 1, w, colours, c, m, number+1, weight, x);
		colours[c[vidx]] = 0;
		return rv;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean b=true,B;
		int n = scan.nextInt();
		

		int m = scan.nextInt();
		int[] w = new int[n];
		int[] c = new int[n];
		int[] colour = new int[m + 1];
		int number = 0;
		int x = scan.nextInt();

		for (int i = 0; i < n; ++i) {
			w[i] = scan.nextInt();

		}
		for (int i = 0; i < n; ++i) {
			c[i] = scan.nextInt();

		}
		 B = knapsap(0, w, colour, c, m, number, 0, x);
		if (b)
			System.out.println("1");
		else
			System.out.println("-1");
	}

}
