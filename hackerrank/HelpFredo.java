package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class HelpFredo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BigInteger bin = new BigInteger("1");
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = scan.nextInt();
			bin = bin.multiply(BigInteger.valueOf(arr[i]));
		}

		double ans = (long) (1 + (Math.log10(bin.longValue()) / Math.log10(n)));
		System.out.println((int) (Math.ceil(ans)));

	}

}

// int i = 0;
// BigInteger ans = new BigInteger("1");
// while (bin.compareTo(ans) > 0) {
// ++i;
// ans = BigInteger.valueOf(i);
// ans = ans.pow(n);
//
// }
// System.out.println(i);