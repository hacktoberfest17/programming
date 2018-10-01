package cc;

import java.util.ArrayList;
import java.util.Scanner;

public class CodeArenaStrings {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		// scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			String str = scan.nextLine();
			list.add(str);
		}

		int q = scan.nextInt();
		while (q > 0) {
			int count = 0;
			int start = scan.nextInt();
			// scan.next();
			int end = scan.nextInt();
//			 scan.next();
			
			String str = scan.next();

			for (int i = start - 1; i < end; ++i) {

				String temp = list.get(i);
				if (temp.equals(str))
					++count;
			}
			System.out.println(count);
			--q;
		}
	}

}
