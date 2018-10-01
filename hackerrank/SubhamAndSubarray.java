package cc;

import java.util.HashMap;
import java.util.Scanner;

public class SubhamAndSubarray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		int temp;

		for (int i = 0; i < n; ++i) {

			temp = scan.nextInt();
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}

		int size = map.size();
		System.out.println((size * (size + 1)) / 2);
		scan.close();
	}

}
