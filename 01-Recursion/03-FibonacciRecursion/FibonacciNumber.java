public class FibonacciNumber {

    // Recursive Approach
    public static int fibRecursive(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }
    /*
     * Time Complexity: O(2^N)
     * Space Complexity: O(N)
     */

    // Optimal Iterative Approach
    public static int fibOptimal(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int prev2 = 0;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int n = 6;

        System.out.println("Using Recursion: " + fibRecursive(n));
        System.out.println("Using Optimal Loop: " + fibOptimal(n));
    }
}
