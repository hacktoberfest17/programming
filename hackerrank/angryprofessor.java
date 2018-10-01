package cc;

import java.util.Scanner;

public class angryprofessor {

    public static void main(String[] args) {
        		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t > 0) {
            int n=0;
			int s = in.nextInt();
            int k = in.nextInt();
            for (int i = 0; i < s; ++i) {
				int val= in.nextInt();
                if(val<=0)
                    ++n;
			}
            if(n<k)
                System.out.println("YES");
            else if(n>=k)
                System.out.println("NO");
			--t;
		}
		in.close();
    }
}
