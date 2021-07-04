package cc;

import java.util.Scanner;

public class IceCreamParlor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			int m = in.nextInt();
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = in.nextInt();
			}
			int val = m;
			boolean b = false;
			for (int i = 0; i < n - 1; ++i) {
				val = m - arr[i];
				for (int j = i + 1; j < n; ++j) {
					if (val - arr[j] == 0) {
						b = true;
						j+=1;
						System.out.println(i+1 + " " + j);
						break;
					}
					if (b)
						break;

				}
			}
			--t;
		}
	}

}
