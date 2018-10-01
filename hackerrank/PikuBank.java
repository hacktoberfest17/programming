package cc;

import java.util.Scanner;

public class PikuBank {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		while (t > 0) {
			int d = scan.nextInt();
			int a = scan.nextInt();
			int m = scan.nextInt();
			int b = scan.nextInt();
			int x = scan.nextInt();
//			int count=0;
//			while(d<x) {
//				++count;
//
//			if((m+1)%count==0) {
//				d+=b;
//			}else {
//				d+=a;
//			}
//			}
//			
//			System.out.println(count);
			int y=0;
	int intrest = x-d;
			while(true) {
			if(intrest==(a+b)*(y/(m+1))+(y%(m+1))*a) {
				break;
			}
			++y;
			
		}
			System.out.println(y);
			--t;
			}
		
		scan.close();
		
	}

}
