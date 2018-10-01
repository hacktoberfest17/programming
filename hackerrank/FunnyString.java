package cc;

import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
        in.close();
    }

	private static String funnyString(String s) {
		for(int i=1;i<=s.length()/2;++i){
			int diff1=0,diff2=0;
			diff1=s.charAt(i)-s.charAt(i-1);
			if(diff1<0)
				diff1*=-1;
			diff2=s.charAt(s.length()-i)-s.charAt(s.length()-1-i);
			if(diff2<0)
				diff2*=-1;
			if(diff1!=diff2){
				return "Not Funny";
			}
		}
		return "Funny";
	}

}
