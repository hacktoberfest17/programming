package cc;

import java.util.Scanner;

public class sum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			int count = 0;
			int n = scan.nextInt();
			int A = scan.nextInt();
			int B = scan.nextInt();
			int C = scan.nextInt();

//			for (int a = 0; a <= A && a <= n; ++a) {
//				for (int b = 0; b <= B && a + b <= n; ++b) {
//					for (int c = 0; c <= C && a + b + c <= n; ++c) {
//						++count;
//					}
//				}
//			}
			
			for (int a = A; a >=0; --a) {
				for (int b = B; b >=0 ; --b) {
					for (int c = C; c>=0 && a + b + c > n; --c) {
						++count;
					}
				}
			}
			count=(A+1)*(B+1)*(C+1)-count;
			System.out.println(count);
			--t;
		}

		scan.close();
	}

}
