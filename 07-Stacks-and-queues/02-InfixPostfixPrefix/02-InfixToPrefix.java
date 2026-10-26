import java.util.Stack;

/***
 * * TC: O(N) where N is the length of the string
 * SC: O(N) for the stack and the string builders
 */
 
 
class InfixToPrefix {

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

        // Step 1: Reverse the string and swap brackets
        StringBuilder reversedExp = new StringBuilder();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (c == '(') {
                reversedExp.append(')');
            } else if (c == ')') {
                reversedExp.append('(');
            } else {
                reversedExp.append(c);
            }
        }

        // Step 2: Modified Infix to Postfix
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < reversedExp.length(); i++) {
            char c = reversedExp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); 
                }
            } else {
                // Fixed spelling: priority(c)
                while (!stack.isEmpty() && priority(c) < priority(stack.peek())) {
                    result.append(stack.pop());
                }
                while (!stack.isEmpty() && priority(c) == priority(stack.peek()) && c == '^') {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        } // The for loop ends here

        // The method is still open, so this while loop is safely inside it
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    } // The optimalApproach method ends here

    public static void main(String[] args) {
        String exp1 = "x+y*z/w+u";
        System.out.println("Input: " + exp1);
        System.out.println("Output: " + optimalApproach(exp1)); 
    }
} // The class ends here