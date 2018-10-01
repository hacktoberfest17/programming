package cc;

import java.util.Scanner;

public class ArrayLeftRotation {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n , d;
		int[] arr;
		n = scanner.nextInt();
		d= scanner.nextInt();
		
		arr = new int[n];
		for(int i =0;i<n;++i) {
		
			arr[i]=scanner.nextInt();
		}		
		for(int i =0;i<n;++i) {
//			newarr[i]=arr[(i+d)%n];
			System.out.print(arr[(i+d)%n]+" ");
		}
		
	
		
	}

}
