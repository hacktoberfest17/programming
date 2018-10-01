package cc;

import java.util.Scanner;

public class MinimumLoss {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int n=in.nextInt();
		int[] a = new int[n];

		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		in.close();
		int min=a[0]+a[1],min1=0;
	
	for(int i=0;i<n-1;++i){
		for(int j = i+1;j<n;++j){
		min1=a[i]-a[j];
			if(min>min1&&min1>0)
				min=min1;
			
		}
		
	}
	System.out.println(min);
	}

}
