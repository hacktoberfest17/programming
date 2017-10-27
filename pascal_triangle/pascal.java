import java.util.Scanner;
/**
 * Pascal Triangle
 *
 */
class PascalTriangle{
	public static void main(String arg[]){
		printSumOfAllNumbersInTheRow();
	}
	/*
	 * This method takes user inputs and calculates sum of all numbers in that row.
	 * For ease of the user, row number starts with 1.
	 */
	private static void printSumOfAllNumbersInTheRow(){
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the row number of the Pascal Tringle");
		int rowNumber = in.nextInt();
		in.close();
		int SumOfAllNumbersInTheRow=(int)java.lang.Math.pow(2, rowNumber-1);
		System.out.println("Sum of all numbers in  the row number: "+ rowNumber +" of the Pascal Tringle is = "+ SumOfAllNumbersInTheRow);
	}
}
