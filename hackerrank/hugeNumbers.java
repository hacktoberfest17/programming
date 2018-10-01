package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class hugeNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t > 0) {
			int a = scan.nextInt();
			int n = scan.nextInt();
			int p = scan.nextInt();
			--t;

			if(n>=p) {
				System.out.println(a%p);
				continue;
			}
			BigInteger N = BigInteger.valueOf(n);
			for(int i=n;i>1;--i) {
				N=N.multiply(BigInteger.valueOf(i%p));
			}
			N=N.mod(BigInteger.valueOf(p));
			

			
			
			a = a % p;
			BigInteger mul = BigInteger.valueOf(a);
			BigInteger ans = mul;

			for (BigInteger i = BigInteger.valueOf(1); i.compareTo(N)>0; i=i.subtract(BigInteger.valueOf(1))) {
				ans = ans.multiply(mul);
			}

			ans = ans.mod(BigInteger.valueOf(p));

			System.out.println(p);

		}

	}

}
