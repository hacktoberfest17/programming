package cc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class APATJanuary1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.next();
		String str2 = scan.next();
		String str3 = scan.next();

		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		HashMap<String, Integer> map3 = new HashMap<>();

		substring(str1, map1);
		substring(str2, map2);
		substring(str3, map3);
		int ans = Integer.MIN_VALUE;
		String x = "";

		ArrayList<String> list = new ArrayList<>(map1.keySet());

		for (String s : list) {
			if (map2.containsKey(s) && map3.containsKey(s)) {
				if (ans < s.length()) {
					ans = s.length();
					x = s;
				}
			}

		}
		System.out.println(ans);
		scan.close();

	}

	private static void substring(String str, HashMap<String, Integer> map1) {

		for (int i = 0; i < str.length(); ++i) {

			for (int j = i; j < str.length(); ++j) {
				map1.put(str.substring(i, j), j - i + 1);
			}
		}
	}

}
