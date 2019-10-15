import java.util.Scanner;
public class Reverse
{
    public static void main(String args[])
    {
        int i,num,k=0;
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter any number:");
        num = kb.nextInt();
        while(num > 0)
        {
            i = num % 10;
            k = k* 10 + i;
            num = num / 10;
        }
        System.out.print("reverse number:");
        System.out.println(k);
    }
}
