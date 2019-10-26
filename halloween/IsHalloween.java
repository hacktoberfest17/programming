import java.util.*;
import java.time.LocalDate;

public class IsHalloween{
  public static void halloween(){
    Calendar cal = Calendar.getInstance();
    int month = cal.get(Calendar.MONTH);
    int day = cal.get(Calendar.DAY_OF_MONTH);
    if((month+1) == 10 && day == 31) System.out.println("Today is Halloween");
    else System.out.println("Today is not Halloween");
  }

  public static void main(String [] args){
    halloween();
  }
}