import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class isHalloween {
	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar(Locale.KOREA);
	    int nMonth = calendar.get(Calendar.MONTH) + 1;
	    int nDay = calendar.get(Calendar.DAY_OF_MONTH);
	    
	    if (nMonth == 10 && nDay == 31) {
	    	System.out.println("Happy Halloween!");
	    } else if (nMonth == 10) {
	    	System.out.println("It's October, but today is not Halloween!");
	    } else {
	    	System.out.println("It's not October");
	    }
	}
}
