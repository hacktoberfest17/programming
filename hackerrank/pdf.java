package cc;

import java.util.Scanner;

public class pdf {
	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int[] h = new int[26];
	        for(int h_i=0; h_i < 26; h_i++){
	            h[h_i] = in.nextInt();
	        }
	        int max=0;
	        String word = in.next();
	        for(int i=0;i<word.length();++i){
	            if(max<h[word.charAt(i)-'a'])
	                max=h[word.charAt(i)-'a'];
	        }
	        System.out.println(max*word.length());
	        in.close();
	    }
}
