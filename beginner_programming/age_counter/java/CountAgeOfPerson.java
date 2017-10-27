import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 * Java implementation of counting a person's age in days
 */
public class CountAgeOfPerson {

    /**
     * Main method
     */
    public static void main(String[] args) {

        //get user's birthday
        int[] birthdayArray = getUserBirthday();
        
        //convert birthday into LocalDate
        LocalDate birthday = LocalDate.of(birthdayArray[0], birthdayArray[1], birthdayArray[2]);

        //get today's date
        LocalDate today = LocalDate.now();
        
        //calculate period between today's date and the user's birthday
        Period p = Period.between(birthday, today);

        //print out the final message
        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() + " months and " + p.getDays() + " days old.");
    }

    /**
     * Method which obtains the users birthday as a string
     */
    public static int[] getUserBirthday() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your birth year: ");
        int year = sc.nextInt();
        System.out.print("Enter your birth month: ");
        int month = sc.nextInt();
        System.out.print("Enter your birth day: ");
        int day = sc.nextInt();
        sc.close();
        return new int[]{year, month, day};
    }
}