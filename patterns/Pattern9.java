import java.util.*;

class Pattern9{

	public static void main(String args[]){

		Scanner sc= new Scanner(System.in);

		int n;
		System.out.print("Enter a Range: ");
		n=sc.nextInt();
		
		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=n-i; j++)
			{
				System.out.print("*");
			}
			for(int k=1; k<=2*i; k++)
			{
				System.out.print(" ");
			}
			for(int l=0; l<=n-i; l++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=i; j++)
			{
				System.out.println("*");
			}
			for(int k=2*(n-i); k>0; k--)
			{
				System.out.print(" ");
			}
			for(int l=0; l<=i; l++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}