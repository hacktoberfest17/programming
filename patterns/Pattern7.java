import java.util.*;

class Pattern7{

	public static void main(String args[]){

	Scanner sc= new Scanner(System.in);

	int n;
	System.out.print("Enter a range: ");
	n=sc.nextInt();
	
		for(int i=1; i<n; i++)
		{
			for(int j=n; j>i; j--)
			{
				System.out.print(" ");
			}
			for(int k=1; k<2*i; k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(int x=1; x<n; x++)
		{
			for(int y=1; y<=x; y++)
			{
				System.out.print(" ");
			}
			for(int z=2*n-1; z>2*x; z--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	
	}


}