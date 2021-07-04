package cc;

import java.util.Scanner;

public class stringsort2d {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String[] s;
		String temp;
		s = new String[n + 1];

		for (int k = 0; k < n + 1; k++)
			s[k] = scan.nextLine();

		scan.close();
		int count = 1, j = 0, k = 0;
		while (count < n + 1) {
			for (int i = 1; i < n + 1 - count; ++i) {
				if (s[i].charAt(0) > s[i + 1].charAt(0)) {
					temp = s[i];
					s[i] = s[i + 1];
					s[i + 1] = temp;
				}

				

			}
			++count;
		}
		for(int i=1;i<n;++i)
		{
			if (s[i].charAt(0) == s[i + 1].charAt(0)) {
				int size1 = s[i].length(), size2 = s[i + 1].length();
				j = 0;
				k = 0;
				if (size1 < size2) {
					if (s[i + 1].substring(0, size1) .equals(s[i])) {
						temp = s[i];
						s[i] = s[i + 1];
						s[i + 1] = temp;
						
					}

				} else {
					while (j < size1 && k < size2) {
						if (s[i].charAt(k) > s[i + 1].charAt(k)) {
							temp = s[i];
							s[i] = s[i + 1];
							s[i + 1] = temp;
							
							break;
						}

						++j;
						++k;
					}
				}
			}
		}

		for (int i = 1; i < n + 1; ++i) {
			System.out.println(s[i]);
		}
	}

}
