import java.util.Date;

class TomorrowDate {
    public static Date get() throws InterruptedException {
        waitUntilTomorrow();
        return todayDate();
    }

    private static void waitUntilTomorrow() throws InterruptedException {
        Thread.sleep(1000 * 60 * 24); // 1 day
    }

    private static Date todayDate() {
        return new Date();
    }
}
