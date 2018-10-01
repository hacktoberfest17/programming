package cc;

import java.util.Scanner;

public class twin {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String data = scan.next();

		System.out.println(count(data));
	}

	private static int count(String data) {
		if (data.length() <= 2) {
			return 0;
		}
		int count = 0;
		count = count(data.substring(1));
		if (data.charAt(0) == data.charAt(2)) {
			++count;
		}

		return count;
	}

}
