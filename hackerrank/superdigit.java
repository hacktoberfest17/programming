package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class superdigit {
	public static void s_sum(BigInteger num){
		if(num.compareTo(new BigInteger("10"))==-1){
			System.out.println(num);
			return;
		}
		
		BigInteger sum=new BigInteger("0");
		while(num.compareTo(new BigInteger("10"))==1){
		sum=sum.add(num.mod(new BigInteger("10")));
		num=num.divide(new BigInteger("10"));
		}
		s_sum(sum);
}
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
String s=scan.next();
int n=scan.nextInt();
while(n>0){
	s+=s;
	--n;
}
BigInteger num=new BigInteger(s);
s_sum(num);
		
		scan.close();
		
	}
	
}