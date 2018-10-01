package cc;

import java.util.Scanner;

public class CounterGameProblem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n, t = scan.nextInt();
		int count;
		long[] arr = new long[65];
		arr[0] = 1;
		for (int i = 1; i < 64; ++i) {
			arr[i] = 2 * arr[i - 1];
		}
		while (t > 0) {
			n = scan.nextInt();
			
			print(arr,n);
			--t;
		}
		scan.close();
	}

	private static void print(long[] arr,  long n) {
		int count=0;
		while (n > arr[count]) {
			++count;
		}
		if (arr[count] == n) {
			if (count % 2 == 0)
				System.out.println("Richard");
			else
				System.out.println("Louise");
			return;
		} else {
			n-=count;
			print(arr,  n);
		}		
	}

}
