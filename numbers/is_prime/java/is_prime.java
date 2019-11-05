import java.util.Scanner;

public class Hacktoberfest {

  public static void main(String[] args) {      
  int i,num,m=0,flag=0;    
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter the number to be checked");
  num = sc.nextInt();
  for(i=2;i<=num/2;i++)
  {    
    if(num%i==0)
    {    
        System.out.println("Number is not prime");    
        flag=1;    
        break;    
    }    
  }    
  
  if(flag==0)    
    System.out.println("Number is prime");    
  }  
}
