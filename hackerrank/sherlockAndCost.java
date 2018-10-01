package cc;

import java.util.Scanner;

public class sherlockAndCost {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] sum = new int[t];
		int n = in.nextInt();
		int l=0;
		while(l<t){
		int k;
		if ((n) % 2 == 0)
			k = n - 1;
		else
			k = n - 2;
		int[] a = new int[n];
		
		int[] b = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		for (int i = 0; i < k; i += 2) {
			if (a[i] > a[i + 1]) {
				b[i] = a[i];
				b[i + 1] = 1;
			} else {
				b[i + 1] = a[i + 1];
				b[i] = 1;
			}
		}
		if ((n) % 2 != 0) {
			if (b[n - 2] == 1)
				b[n - 1] = a[n - 1];
			else
				b[n - 1] = 1;
		}

		
		for (int i = 1; i < n; ++i) {
			int x = b[i] - b[i - 1];
			if (x < 0)
				x *= -1;
			sum[l] += x;
		}
		++l;
		}
		for(int val:sum){
			System.out.println(val);
		}
	}

}
