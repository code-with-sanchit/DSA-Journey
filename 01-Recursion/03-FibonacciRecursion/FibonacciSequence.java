// Problem: Print Fibonacci Sequence up to N terms
// Brute Force (Loop + Recursion): Time O(N * 2^N), Space O(N)
// Optimal (Iterative Loop): Time O(N), Space O(1)

public class FibonacciSequence {

    // Helper: Nth Fibonacci using recursion
    private static int fibRecursive(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // 1. Recursive Approach (Calls recursive fib in a loop)
    public static void printSequenceRecursive(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fibRecursive(i) + " ");
        }
        System.out.println();
    }

    // 2. Optimal Iterative Approach (Computes each term on the go)
    public static void printSequenceOptimal(int n) {
        if (n <= 0) return;

        int prev2 = 0;
        int prev1 = 1;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print(prev2 + " ");
            } else if (i == 1) {
                System.out.print(prev1 + " ");
            } else {
                int current = prev1 + prev2;
                prev2 = prev1;
                prev1 = current;
                System.out.print(current + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 8;

        System.out.print("Using Recursion: ");
        printSequenceRecursive(n);

        System.out.print("Using Optimal: ");
        printSequenceOptimal(n);
    }
}