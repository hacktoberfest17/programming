package cc;

import java.util.Arrays;
import java.util.Scanner;

public class PartitionTheSet {
	static boolean done = true;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();
		while (t > 0) {
			--t;

			int x = scan.nextInt();
			int n = scan.nextInt();

			if ((((n * n + 1) / 2) - x) % 2 != 0) {
				System.out.println("impossible");
				continue;
			}

			int[] arr = new int[n + 1];
			Arrays.fill(arr, -1);
			int sum_left = 0, sum_right = 0;
			boolean done_last_left = false;
			int left = 1, right = n, temp = 0;

			while (left < right) {

				if (!done_last_left) {

					sum_left += arr[left] + arr[right];
					done_last_left = true;
					arr[left] = arr[right] = 0;

				} else {

					done_last_left = true;
					sum_left += arr[left] + arr[right];
					arr[left] = arr[right] = 1;

				}
				++left;
				--right;

				if (left == x || right == x) {
					++left;
					--right;
					temp = n + 1 - x;
					if (temp == x)
						temp = 0;
				}
			}

			do {
				if(temp!=0) {
					if(sum_left==sum_right) {
						if(temp%2==0) {
							if(arr[temp/2]==0) {
								arr[temp/2]=1;
								arr[temp]=0;
							}else {
								arr[temp/2]=0;
								arr[temp]=1;
							}
						}else {
							if(arr[temp*2]==0) {
								arr[temp*2]=1;
								arr[temp]=0;
							}else {
								arr[temp*2]=0;
								arr[temp]=1;
							}
							
						}
					}
				}

			} while (sum_left != sum_right);

			for (int i = 1; i < n + i; ++i) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}
		scan.close();

	}

	private static void func(int n, int x, int num, String str, int sum, int currSum) {

		if (currSum > sum || num > n + 1 || done) {
			return;
		}
		if (num > n && currSum == sum) {
			System.out.println(str);
			done = true;
			return;
		}
		if (num == x) {
			func(n, x, num + 1, str + "2", sum, currSum);
			return;
		}
		if (!done)
			func(n, x, num + 1, str + "0", sum, currSum);
		if (!done)
			func(n, x, num + 1, str + "1", sum, currSum + num);
	}

}
