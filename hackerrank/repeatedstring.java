package cc;

import java.util.Scanner;

public class repeatedstring {
	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String s = in.next();
	        long n = in.nextLong();
	        int count=0;
	        for(int i=0;i<s.length();++i){
	            if(s.charAt(i)=='a')
	                ++count;
	        }
	        long rem=n%s.length();
	        long ans=(n-rem)/s.length();
	        ans*=count;
	        for(int i=0;i<rem;++i){
	           if(s.charAt(i)=='a')
	                ++ans; 
	        }
	   System.out.println(ans);
	    }
}
