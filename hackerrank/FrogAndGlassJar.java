package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class FrogAndGlassJar {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BigInteger a = scan.nextBigInteger();
		BigInteger b = scan.nextBigInteger();

		BigInteger ans = BigInteger.valueOf(0);

		BigInteger n = a.divide(b);
		ans = n.multiply((a.add(b)));
		ans = ans.subtract(a);
		ans = ans.mod(BigInteger.valueOf(1000000007));
		System.out.println(ans);
		scan.close();
	}

}
