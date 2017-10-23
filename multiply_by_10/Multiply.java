public class Multiply {
    public static long by10(long number) {
        long result = 0;
        result += number << 3;
        result += number << 1;
        return result;
    }

    public static long byAlmost1(long number) {
        return number << 1 >> 2 << 3 >> 1 << 2 >> 3;
    }
}
