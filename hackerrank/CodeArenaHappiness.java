package cc;

import java.util.Scanner;

public class CodeArenaHappiness {

	private static int maxIndex(int[] arr) {
		int maxval = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] > maxval) {
				index = i;
				maxval = arr[i];
			}
		}

		return index;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		luluTarika();
	}

	private static void luluTarika() {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t > 0) {
			int n = scan.nextInt();
			int[] happiness = new int[n];
			int[] anger = new int[n];
			int angersum = 0, happy = 0, index = -1;

			for (int i = 0; i < n; ++i) {
				happiness[i] = scan.nextInt();
				anger[i] = scan.nextInt();
				angersum += anger[i];
			}
			// index = maxIndex(anger);
			// angersum -= anger[index];
			// happy += happiness[index];
			// anger[index] = Integer.MIN_VALUE;
			//
			// index = maxIndex(anger);
			// angersum -= anger[index];
			// happy += happiness[index];

			index = maxIndex(happiness);
			happy += happiness[index] + anger[index];

			happiness[index] = Integer.MIN_VALUE;

			index = maxIndex(happiness);
			happy += happiness[index] + anger[index];

			System.out.println(happy - angersum);
			// System.out.println(calcHappy(happiness, anger, 0, 0));

			--t;
		}
	}

	private static int calcHappy(int[] happiness, int[] anger, int vidx, int num) {

		if (vidx == happiness.length) {
			return 0;
		}

		int rv1 = Integer.MIN_VALUE, rv2 = Integer.MIN_VALUE;

		if (num < 2) {
			rv1 = happiness[vidx] + calcHappy(happiness, anger, vidx + 1, num + 1);
		}
		rv2 = calcHappy(happiness, anger, vidx + 1, num) - anger[vidx];

		return Math.max(rv1, rv2);

	}

	private static class pair implements Comparable<pair>{
		int happy;
		int angry;
		@Override
		public int compareTo(pair o) {
			return 0;
		}
	}
}
