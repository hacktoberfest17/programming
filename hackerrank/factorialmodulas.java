package cc;

import java.util.Scanner;

public class factorialmodulas {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n+1];
		arr[n]=0;
		for (int i = 0; i < n; ++i)
			arr[i] = scan.nextInt();

		int count = 1;
		long n1 = 0, n2 = 1, n3, div = 1000000007;
		for (int i = 0; i < n; ++i) {
			while (count < arr[i]) {

				n3 = n1 + n2;
				n1 = n2;
				n2 = n3;

				++count;
			}
			System.out.println(n2 % div);
			if(count>arr[i+1])
			{
			n1 = 0;
			n2 = 1;
			count = 1;
			}
		}
		scan.close();
	}

}
