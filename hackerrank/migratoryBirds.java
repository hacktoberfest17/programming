package cc;

import java.util.Scanner;

public class migratoryBirds {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		int[] store = new int[6];
		for (int ar_i = 0; ar_i < n; ar_i++) {
			ar[ar_i] = in.nextInt();
			store[ar[ar_i]] += 1;
		}
		int max = 0, index=0;
		for (int i = 1; i <= 5; ++i) {
			if (max < store[i]) {
				max = store[i];
				index=i;
			}
		}
		System.out.println(index);
		in.close();
	}

}
