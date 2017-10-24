import java.util.*;

class Pattern3{

	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);
		int n;
		System.out.println("Enter a Range: ");
		n = sc.nextInt();
		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=i; j++)
			{
				System.out.print(" ");
			}
			for(int k=n; k>i; k--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}