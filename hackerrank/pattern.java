package cc;

import java.util.Scanner;

public class pattern {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		for(int i=0;i<t;++i) {
			for(int j=1;j<=t-i;++j) {
				System.out.print(j+ " ");
			}
			for(int k=0;k<2*i-1;++k) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
