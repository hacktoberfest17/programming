package cc;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class TwoStrings {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			--t;
			String s1= scan.next();
			String s2 = scan.nextLine();
			String shorts,longs ;
			if(s1.length()>=s2.length()) {
				shorts=s2;
				longs=s1;
			}else {
				shorts=s1;
				longs=s2;
			}
			
			HashMap<String, Boolean> map = new HashMap<>();
			for(int i=0;i<=shorts.length();++i) {
				for(int j=i;j<=shorts.length();++j) {
					map.put(shorts.substring(i, j), true);
				}
			}
			
			boolean flag = false;
			for(int i=0;i<=longs.length();++i) {
				for(int j=i;j<=longs.length();++j) {
					if(map.containsKey(longs.substring(i, j))) {
						flag = true;
						break;
					}
				}
			}
			
			if(flag) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}

		}

		scan.close();
	}

}
