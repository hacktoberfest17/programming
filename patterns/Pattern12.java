import java.util.*;

class Pattern12{
	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);

		int n;
		System.out.print("Enter a range: ");
		n=sc.nextInt();		
		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=n; j++)
			{
				System.out.print(" ");
			}
			for(int k=1; k<=i-i; k++)
			{
				System.out.print("*");
			}
			for(int l=0; l<=i; l++)
			{
				System.out.print("*");
			}
			for(int m=0; m<=n-i; m++)
			{
				System.out.print(" ");
			}
			System.out.println();
		}
		for(int i=0; i<=n; i++)
		{
			for(int y=0; y<=n; y++)
			{
				System.out.print(" ");
			}
			for(int z=0; z<=i-i; z++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=n-i; j++)
			{
				System.out.print(" ");
			}
			for(int k=0; k<=2*i; k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0; i<=n; i++)
		{
			System.out.print(" ");
			for(int j=0; j<=2*n-2; j++)
			{
				System.out.print("*");
			}
			System.out.println();
			
		}
	}
}