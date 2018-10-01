package cc;

import java.util.Scanner;

public class knapsack {

	public static int knapsack(int[] wts, int[] price, int cap, int vidx) {
		if (vidx == wts.length)
			return 0;

		int sum1 = knapsack(wts, price, cap, vidx + 1);
		int sum2 = 0;
		if (cap - wts[vidx] >= 0)
			sum2 = price[vidx] + knapsack(wts, price, cap - wts[vidx], vidx + 1);

		return Math.max(sum1, sum2);

	}

	public static int knapsackbetter(int[] wts, int[] price, int cap, int vidx, int[][] storage) {
		if (vidx == wts.length)
			return 0;

		if (storage[cap][vidx] != 0) {
			return storage[cap][vidx];
		}

		int sum1 = knapsackbetter(wts, price, cap, vidx + 1, storage);
		int sum2 = 0;
		if (cap - wts[vidx] >= 0)
			sum2 = price[vidx] + knapsackbetter(wts, price, cap - wts[vidx], vidx + 1, storage);

		int rv = Math.max(sum1, sum2);
		storage[cap][vidx] = rv;
		return rv;

	}

	public class Node {
		int capacity;
		int price;
	}

	// public static int knapsack(int[] wts,int price,Node[] list,int vidx){
	// if (vidx == wts.length)
	// return 0;
	//
	// int sum1 = knapsack(wts, price, list, vidx + 1);
	// int sum2 = 0;
	// if (cap - wts[vidx] >= 0)
	// sum2 = price[vidx] + knapsack(wts, price, list., vidx + 1);
	//
	// return Math.max(sum1, sum2);
	//
	// }
	// }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cap = 40;
		// int n = in.nextInt();
		int[] wts = { 20, 5, 17, 10, 18 };
		int[] val = { 10, 15, 5, 17, 6 };

		System.out.println(knapsackbetter(wts, val, cap, 0, new int[cap + 1][wts.length]));
		in.close();
	}
}
// 4 5
// 1 8
// 2 4
// 3 0
// 2 5
// 2 3
