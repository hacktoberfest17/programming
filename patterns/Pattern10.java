import java.util.*;

class Pattern10{

	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);

		int n;
		System.out.print("Enter a range: ");
		n= sc.nextInt();
		
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n-i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}