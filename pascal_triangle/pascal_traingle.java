import java.util.Scanner;

public class PascalPattern {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter the value of N : ");
		int n = input.nextInt();
		
		int row = 0;
		
		while (row < n) {
			
			int counter = 1;
			
			int col = 0;
			
			while (col <= row) {
				
				System.out.print(counter + " ");
				
				col += 1;
				
				counter = (counter * (row - col + 1)) / col;

			}
			
			row += 1;
			
			System.out.println();
		}
	}

}

