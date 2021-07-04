package cc;

import java.util.Scanner;

public class pair {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int diff = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = scan.nextInt();
		}
		arr=mergesort(arr, arr.length-1,0);
		scan.close();
		int count=0,d;
		for(int i=0;i<n;++i){
			for(int j=i+1;j<n;++j){
				d=arr[j]-arr[i];
				if(diff==d)
					++count;
				if(d>diff)
					break;
			}
		}
		System.out.println(count);
	}

	public static int[] merge(int[] one, int[] two) {
		int[] arr = new int[one.length + two.length];
		int i = 0, j = 0, k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] > two[j]) {
				arr[k] = two[j];
				++j;
				++k;
			} else {
				arr[k] = one[i];
				++i;
				++k;
			}
		}
		while (i < one.length) {
			arr[k] = one[i];
			++i;
			++k;
		}
		while (j < two.length) {
			arr[k] = two[j];
			++j;
			++k;
		}
return arr;
	}

	
	public static int[] mergesort(int[] arr,int hi , int lo)
	{
		if(hi==lo){
			int[] b = new int[1];
			b[0] = arr[lo];
			return b;
		}
		int mid=(hi+lo)/2;
		int[] one=mergesort(arr, hi, mid+1);

		int[] two=mergesort(arr, mid,lo);
return(merge(one, two));
	}
}
