package cc;

import java.util.Arrays;
import java.util.Scanner;

public class acmcomp {

	 public static void main(String args[] ) throws Exception {
		    Scanner scan = new Scanner (System.in);
		      long  n=scan.nextLong();
		     Boolean[] arr = new Boolean[(int)((n+1)/2)];
		     Arrays.fill(arr, false);
		    int m;
		 for(long i=0;i<n;++i){
		          m=scan.nextInt();
		            if(arr[m])
		            arr[m]=false;
		            else
		            arr[m]=true;
		 }
		 System.out.println("9");
		 for(int i=0;i<(int)(n/2);++i){
		     if(arr[i]==true)
		     {
		                 System.out.print(i);
		                 break;

		     }
		 }

	 }}
