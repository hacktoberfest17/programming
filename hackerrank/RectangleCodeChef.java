package cc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RectangleCodeChef {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < 4; ++i) {
				int a = scan.nextInt();

				if (map.containsKey(a)) {
					map.put(a, map.get(a) + 1);
				} else {
					map.put(a, 1);
				}
			}
			ArrayList<Integer> list = new ArrayList<>(map.keySet());
			boolean flag = true;

			for (int i : list) {
				if (map.get(i) != 2) {
					flag = false;
					break;
				}
			}
			if (list.size() == 1) {
				flag = true;
			}
			if (flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			--t;
		}
		scan.close();
	}

}
