package cc;

import java.util.Scanner;

public class birthday_candles {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr=new int[n];
		int max =0,count=0;
		for(int i=0;i<n;++i){
			arr[i]=scan.nextInt();
			if(arr[i]==max){
				++count;
			}
			if(arr[i]>max){
				max=arr[i];
				count=1;
			}
			
		}
System.out.println(count);
scan.close();
	}

}
