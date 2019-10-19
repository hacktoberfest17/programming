package application;
import junit.framework.TestCase;
public class LeapYearTest extends TestCase {

    public void testCase1() {
        assertTrue(LeapYear.isLeapYear(2000));
    }
    public void testCase2() {
        assertTrue(LeapYear.isLeapYear(2020));
    }
    public void testCase3() {
        assertTrue(LeapYear.isLeapYear(1996));
    }
    public void testCase4() {
        assertFalse(LeapYear.isLeapYear(1997));
    }
    public void testCase5() {
        assertFalse(LeapYear.isLeapYear(1900));
    }
    public void testCase6() {
        assertFalse(LeapYear.isLeapYear(1));
    }

}
