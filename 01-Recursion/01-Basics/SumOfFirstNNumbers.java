// Problem: Sum of first N natural numbers
// Recursive: Time O(N), Space O(N) | Optimal (Formula): Time O(1), Space O(1)

public class SumOfFirstNNumbers {

    // 1. Recursive Approach
    public static int sumRecursive(int n) {
        // Base case: sum of 0 numbers is 0
        if (n <= 0) {
            return 0;
        }

        // Add current n to sum of previous numbers
        return n + sumRecursive(n - 1);
    }

    // 2. Optimal Approach (Math Formula)
    public static int sumFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Using Recursion: " + sumRecursive(n));
        System.out.println("Using Formula: " + sumFormula(n));
    }
}