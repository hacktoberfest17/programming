import java.util.Scanner;

/**
 * Java implementation of finding whether a given number is an Adam's number
 */
public class Adam {

    //steps to find an adam's number
    //obtain number
    //square that number
    //reverse the number
    //square root the number
    //reverse that number

    public static void main(String args[]) {
        int originalNumber = getUserNumber();
        int changedNumber = squareNumber(originalNumber);
        changedNumber = reverseNumber(changedNumber);
        changedNumber = squareRootNumber(changedNumber);
        changedNumber = reverseNumber(changedNumber);

        if (originalNumber == changedNumber) {
            System.out.println(originalNumber + " is an Adam's number");
        } else {
            System.out.println(originalNumber + " is not an Adam's number");
        }
    }

    /**
     * Method which obtains a user entered number
     * @return number the user types in
     */
    public static int getUserNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }

    /**
     * Method which finds the square of a number
     * @param number - the number to square
     * @return the squared number
     */
    public static int squareNumber(int number) {
        return number*number;
    }

    /**
     * Method which reverse a number
     * @param number - the number to be reversed
     * @return the reversed number
     */
    public static int reverseNumber(int number) {
        int reversedNumber = 0;
        for (int i = number; i !=0; i /= 10) {
            reversedNumber = reversedNumber * 10+ i % 10;
        }

        return reversedNumber;
    }

    /**
     * Method which finds the square root of a number
     * @param number - the number to be square-rooted
     * @return the square roof of the number
     */
    public static int squareRootNumber(int number) {
        return (int) Math.sqrt(number);
    }
}
