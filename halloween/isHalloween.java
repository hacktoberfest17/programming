import java.text.SimpleDateFormat;
import java.util.Date;

public class isHalloween {
  public static void main(String[] args) {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    
    if ( (date.getDay() == 31) && (date.getMonth() ){
      System.out.println("It's halloween!!")
    }else{
      System.out.println("It's not halloween :( ")
    }
  }
}
