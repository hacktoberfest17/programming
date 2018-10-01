package cc;

import java.util.Scanner;

public class marsExploration {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int count=0;
        for(int i=1;i<=S.length();++i){
            if(i%3==0||i%3==1){
                if(S.charAt(i-1)!='S')
                    ++count;
            }
            else if(i%3==2){
                 if(S.charAt(i-1)!='O')
                    ++count;
            }
        }
        System.out.println(count);
    in.close();
    }
}
