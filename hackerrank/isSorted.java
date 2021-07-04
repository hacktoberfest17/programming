package cc;

import java.util.Scanner;

public class isSorted {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[scan.nextInt()];
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = scan.nextInt();
		}
		System.out.println(istrue(arr, Integer.MIN_VALUE, 0));
	}

	private static boolean istrue(int[] arr, int val, int index) {
		if (index == arr.length)
			return true;

		boolean result = istrue(arr, arr[index], index + 1);
		if (!result)
			return result;
		if (val < arr[index])
			return true;
		else
			return false;

	}

}
