import java.time.LocalDate;

/**
 * Java implementation of the "is it halloween" problem
 */
public class isHalloween {

    public static void main(String args[]) {
        if (LocalDate.now().getMonthValue() == 10) {
            if (LocalDate.now().getDayOfMonth() == 31) {
                System.out.println("Happy Halloween!");
            } else {
                System.out.println("It's October, but today is not Halloween!");
            }
        } else {
            System.out.println("It's not October");
        }
    }
}