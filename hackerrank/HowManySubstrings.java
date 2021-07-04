package cc;

import java.util.ArrayList;
import java.util.Scanner;

public class HowManySubstrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		String s = in.next();

		for (int a0 = 0; a0 < q; a0++) {
			int left = in.nextInt();
			int right = in.nextInt();
			System.out.println(result(s.substring(left, right + 1)));
		}
		in.close();
	}

	private static long result(String s) {
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		for (int i = 0; i < s.length(); ++i) {
			for (int j = i + 1; j < s.length(); ++j) {
				String str = s.substring(i, j);
				for (int z = 0; z < list.size(); ++z) {
					String check = list.get(z);
					if (check.equals(str)) {
					} else
						list.add(str);
				}

			}
		}
		return list.size() - 1;
	}

}
