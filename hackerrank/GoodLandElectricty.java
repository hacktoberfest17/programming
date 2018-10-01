package cc;

import java.util.Scanner;

public class GoodLandElectricty {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int[] a = new int[n];

		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		in.close();

		int count = 0;
		for (int i = k - 1; i < n; ++i) {
			if (a[i] == 0) {
				i -= 2;
				if (i <= -2) {
					count = -1;
					break;
				}
			} else if (a[i] == 1) {
				a[i] = 10;
				count++;

				if ((i + (k - 1) * 2 >= n - 1)&&(n-i>k)) {
				
					for (int j = i; j <= n - 1; ++j) {
						if (a[j] != 0)
							count++;
						System.out.println(count);
							return;
					}
					

				}

				i += (k - 1) * 2;
			} else if (a[i] == 10) {
				count = -1;
				break;
			}
		}
		System.out.println(count);
	}

}


