package cc;

import java.util.Scanner;

public class power_sum {
	static int count = 0;

	public static void pow(int target, int power, int ans, int r) {
		if (ans > target)
			return;
		if (ans == target) {
			++count;
			return;
		}
		for (int i = r; ans + Math.pow(i, power) <= target; ++i)
			pow(target, power, ans + (int) Math.pow(i, power), i + 1);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int target = in.nextInt();
		int power = in.nextInt();
		pow(target, power, 0, 1);
		System.out.println(count);
		in.close();
	}

}
