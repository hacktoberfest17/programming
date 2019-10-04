import java.util.*;

class Pattern8{

	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);

		int n;
		System.out.print("Enter a range: ");
		n= sc.nextInt();
		for(int i=0; i<=n; i++)
		{
			for(int j=n; j>i; j--)
			{
				System.out.print("*");
			}
			for(int k=1; k<=2*i; k++)
			{
				System.out.print(" ");
			}
			for(int l=n; l>i; l--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1; i<=n; i++)
		{
			for(int x=1; x<=i; x++)
			{
				System.out.print("*");
			}
			for(int y=2*n; y>2*i; y--)
			{
				System.out.print(" ");
			}
			for(int z=1; z<=i; z++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}