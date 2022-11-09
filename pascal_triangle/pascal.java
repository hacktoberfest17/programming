import java.io.*;
import java.util.Scanner;
class pascal{
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);
		System.out.println("Enter no of rows n");
		int n=in.nextInt();
		int temp=1;
		for(int i=0;i<n;i++)
		{
			System.out.println(temp);
			temp=temp*2;
		}
	}
}
