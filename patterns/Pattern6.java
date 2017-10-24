import java.util.*;

class Pattern6{

	public static void main(String args[]){
		int n;
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a range: ");
		n=sc.nextInt();
		for(int i=1; i<=n; i++)
		{
			for(int j=n; j>=i; j--)
			{
				System.out.print(" ");
			}
			for(int k=2; k<=2*i; k++)
			{
				System.out.print("*");
			}
			 System.out.println();
		}
	}
}