package cc;

import java.util.Scanner;

public class WeightedUniformString {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
       int[] arr=new int[27];
       for(int i=0;i<s.length();++i){
    	   arr[s.charAt(i)-'a'+1]++;
       }
       while(n>0){
    	   int num=in.nextInt(),k=1;
    	   for( k=1;k<=num;++k){
    		   if(num%k==0){
    			   if(arr[k]>=num/k)
    			   {
    				   System.out.println("YES");
    				   break;
    			   }
    		   }
    	   }
    	   if(k>num)
    		   System.out.println("NO");
    	   --n;
       }
       
    in.close();
	}
}
