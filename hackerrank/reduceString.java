package cc;

import java.util.Scanner;

public class reduceString {

	public static String reduce(String s) {
		if (s.length() == 1) {
			return s;
		}
		char ch = s.charAt(0);
		String rr = reduce(s.substring(1));
		String mr = "";
		if (rr.length() == 0)
			return rr + ch;
		char ch1 = rr.charAt(0);
		if (ch != ch1)
			mr = ch + rr;

		else if (ch == ch1)
			mr = rr.substring(1);
		return mr;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str=scan.nextLine();
		System.out.println(reduce(str));
		scan.close();

	}

}
