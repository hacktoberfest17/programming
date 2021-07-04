package cc;

import java.util.Scanner;

public class noorAndPond {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		while (t > 0) {
			--t;
			int n = scan.nextInt();
			int[] s = new int[n];
			int[] e = new int[n];

			for (int i = 0; i < n; ++i) {
				s[i] = scan.nextInt();
				e[i] = scan.nextInt();
			}

			System.out.println(calc(0,0,s,e,0,0));
		}

		scan.close();
	}

	private static int calc(int vidx_s, int vidx_e, int[] s, int[] e, int count,int max_subset) {
		if(vidx_s==s.length||vidx_e==e.length) {
			return 0;
		}
		
		
		
	}

}
