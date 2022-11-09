import java.util.Scanner;
class KnapSack
{
	public static void main(String args[ ])
	{
		int v[][]=new int[10][10], w[]=new int[10], p[]=new int[10], i, j;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the total number of items: ");
		int n = in.nextInt();
		System.out.println("Enter the weight of each item: ");
		for(i=1;i<=n;i++)
			w[i] = in.nextInt();
		System.out.println("Enter the profit of each item: ");
		for(i=1;i<=n;i++)
			p[i] = in.nextInt();
		System.out.println("Enter the knapsack capacity: ");
		int m= in.nextInt();
		displayinfo(m,n,w,p);
		knapsack(m,n,w,p,v);
		System.out.println("The contents of the knapsack table are");
		for(i=0; i<=n; i++)
		{
			for(j=0; j<=m; j++)
			{
				System.out.print(v[i][j]+" " );
			}
			System.out.println();
		}
		optimal(m,n,w,v); //call optimal function
	}
	static void displayinfo(int m,int n,int w[],int p[])
	{
		System.out.println("Entered information about knapsack problem are");
		System.out.println("ITEM\tWEIGHT\tPROFIT");
		for(int i=1; i<=n; i++)
			System.out.println(i+"\t"+w[i]+"\t"+p[i]);
		System.out.println("Capacity = "+m);
	}
	static void knapsack(int m,int n,int w[],int p[],int v[][])
	{
		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=m; j++)
			{
				if(i==0 ||j==0)
					v[i][j]=0;
				else if(j < w[i])
					v[i][j]=v[i-1][j];
				else
					v[i][j]=max(v[i-1][j], v[i-1][j-w[i]]+p[i]);
			}
		}
	}
	private static int max(int i, int j)
	{
		if(i>j) 
			return i;
		return j;
	}
	static void optimal(int m,int n,int w[],int v[][])
	{
		int i = n, j = m, item=0, x[]=new int[10];
		while( i != 0 && j != 0)
		{
			if(v[i][j] != v[i-1][j])
			{
				x[i] = 1;
				j = j-w[i];
			}
			i = i-1;
		}
		System.out.println("Optimal solution is :"+ v[n][m]);
		System.out.println("Selected items are: ");
		for(i=1; i<= n;i++)
		if(x[i] == 1)
		{
			System.out.print(i+" ");
			item=1;
		}
		if(item == 0)
			System.out.println("NIL\t Sorry ! No item can be placed in Knapsack");
	}
}