import java.util.*;

class Pattern11{

	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);

		int n;
		System.out.print("Enter a range: ");
		n= sc.nextInt();
		
		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=n-i; j++)
			{
				System.out.print(" ");
			}
			for(int k=0; k<=i; k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0; i<=n; i++)
		{
			for(int k=0; k<=i; k++)
			{
				System.out.print(" ");
			}
			for(int j=0; j<=n-i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}