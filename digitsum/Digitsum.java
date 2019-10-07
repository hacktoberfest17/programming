import java.util.Scanner;
/**
 * Created by ScholliYT on 10/16/2017.
 */
public class Digitsum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num =sc.nextInt();
		System.out.println(">>>" + digitsum(num));
	}
	public static int digitsum(int n) {
		if(n == 0) {
			return 0;
		}
		return n%10 + digitsum(n/10);
	}
}