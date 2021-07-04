package cc;

import java.util.Scanner;

public class NewYearChaos {

	public static int bubbleSort(int arr[]) {
		int x = 0;
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					// swap temp and arr[i]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					++x;
				}

		return x;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();

		while (t > 0) {
			--t;
			boolean flag = false;
			int n = scanner.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = scanner.nextInt();
				if (arr[i] > (i + 3) || arr[i] < (i - 1)) {
					flag = true;
				}
			}
			if (!flag) {
				System.out.println(bubbleSort(arr));
			} else {
				System.out.println("Too chaotic");

			}
		}

		scanner.close();
	}

}
