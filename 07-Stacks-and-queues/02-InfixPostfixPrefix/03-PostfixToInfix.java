import java.util.Stack; 

class PostfixToInfix{

    static String optimalApproach(String exp) {

        if (exp == null || exp.length() == 0) {
            return "";
        }
        Stack <String> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            }
            else {
                if (stack.size() < 2) {
                    return "";
                }

                String t1 = stack.pop();

                String t2 = stack.pop(); 

                String combined = "(" + t2 + c + t1 + ")";

                stack.push(combined);
            }
        }

        if (stack.isEmpty()) {
            return "";
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        // Test Case 1: Simple postfix expression
        String exp1 = "ab*c+";
        System.out.println("Input: " + exp1);
        System.out.println("Output: " + optimalApproach(exp1)); 
        // Expected: ((a*b)+c)

        // Test Case 2: Expression with multiple operators
        String exp2 = "pq+mn-*";
        System.out.println("\nInput: " + exp2);
        System.out.println("Output: " + optimalApproach(exp2)); 
        // Expected: ((p+q)*(m-n))

        // Test Case 3: Edge Case (Empty String)
        String exp3 = "";
        System.out.println("\nInput: Empty String");
        System.out.println("Output: " + optimalApproach(exp3)); 
        // Expected: (empty)
    }
}


/**
 * TC: O(N) where N is the length of the string
 * SC: O(N) for the stack storing intermediate strings
 */