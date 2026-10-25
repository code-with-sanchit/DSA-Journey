// Problem: Check if a number is an Armstrong number
// Iterative: Time O(D), Space O(1) | Recursive: Time O(D), Space O(D)
// (where D is the number of digits)

public class ArmstrongNumber {

    // Helper function to count total digits
    public static int countDigits(int n) {
        if (n == 0) return 0;
        return 1 + countDigits(n / 10);
    }

    // 1. Recursive Approach
    private static int sumOfPowersRecursive(int n, int totalDigits) {
        if (n == 0) {
            return 0;
        }

        int lastDigit = n % 10;
        int power = (int) Math.pow(lastDigit, totalDigits);

        return power + sumOfPowersRecursive(n / 10, totalDigits);
    }

    public static boolean isArmstrongRecursive(int n) {
        if (n < 0) return false;
        int totalDigits = countDigits(n);
        return sumOfPowersRecursive(n, totalDigits) == n;
    }

    // 2. Iterative Approach (Standard loop method)
    public static boolean isArmstrongIterative(int n) {
        if (n < 0) return false;

        int totalDigits = String.valueOf(n).length();
        int temp = n;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, totalDigits);
            temp /= 10;
        }

        return sum == n;
    }

    public static void main(String[] args) {
        int n = 153;

        System.out.println("Using Recursion: " + isArmstrongRecursive(n));
        System.out.println("Using Loop: " + isArmstrongIterative(n));
    }
}