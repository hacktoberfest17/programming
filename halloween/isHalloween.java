import java.util.Date;

class isHalloween {
    public static void main(final String aghgs[]) {
        final Date d = new Date();
        if (d.getMonth() == 10 && d.getDate() == 31) {
            System.out.println("Happy Halloween");
        }
    }
}
