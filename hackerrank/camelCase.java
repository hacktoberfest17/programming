package cc;

import java.util.Scanner;

public class camelCase {

	public static int cc(String s) {
		if (s.length() == 1) {
			return 1;
		}
		char ch = s.charAt(0);
		int count = cc(s.substring(1));
		if (ch >= 65 && ch <= 90)
			++count;
		return count;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		System.out.println(cc(str));
		scan.close();
	}

}
