// Problem: Check if a number is Prime
// Iterative: Time O(sqrt(N)), Space O(1) | Recursive: Time O(sqrt(N)), Space O(sqrt(N))

public class PrimeNumbers {

    // 1. Recursive Helper Function
    private static boolean checkPrimeRecursive(int n, int divisor) {
        // Base case 1: checked all numbers up to sqrt(n)
        if ((long) divisor * divisor > n) {
            return true;
        }

        // Base case 2: found a divisor
        if (n % divisor == 0) {
            return false;
        }

        // Check next number
        return checkPrimeRecursive(n, divisor + 1);
    }

    // Public wrapper for recursive check
    public static boolean isPrimeRecursive(int n) {
        if (n <= 1) return false;
        return checkPrimeRecursive(n, 2);
    }

    // 2. Optimal Iterative Approach (Standard loop method)
    public static boolean isPrimeIterative(int n) {
        if (n <= 1) return false;

        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n1 = 29;
        int n2 = 15;

        System.out.println(n1 + " is prime (Recursive): " + isPrimeRecursive(n1));
        System.out.println(n2 + " is prime (Iterative): " + isPrimeIterative(n2));
    }
}