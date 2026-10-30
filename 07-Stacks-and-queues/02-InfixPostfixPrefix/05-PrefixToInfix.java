import java.util.Stack; 

class PrefixToInfix {

    static String optimalApproach(String exp) {
        if (exp == null || exp.length() == 0) {
            return "";
        }
        
        Stack <String> stack = new Stack<>();

        for (int i = exp.length() -1; i >= 0; i--){
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            }
            else {
                if (stack.size() < 2){
                    return "";
                }

                String t1 = stack.pop(); 
                String t2 = stack.pop(); 
                String combined = "(" + t1 + c + t2 + ")";
                stack.push(combined);
            }
        }

        if (stack.isEmpty()) {
            return "";
        }
        return stack.pop();
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    public static void main(String[] args) {
        String exp1 = "*+abc";
        System.out.println("Input: " + exp1);
        System.out.println("Output: " + optimalApproach(exp1)); 

        String exp2 = "*+pq-mn";
        System.out.println("\nInput: " + exp2);
        System.out.println("Output: " + optimalApproach(exp2)); 

        String exp3 = "";
        System.out.println("\nInput: Empty String");
        System.out.println("Output: " + optimalApproach(exp3)); 
    }
}
