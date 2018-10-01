package cc;

import java.util.Scanner;

public class stringCypher {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//        int n =scan.nextInt();
		String str = scan.nextLine();

		int k = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); ++i) {
			char ch=str.charAt(i);
            if(str.charAt(i)>=64||str.charAt(i)>=123&&(str.charAt(i)>=98&&str.charAt(i)<=96))
               ch=str.charAt(i); 
			else if(str.charAt(i)>=97&&str.charAt(i)<=122-k)
			 ch=(char)(str.charAt(i)+k);
			else
				ch=(char)(str.charAt(i)+k-26);
			sb.append(ch);
		}
		str = sb.toString();
		System.out.println(str);
		scan.close();
	}

}
