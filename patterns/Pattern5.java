import java.util.*;

class Pattern5{

	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);

		int n;
		System.out.println("Enter a Range: ");
		n=sc.nextInt();
	
		for(int i=1; i<=n; i++)
		{
			for(int j=n; j>=i; j--)
			{
				System.out.print("*");
			}
			for(int k=1; k<i*2; k++)
			{
				System.out.print(" ");
			}
			for(int l=n; l>=i; l--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}