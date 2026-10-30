public class FactorialofN {

    // Recursive Approach
    public static long factorialRecursive(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorialRecursive(n - 1);
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    // Iterative Approach
    public static long factorialIterative(int n) {
        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Using Recursion: " + factorialRecursive(n));
        System.out.println("Using Loop: " + factorialIterative(n));
    }
}
