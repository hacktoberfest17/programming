import java.io.*;
class EDITDISTANCE
{
	public static void main(String args[])throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter ob=new PrintWriter(System.out);
		// Enter the number of TestCases
		int t=Integer.parseInt(in.readLine());
		while(t-->0)
		{
			// Enter the first string
			char x[]=in.readLine().toCharArray();
			// Enter the second string
			char y[]=in.readLine().toCharArray();
			int m=x.length;
			int n=y.length,i,j;
			int dp[][]=new int[m+1][n+1];
			for(i=0;i<=m;i++)
			dp[i][0]=i;
			for(j=0;j<=n;j++)
			dp[0][j]=j;
			for(i=1;i<=m;i++)
			{
				for(j=1;j<=n;j++)
				{
					if(x[i-1]==y[j-1])
					dp[i][j]=dp[i-1][j-1];
					else
					dp[i][j]=1+mini(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]);
				}
			}
			ob.println(dp[m][n]);
		}
		ob.flush();
	}
	public static int mini(int a,int b,int c)
		{
			if(a<=b && a<=c)
			return a;
			else if(b<=a && b<=c)
			return b;
			else
			return c;
		}
	} 