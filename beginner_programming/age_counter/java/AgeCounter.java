import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeCounter{
  public static long age(int YY, int MM, int DD){
    LocalDate birthdate = LocalDate.of(YY, MM, DD);
    LocalDate now = LocalDate.now();
    long result = ChronoUnit.YEARS.between(birthdate, now);
    return result;
  }

  public static void main(String [] args){
    Scanner scan = new Scanner(System.in);
    System.out.print("Please input your birth year (Eg: 1995) ");
    int year = scan.nextInt();
    System.out.print("Please input your birth month (Eg: 12) ");
    int month = scan.nextInt();
    System.out.print("Please input your birth date (Eg: 7) ");
    int day = scan.nextInt();
    System.out.println("Your age is "+age(year, month, day));
  }
}