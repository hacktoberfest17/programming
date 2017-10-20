import java.util.Stack;

public class brackets {

    public static void main(String[] args) {
        System.out.println(solve("[{()}[]({[]})]")); // yes
        System.out.println(solve("()()")); // yes
        System.out.println(solve("((()[]")); // no
    }

    public static String solve(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.empty()) return "no";
                char p = stack.pop();
                if (c == ')') {
                    if (p != '(') return "no";
                    else continue;
                }
                if (c == ']') {
                    if (p != '[') return "no";
                    else continue;
                }
                if (c == '}') {
                    if (p != '{') return "no";
                }
            }
        }
        return stack.empty() ? "yes" : "no";
    }

}
