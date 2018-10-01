package cc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CodeArenaDecimal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(12.5%12);
		int t = scan.nextInt();
		while (t > 0) {
			int num;
			int n1 = scan.nextInt();
			int d1 = scan.nextInt();
			int r1 = scan.nextInt();

			num = (n1 / d1);

			BigDecimal n = new BigDecimal(n1 + ".0");
			BigDecimal d = new BigDecimal(d1 + ".0");
			BigDecimal ans = n.divide(d, 100000, RoundingMode.HALF_UP);

			ans = ans.subtract(BigDecimal.valueOf(num));

			String str = ans.toString();

			if (r1 + 1 >= str.length()) {
				System.out.println("0");
			} else {
				System.out.println(str.charAt(r1 + 1));
			}

			--t;
		}
		scan.close();
	}

}
