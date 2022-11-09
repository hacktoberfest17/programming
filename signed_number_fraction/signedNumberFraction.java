import java.io.*;
import java.util.Scanner;

public class signedNumberFraction {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        double count0=0;
        double countp=0;
        double countn=0;
        boolean temp;
        for(int i = 0; i<n; i++) {
            arr[i]=in.nextInt();
            temp=arr[i]>0?(countp++)==1:arr[i]==0?(count0++)==1:(countn++)==1;
        }
        
        double ans0 = count0/n;
        double ansp = countp/n;
        double ansn = countn/n;
        System.out.println(ansp);
        System.out.println(ansn);
        System.out.println(ans0);
    }
}