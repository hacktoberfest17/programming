package cc;

import java.util.Scanner;

public class TaskSchedule {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			int num = 0, temp = 0;
			int n = scan.nextInt();
			int[] arr1 = new int[n];
			int[] arr2 = new int[n];
			int upper = -1;
			for (int i = 0; i < n; ++i) {
				arr1[i] = scan.nextInt();
				if (upper < arr1[i])
					upper = arr1[i];
				arr2[i] = scan.nextInt();
			}
			int start, end;
			for (int i = 0; i < n; ++i) {
				start = arr1[i];
				for (int j = 0; j < n; ++j) {
					end = arr2[j];

				}
			}
			--t;
		}
	}

}
