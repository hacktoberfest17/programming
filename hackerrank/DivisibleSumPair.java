package cc;

import java.util.Scanner;

public class DivisibleSumPair {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] ar = new int[n];
		int count = 0;
		for (int ar_i = 0; ar_i < n; ar_i++) {
			ar[ar_i] = in.nextInt();
		}

		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if((ar[i]+ar[j])%k==0){
					++count;
				}
			}
		}
		System.out.println(count);
		in.close();
	}

}
