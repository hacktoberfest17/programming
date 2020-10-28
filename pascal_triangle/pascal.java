import java.io.*;
import java.util.Scanner;
class pascal{
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);
		System.out.println("Enter no of rows n");
		int n=in.nextInt();
		int[][] a=new int[n][n];
		for(int i=0;i<n;i++){
			a[i][i]=1;
			a[i][0]=1;
		}
			
		
		for(int i=2;i<n;i++)
		{for(int j=1;j<i;j++)
			{
				a[i][j]=a[i-1][j]+a[i-1][j-1];
			}
		}
		for(int i=0;i<n;i++)
			System.out.println(a[n][i]);
	}
}