package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int m = scan.nextInt();

		int[] arr = new int[m];
		for (int i = 0; i < m; ++i) {
			arr[i] = scan.nextInt();
		}
		int[] memory = new int[n + 1];

		calc(n, arr, memory);
		System.out.println(memory[n]);

		scan.close();

	}

	private static int calc(int n, int[] arr, int[] memory) {

		if (n < 0)
			return 0;
		if (n == 0)
			return 1;

		if (memory[n] != 0)
			return memory[n];
		
		int count = 0;
		for (int i = 0; i < arr.length; ++i) {
			if(n-arr[i]>=0)
			count += calc(n - arr[i], arr, memory);
		}
		memory[n] = count;
		return count;
	}

}
