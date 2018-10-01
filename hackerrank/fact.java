package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class fact {
	   public static void main(String[] args) {
		     
	        Scanner scan= new Scanner(System.in);
		    int n=scan.nextInt();
		    BigInteger ans=new BigInteger("1");
for(int i=1;i<=n;++i){
	ans=ans.multiply(new BigInteger(i+""));
}
      
	        System.out.println(ans);
	    }
}
