import java.util.Scanner;

public class InverseOfNumber {

	
	public static void main(String[] args) {
		 
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the  number : ");
		int number = input.nextInt();
		
		System.out.println(inverse(number));

	}

	
	public static int inverse(int num){
		int i = 1,sum = 0;
		while(num > 0){
			int rem = num % 10;
			sum = sum + i*(int)Math.pow(10, rem);
			num /= 10;
			i++;
		}
		
		
		
		return sum/10;
	}
}
