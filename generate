/*
 * This app requests user input to produce and search an array of random numbers.
 * 
 * @author Lee Gainer
 * @since Sept 2017
 */

package generate;

import java.util.Random;
import java.util.Scanner;

public class User {
	
	public static void main(String [] args) {
		
		// get number for random number array size from user
		Scanner getSize = new Scanner(System.in);
		System.out.println("Let's try to find a number in an array that contains up to 300 random numbers." + "\n"+ "Please enter a number between 0 and 100.");
		int n = getSize.nextInt();
		
		// check if n is less than 100		
		while (n > 100) {
			System.out.println("That number is larger than 100.");
			Scanner getSizeAgain = new Scanner(System.in);
			System.out.println("Please enter a number between 0 and 100.");
			n = getSizeAgain.nextInt();
			if (n <= 200) {
				continue;
			}
		}
		
		// get number to search for
		Scanner getNumber = new Scanner(System.in);
		System.out.println("The array contains numbers between 0 and " + n * 4 + ".\nWhat number should I search for: ");
		int x = getNumber.nextInt();
		
		// create array
		Random r = new Random();
		
		int [] haystack = new int[n];
		for (int m = 0; m < n; m++)
		{
			haystack[m] = r.nextInt(4 * n);
		}
		
		// is x in haystack?			
		for (int y = 0; y < n; y++) {
			
			if (haystack[y] == x) {
				System.out.println(x + " is in the array.");
				continue;
			}
			
			if (y == n - 1) {
				System.out.println(x + " is not in the array.");
				continue;				
			}
		}		
		
		// print array option for user
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like to see the numbers in the array (yes/no)?");
		String reply = in.nextLine();
		
		if (reply.equals("yes")) {
			for (int y = 0; y < n; y++) {
				System.out.println(haystack[y]);
			}
		}		
	}
}
