/**
 * @author Beven Lee
 */
public class RuleOfThree {

    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("Usage: java RuleOfThree <a> <b> <c>");
            System.exit(-1);
        }

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        int x = (b * c) / a;
        System.out.println("x = " + x);
    }
}
