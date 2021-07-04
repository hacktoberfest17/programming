package cc;

import java.util.Scanner;

public class stringsort {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String[] s;
		s = new String[n + 1];
		
		for (int k = 0; k < n + 1; k++)
			s[k] = scan.nextLine();

		scan.close();
		for (int k = 1; k < n + 1; k++)
			sort(s[k]);

	}

	public static void sort(String arr) {
		int count = 1;
		char temp = ' ';
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length(); ++i)
			sb.append(arr.charAt(i));

		while (count < arr.length()) {
			for (int i = 0; i < arr.length() - count; ++i) {
				if (sb.charAt(i) > sb.charAt(i + 1)) {
					temp = sb.charAt(i);
					sb.setCharAt(i, sb.charAt(i + 1));
					sb.setCharAt(i + 1, temp);
				}

			}
			++count;
		}
		System.out.println(sb);
	}
}
