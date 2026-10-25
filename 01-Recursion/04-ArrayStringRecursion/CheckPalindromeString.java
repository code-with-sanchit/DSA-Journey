// Problem: Check if a String is a Palindrome
// Iterative: Time O(N), Space O(1) | Recursive: Time O(N), Space O(N)

public class CheckPalindromeString {

    // 1. Recursive Helper Function
    private static boolean checkRecursive(String str, int start, int end) {
        // Base case: pointers have met or crossed
        if (start >= end) {
            return true;
        }

        // Characters at current positions do not match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Move pointers inward
        return checkRecursive(str, start + 1, end - 1);
    }

    // Public wrapper for clean recursive usage
    public static boolean isPalindromeRecursive(String str) {
        if (str == null) return false;
        return checkRecursive(str, 0, str.length() - 1);
    }

    // 2. Optimal Iterative Approach (Two-Pointer Loop)
    public static boolean isPalindromeIterative(String str) {
        if (str == null) return false;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "madam";
        String s2 = "hello";

        System.out.println(s1 + " (Recursive): " + isPalindromeRecursive(s1));
        System.out.println(s2 + " (Iterative): " + isPalindromeIterative(s2));
    }
}