public class CheckPalindromeString {

    private static boolean checkRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return checkRecursive(str, start + 1, end - 1);
    }

    // Recursive Approach
    public static boolean isPalindromeRecursive(String str) {
        if (str == null) return false;
        return checkRecursive(str, 0, str.length() - 1);
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    // Optimal Iterative Approach
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
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        String s1 = "madam";
        String s2 = "hello";

        System.out.println(s1 + " (Recursive): " + isPalindromeRecursive(s1));
        System.out.println(s2 + " (Iterative): " + isPalindromeIterative(s2));
    }
}
