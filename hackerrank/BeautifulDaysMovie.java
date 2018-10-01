package cc;

import java.util.Scanner;

public class BeautifulDaysMovie {
	public static int reverse(int n){
		int num=0;
		while(n>0){
			num*=10;
			num+=n%10;
			n=n/10;
			
		}
		return num;
	}
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int k= in.nextInt();
		int count=0;
		for(int i=n1;i<=n2;++i){
			int diff=Math.abs(i-reverse(i));
			if(diff%k==0)
				++count;
		}
		System.out.println(count);
		in.close();
	}
}
