package cc;

import java.util.Scanner;

public class Hurdlerace {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] height = new int[n];
		int max = 0;
		for (int height_i = 0; height_i < n; height_i++) {
			height[height_i] = in.nextInt();
			if (max < height[height_i])
				max = height[height_i];
		}
		max = max - k;
		if (max < 0)
			max = 0;

		System.out.print(max);
	}
}
