package cc;

import java.util.Scanner;

public class LargestPermutation {
	public static boolean largest(int[] arr, int n, int pos) {
		int i = pos, num = n - pos;
		while (arr[i] == num) {
			if(i==arr.length-1)
				return true;
			--num;
			++i;
			if(i==arr.length-1)
				return true;
		}
		int j;
		for (j = i; j < n; ++j) {
			if (arr[j] == num)
				break;
		}
		int temp = arr[i];
		arr[i] = num;
		arr[j] = temp;
		if (i == n - 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = scan.nextInt();
		}
		int pos = 0;
		boolean flag;
		while (k > 0) {
			flag = largest(arr, n, pos);
			--k;
			++pos;
			if(flag==true)
				break;
		}

		for (int val : arr) {
			System.out.print(val + " ");
		}
		scan.close();
	}

}
