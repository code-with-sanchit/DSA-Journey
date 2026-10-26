import java.util.Stack; 

/**
 * Time Complexity: 0(N)
 * Space Complexity: 0(N)
 */

class InfinixToPostfix {

    static int priority(char ch) {
        if (ch == '^') {
            return 3;  // Highest Priority
        } else if (ch == '*' || ch == '/') {
            return 2; 
        } else if (ch == '+' || ch == '-') {
            return 1;  // Lowest Priority
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
                stack.push(c); // Push the current operator
            }
        }

        // Pop any remaining operators in the stack 
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String exp1 = "a+b*c";
        System.out.println("Input:" + exp1);
        System.out.println("Output:" + optimalApproach(exp1));
        //Expected: abc*+

        String exp2 = "(p+q)*(m-n)";
        System.out.println("\nInput: " + exp2);
        System.out.println("Output: " + optimalApproach(exp2)); 
        // Expected: pq+mn-*

        String exp3 = "";
        System.out.println("\nInput: Empty String");
        System.out.println("Output: " + optimalApproach(exp3)); 
        // Expected: (empty)
    }
}