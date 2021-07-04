package cc;

import java.util.Scanner;

public class DrawingBook {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = in.nextInt();
		
		int mid = n / 2 + 1;
		int i = 1, steps = 0;
		if (p <= mid) {
			while (i <=p) {
				i ++;
				++steps;
			}
		} else {
			i = n ;
			while (i >=p) {
				i --;
				++steps;
			}
		}
		System.out.println((steps)/2);
		in.close();
	}
}