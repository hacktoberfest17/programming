package cc;

import java.util.ArrayList;
import java.util.Scanner;

public class gridLandMetro {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int[][] arr = new int[k][3];
		for (int i = 0; i < k; ++i) {
			for (int j = 0; j < 3; ++j)
				arr[i][j] = in.nextInt();
		}
		long count = 0;
		
		int mul=0;
		int toggle = 0, check = arr[0][0];
		while (toggle < k) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(1);
			list.add(m);
			check = arr[toggle][0];
			if (check == -1)
				continue;
			mul++;    // for counting totally empty rows;
			for (int i = toggle; i < k; ++i) {
				if (arr[i][0] == check) {
					list = remaning(list, arr[toggle][1], arr[toggle][2]);
					arr[i][0] = -1;
				}

			}
			count += calc(list) + 2;

			++toggle;
		}
		count=count+(n-mul)*m;
		System.out.println(count);
		in.close();

	}

	public static ArrayList<Integer> remaning(ArrayList<Integer> list, int start, int end) {
		ArrayList<Integer> myarray = new ArrayList<>();
		int i, j, left, right;

		for (i = 0, j = 1; i < list.size() && j < list.size(); i += 2, j += 2) {
			left = list.get(i);
			right = list.get(j);
			if (start >=right) {
				myarray.add(left);
				myarray.add(right);
			} else {
				myarray.add(left);
				myarray.add(start);
				if (end <= right) {
					myarray.add(end);
					myarray.add(right);

				} else if (end >=list.get(j + 1)) {
					myarray.add(end);
					myarray.add(list.get(j + 2));
					i += 2;
					j += 2;
				}
				start = list.get(list.size() - 1) + 2;
			}
		}

		return myarray;
	}

	public static long calc(ArrayList<Integer> list) {
		int i, j;
		long count = 0;
		for (i = 0, j = 1; i < list.size() && j < list.size(); i += 2, j += 2) {
			int left = list.get(i);
			int right = list.get(j);
			count += right - left - 1;

		}
		return count;
	}
}
