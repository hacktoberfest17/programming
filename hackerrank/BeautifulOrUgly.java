package cc;

import java.util.Scanner;

public class BeautifulOrUgly {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			System.out.println(func());
			--t;
		}

		scan.close();
	}

	private static String func() {
		Scanner scan = new Scanner(System.in);
		boolean acc = true;
		int i, prev , curr, m;
		int n = scan.nextInt();
		int arr[] = new int[n + 1], array[] = new int[n];
		for (i = 0; i < n; ++i){
			array[i] = scan.nextInt();
		}
		prev = array[0];
		m = n;
		i = 0;
		while (m > 0) {
			curr = array[i];
			if (curr > n)
				return "Ugly";

			if (arr[curr] != 0) {
				return "Ugly";
			} else {
				arr[curr]++;
			}
			if (prev > curr)
				acc = false;

			prev = curr;
			--m;
			++i;
		}
		if (acc)
			return "Ugly";

		else
			return "Beautiful";
	}

}
