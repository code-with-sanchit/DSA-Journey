// Problem: Find GCD (Greatest Common Divisor) of two numbers
// Brute Force: Time O(min(a, b)), Space O(1)
// Optimal (Euclidean): Time O(log(min(a, b))), Space O(1) iterative / O(log(min(a, b))) recursive

public class GCDUsingRecursion {

    // 1. Brute Force Approach
    public static int gcdBruteForce(int a, int b) {
        int gcd = 1;
        int limit = Math.min(a, b);

        for (int i = limit; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    // 2. Optimal Recursive Approach (Euclidean Algorithm)
    public static int gcdRecursive(int a, int b) {
        // Base case: when b becomes 0, a is the GCD
        if (b == 0) {
            return a;
        }

        // Euclid's formula: GCD(a, b) = GCD(b, a % b)
        return gcdRecursive(b, a % b);
    }

    // 3. Optimal Iterative Approach (Euclidean Algorithm)
    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 20, b = 8;

        System.out.println("Brute Force: " + gcdBruteForce(a, b));
        System.out.println("Optimal Recursive: " + gcdRecursive(a, b));
        System.out.println("Optimal Iterative: " + gcdIterative(a, b));
    }
}