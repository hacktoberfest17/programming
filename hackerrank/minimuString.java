package cc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class minimuString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String g = scan.nextLine();
		String s = scan.nextLine();

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); ++i) {

			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}

		ArrayList<Character> list = new ArrayList<>(map.keySet());

		int max = 0;
		for (Character ch : list) {
			if (map.get(ch) > max) {
				max = map.get(ch);
			}
		}

		System.out.println(s.length() - max);
//		System.out.println(s);

	}

}
