public class HindiToHex {
    private  static char hexDigit[] = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    public static void main(String[] args) {
        String original = "क";
        System.out.println(String.format("Original = %s", original));
        StringBuilder hex = new StringBuilder();
        for (char c : original.toCharArray()) {
            hex.append(charToHex(c));
        }
        System.out.println(String.format("hex = %s", hex.toString()));
    }

    public static String byteToHex(byte b) {

        char[] array = { hexDigit[(b >> 4) & 0x0f], hexDigit[b & 0x0f] };
        return new String(array);
    }

    public static String charToHex(char c) {
        byte hi = (byte) (c >>> 8);
        byte lo = (byte) (c & 0xff);
        return byteToHex(hi) + byteToHex(lo);
    }
}
