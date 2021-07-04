package cc;

import java.util.Scanner;

public class kangroo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int v1 = in.nextInt();
		int x2 = in.nextInt();
		int v2 = in.nextInt();
		String result = kangaroo(x1, v1, x2, v2);
		System.out.println(result);
		in.close();
		

	}

	private static String kangaroo(int x1, int v1, int x2, int v2) {
		
		if(x1>x2 &&v1>v2)
			return "NO";
		if(x1<x2 &&v1<v2)
			return "NO";
		long x =x1-x2;
		long v=v2-v1;
        if(v==0&&x!=0)
            	return "NO";
			if(x%v!=0)
			return "NO";
		return "YES";
	}

}
