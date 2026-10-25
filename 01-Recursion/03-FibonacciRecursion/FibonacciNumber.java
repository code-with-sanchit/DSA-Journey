// Problem: Find the Nth Fibonacci Number
// Brute Force (Recursion): Time O(2^N), Space O(N)
// Optimal (Iterative): Time O(N), Space O(1)

public class FibonacciNumber {

    // 1. Recursive Approach (As introduced in basic recursion)
    public static int fibRecursive(int n) {
        // Base cases
        if (n <= 0) return 0;
        if (n == 1) return 1;

        // Sum of the previous two numbers
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // 2. Optimal Iterative Approach (Constant space)
    public static int fibOptimal(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int prev2 = 0; // fib(0)
        int prev1 = 1; // fib(1)

        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int n = 6;

        System.out.println("Using Recursion: " + fibRecursive(n));
        System.out.println("Using Optimal Loop: " + fibOptimal(n));
    }
}