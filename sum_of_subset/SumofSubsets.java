import java.io.*;
import java.util.Scanner;
class SumofSubsets
{
	static int c=0;
	public static void main(String args[])
	{
		int w[]=new int[10], x[]=new int[10], n, d, i, sum=0;
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		n=in.nextInt();
		System.out.println("Enter the elements in increasing order");
		for(i=0;i<n;i++)
		w[i]=in.nextInt();
		System.out.println("Enter the Positive Sum: ");
		d=in.nextInt();
		for(i=0;i<n;i++)
		sum=sum+w[i];
		System.out.println("SUM ="+sum);
		if(sum < d || w[0] > d)
		{
			System.out.println("Subset is not possible ! ");
			System.exit(0);
		}
		subset(0,0,sum,x,w,d);
		if(c==0)
			System.out.println("Subset is not possible ! ");
	}
	static void subset(int cs, int k, int r,int x[],int w[],int d)
	{
		x[k] = 1;
		if(cs+w[k] == d)
		{
			c++;
			System.out.print("\nSolution "+c+" is { ");
			for(int i=0;i<=k;i++)
			{
				if(x[i] == 1)
				{
					System.out.print(w[i]+" ");
				}
			}
			System.out.print(" }");
		}
		
		else if((cs + w[k] + w[k+1]) <= d)
			subset(cs + w[k], k+1, r-w[k],x,w,d);
		if((cs + r - w[k]) >= d && (cs + w[k+1]) <= d)
		{
			x[k] = 0;
			subset(cs, k+1, r-w[k],x,w,d);
		}
	}
}