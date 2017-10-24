import java.util.*;

class Pattern2{

	public static void main(String args[]){

		Scanner sc= new Scanner(System.in);
		int n;
		System.out.println("Enter a Range: ");
		n = sc.nextInt();

		for(int i=0; i<n; i++)
		{
			for(int j=n; j>i; j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}