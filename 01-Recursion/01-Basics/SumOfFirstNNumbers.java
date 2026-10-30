public class SumOfFirstNNumbers {

    // Recursive Approach
    public static int sumRecursive(int n) {
        if (n <= 0) {
            return 0;
        }

        return n + sumRecursive(n - 1);
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    // Optimal Approach (Formula)
    public static int sumFormula(int n) {
        return (n * (n + 1)) / 2;
    }
    /*
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Using Recursion: " + sumRecursive(n));
        System.out.println("Using Formula: " + sumFormula(n));
    }
}
