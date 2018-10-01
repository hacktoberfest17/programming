package cc;


import java.util.HashMap;
import java.util.Scanner;

class DistinctSubarray
{

   public static void main(String args[])
   
   {
       Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
       int[] arr = new int[t];
       HashMap<String, Boolean> map = new HashMap<>();
       System.out.println(arr.toString());
       for(int i=0;i<arr.length;++i) {
    	   for(int j=i;j<=arr.length;++j) {
    		   String str= arr.toString().substring(i,j);
    		   map.put(str, true);
    		   
    	   }
       }
       
       System.out.println(map.size());
   }
}