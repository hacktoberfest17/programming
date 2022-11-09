public class BitGetSet {

    public static int getBit(final int number, final int index) {
        if (index < 0 || index > 31) {
            throw new IllegalArgumentException("index must be between 0 and 31");
        }
        return number >> index & 1;
    }

    public static int setBit(final int number, final int index, boolean high) {
        if (index < 0 || index > 31) {
            throw new IllegalArgumentException("index must be between 0 and 31");
        }
        int k = (high ? 0 : 1) == ((number >> index) & 1) ? 1 : 0;
        return (k << index) ^ number;
    }
}
