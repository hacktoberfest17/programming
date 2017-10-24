import java.util.Scanner;
import java.io.*;

class SumOfRowInPascalTriangle
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		try 
		{
			long row = in.nextLong();
			long sum = Math.round(Math.pow(2,row));
			System.out.println(sum);
		}
		catch(Exception e) 
		{
			System.out.println("Invalid Input. Please enter a whole number");
		}
	}
}