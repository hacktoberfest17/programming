import java.util.*;

class Pattern13{
	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);

		int length, height;
		String ch;
		
		System.out.print("Enter any character(Or special character) from keyboard to print the outline of rectangle: ");
		ch=sc.next();
		
		System.out.println("Enter Length: ");
		length = sc.nextInt();
		System.out.print("Enter Height: ");
		height=sc.nextInt();
		
		System.out.println();
		
		for(int i=1; i<=length; i++)
		{
			System.out.print(ch +" ");
		}
		System.out.print(ch);
		System.out.println();
		
		for(int j=1; j<=height; j++)
		{
			System.out.print(ch);
			for(int l=1; l<=((length*2)-1); l++)
			{
				System.out.print(" ");
			}
			System.out.print(ch);
			System.out.println();
		}
		
		for(int i=1; i<=length+1; i++)
		{
			System.out.print(ch + " ");
		}
		System.out.println();
	}
}