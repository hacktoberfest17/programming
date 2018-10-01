package cc;

import java.util.Scanner;

public class goodWord {

	public static void check(String str, char con) {
		if (str.length() == 0) {
			System.out.println("YES");
			return;
		}
		char ch = str.charAt(0);
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			check(str.substring(1), 'v');
		} else {
			if (con == 'v') {
				check(str.substring(1), 'c');
			} else {
				System.out.println("NO");
				return;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		check(str, '\0');
		scan.close();
	}

}
