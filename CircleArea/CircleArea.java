import java.util.Scanner;
public class CircleArea{
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER THE RADIUS OF CIRCLE");
		int r= sc.nextInt();
			double area=(Math.PI)*r*r;
		System.out.println("AREA OF CIRCLE WITH RADIUS "+r+"IS "+area);
				}
}