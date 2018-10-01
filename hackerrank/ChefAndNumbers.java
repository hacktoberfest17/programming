package cc;

import java.util.Scanner;

public class ChefAndNumbers {
	static Scanner scan = new Scanner(System.in);

	public static void disp() {

		String number = scan.nextLine();
		int[] arr = new int[10];
		for (int i = 0; i < number.length(); ++i) {
			arr[number.charAt(i) - 48]++;
		}
		int n;
		String s, temp;
		for (int i = 0; i < 10; ++i) {
			if (arr[i] == 0)
				continue;
			s = "" + i;
			--arr[i];
			for (int j = 0; j < 10; ++j) {
				temp = s;
				if (arr[j] == 0)
					continue;
				temp += j;
				n = Integer.parseInt(temp);
				if (n >= 65 && n <= 90) {
					System.out.print((char) n);
				}
			}
			++arr[i];
		}
System.out.println();

	}

	public static void main(String[] args) {
		int t = scan.nextInt();
		while (t > 0) {
			String number = scan.next();
			int[] arr = new int[10];
			for (int i = 0; i < number.length(); ++i) {
				arr[number.charAt(i) - 48]++;
			}
			int n;
			String s, temp;
			for (int i = 0; i < 10; ++i) {
				if (arr[i] == 0)
					continue;
				s = "" + i;
				--arr[i];
				for (int j = 0; j < 10; ++j) {
					temp = s;
					if (arr[j] == 0)
						continue;
					temp += j;
					n = Integer.parseInt(temp);
					if (n >= 65 && n <= 90) {
						System.out.print((char) n);
					}
				}
				++arr[i];
			}
	System.out.println();
			--t;
		}
	}

}
