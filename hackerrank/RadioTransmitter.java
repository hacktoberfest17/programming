package cc;

import java.util.Scanner;

public class RadioTransmitter {
	public static int find(int[] arr, int i){
		for(int j=i;j<arr.length;++j){
			if(arr[j]==1)
				return j;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int[] a = new int[100001];
int val;
		for (int i = 0; i <n; i++) {
			val=in.nextInt();
			a[val] = 1;
		}
		in.close();
int count=0;
	for(int i=k;i<a.length;++i){
		if(a[i]==1){
			
		}
	}
		System.out.println(count);
	}
}
