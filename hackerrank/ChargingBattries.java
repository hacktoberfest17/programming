package cc;

import java.util.Scanner;

public class ChargingBattries {

	public class list {
		int x = 0;
		int y = 0;

		public list(int n) {
			list[] ob = new list[n];
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		list[] ob = new list[m];
		for (int i = 0; i < m; i++) {
			// ob[i]=new list();
			ob[i].x = in.nextInt();
			ob[i].y = in.nextInt();
		}
		list temp;
		int count = 1;
		while (count < m) {

			for (int i = 0; i < m - count; ++i) {
				if (ob[i].x > ob[i + 1].x) {
					temp = ob[i];
					ob[i] = ob[i + 1];
					ob[i + 1] = temp;
				}
				if (ob[i].x == ob[i + 1].x) {
					if (ob[i].y > ob[i + 1].y) {
						temp = ob[i];
						ob[i] = ob[i + 1];
						ob[i + 1] = temp;
					}
				}

			}
			++count;
		}

		int sum = Integer.MAX_VALUE, tem, x;
		for (int i = 0; i < m; ++i) {
			tem = 0;
			x = i + 1;
			for (int j = 0; j < k; ++j, ++x) {
				if (x == m) {
					x = 0;
				}

				if (ob[x - 1].x == ob[x].x) {
					tem += ob[x].y - ob[x - 1].y;
				} else {
					tem += ob[x].y;
				}
			}
			if (tem < sum)
				sum = tem;
		}

		System.out.println(sum);
		in.close();
	}

}
