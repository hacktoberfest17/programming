import java.util.Scanner;

public class Count_Age{

    public static void main(String[] args){
       
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your birth year(YYYY) :");
        int birth_year = in.nextInt();
        System.out.println("Please enter your birth month(MM) :");
        int birth_month = in.nextInt();
        System.out.println("Please enter current year(YYYY) :");
        int current_year = in.nextInt();
        System.out.println("Please enter current month(MM) :");
        int current_month = in.nextInt();


        int year = current_year - birth_year;
        int month = current_month - birth_month;
        if(month<0){
            year--;
            month+=12;
        }

        System.out.println("Your age is " + year + " years and " + month + " months.");

    }
}