import java.util.Scanner;
class twinprimes{
	boolean isPrime(int num){
		int count =0;
	for (int i=1;i<=num;i++)
	{
		if(num%i==0){
			count++;
		}
	}
	if(count==2){
		return true;
	}
	else 
		return false;
	}

	public static void main(String[] args) {
		twinprimes obj = new twinprimes();
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter first number");
		int fnum = sc.nextInt();
		System.out.println("Enter second number");
		int snum = sc.nextInt();
		for(int i = fnum;i<=snum;i++){
			if(obj.isPrime(i) == true && obj.isPrime(i+2)==true)
			{
				System.out.print(" ("+i+","+(i+2)+") ");
			}		
		}
	}
}
