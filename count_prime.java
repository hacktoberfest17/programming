import java.util.*;
class count_prime
{

boolean prime(int a)
{
if(a==1 || a==0)
	return false;

for(int i=2; i<=Math.sqrt(a); i++)
{	
	
	if(a%i==0)
		return false;
}
return true;
}

int count(int a, int b)
{
int c = 0;
for(int i=a; i<=b; i++)
{
	if(prime(i))
		c++;
}
return c;
}

public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
count_prime ob=new count_prime();

System.out.println("Enter the lower number");
int a=sc.nextInt();

System.out.println("Enter the higher number");
int b=sc.nextInt();

System.out.println("Number of prime numbers :: "+ob.count(a,b));
}
}
