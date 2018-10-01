package cc;

import java.util.Scanner;

public class RicoHunterWordQuest {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	public static void display(int[] arr) {
		for (int val : arr)
			System.out.print(val + "  ");
		System.out.println();
	}

	public static void bubblesort(int[] arr) {
		int count = 1;
		while (count < arr.length) {
			for (int i = 0; i < arr.length - count; ++i) {
				if (arr[i] > arr[i + 1])
					swap(arr, i, i + 1);
			}
			++count;
		}
	}

	public static int search(int[] arr, int data) {
		int hi = arr.length - 1;
		int lo = 0;
		int mid;
		while (lo <= hi) {
			mid = (hi + lo) / 2;
			if (arr[mid] < data)
				lo = mid + 1;
			else if (arr[mid] > data)
				hi = mid - 1;
			else
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = scan.nextInt();
		}
		bubblesort(arr);
		int q = scan.nextInt();
		while (q > 0) {
			int n1 = scan.nextInt();
			int n2 = scan.nextInt();
			int ans = 0;
			int mid = search(arr, n2);
			if (n1 == 0)
				ans = n - mid + 1;
			else
				ans = n - mid;
			if (mid == -1)
				System.out.println("0");
			else
				System.out.println(ans - 1);
			--q;
		}
	}

}
