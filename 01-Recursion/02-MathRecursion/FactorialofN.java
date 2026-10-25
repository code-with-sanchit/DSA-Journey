// Problem: Find Factorial of a number N
// Iterative: Time O(N), Space O(1) | Recursive: Time O(N), Space O(N)

public class FactorialofN {

    // 1. Recursive Approach
    public static long factorialRecursive(int n) {
        // Base case: 0! = 1 and 1! = 1
        if (n <= 1) {
            return 1;
        }

        // Multiply n with factorial of (n - 1)
        return n * factorialRecursive(n - 1);
    }

    // 2. Iterative Approach (Using a loop)
    public static long factorialIterative(int n) {
        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Using Recursion: " + factorialRecursive(n));
        System.out.println("Using Loop: " + factorialIterative(n));
    }
}