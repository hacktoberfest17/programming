package cc;

import java.util.Scanner;

public class bonappetite {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] ar = new int[n];
		int sum = 0;
		for (int ar_i = 0; ar_i < n; ar_i++) {
			ar[ar_i] = in.nextInt();
			sum += ar[ar_i];
		}
		sum -= ar[k];
		sum /= 2;
		int b = in.nextInt();
		if (sum == b)
			System.out.println("Bon Appetit");
		else
			System.out.println(b - sum);
		in.close();
	}

}
