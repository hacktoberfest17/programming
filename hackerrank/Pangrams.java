package cc;

import java.util.Scanner;

public class Pangrams {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		in.close();
		int[] arr = new int[26];
		char ch;
		for (int i = 0; i < s.length(); ++i) {
			ch=s.charAt(i);
			if (ch == ' ')
				continue;
			if(ch>91)
			arr[ch - 'a']++;
			else
				arr[ch - 'A']++;

		}
		for (int i = 0; i < 26; ++i) {
			if (arr[i] == 0) {
				System.out.println("not pangram");
				return;
			}

		}
		System.out.println("pangram");
	}

}
