import java.util.Stack; 

class InfinixToPostfix {

    static int priority(char ch) {
        if (ch == '^') {
            return 3;
        } else if (ch == '*' || ch == '/') {
            return 2; 
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    static String optimalApproach(String exp) {
        if (exp == null || exp.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder(); 
        Stack <Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); 
                }
            }
            else {
                while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    public static void main(String[] args) {
        String exp1 = "a+b*c";
        System.out.println("Input:" + exp1);
        System.out.println("Output:" + optimalApproach(exp1));

        String exp2 = "(p+q)*(m-n)";
        System.out.println("\nInput: " + exp2);
        System.out.println("Output: " + optimalApproach(exp2)); 

        String exp3 = "";
        System.out.println("\nInput: Empty String");
        System.out.println("Output: " + optimalApproach(exp3)); 
    }
}
