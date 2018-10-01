package cc;

import java.util.Scanner;

public class cbmaxmin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		a[0] = in.nextInt();
		int max=a[0],min=a[0];
		for (int a_i = 1; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
			if(max<a[a_i])
				max=a[a_i];
			if(min>a[a_i])
				min=a[a_i];
		}
		System.out.println(max);
		System.out.println(min);
		in.close();
	}

}
