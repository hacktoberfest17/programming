package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class fibonacciModified {
//	public static long fibomodified(int n,long[] arr,int t1,int t2){
//		if(n==1)
//			return t1;
//		if(n==2)
//			return t2;
//		if(arr[n]!=0)
//			return arr[n];
//		long n2=fibomodified(n-1,arr,t1,t2);
//		
//		long ans= fibomodified(n-2,arr,t1,t2)+n2*n2;
//		arr[n]=ans;
//		return ans;
//	}
//
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int t1 = in.nextInt();
//		int t2 = in.nextInt();
//		int n = in.nextInt();
//
//		long[] arr= new long[n+1];
//		in.close();
//		System.out.println(fibomodified(n, arr,t1,t2));
//	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger t1 = in.nextBigInteger();
		BigInteger t2 = in.nextBigInteger();
		int n = in.nextInt();

		in.close();
		BigInteger n1=t1,n2=t2,n3;
		for(int i=2;i<n;++i){
			n3=n1.add((n2.multiply(n2)));
			n1=n2;
			n2=n3;
		}
		System.out.println(n2);
	}

}
