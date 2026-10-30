public class FibonacciSequence {

    private static int fibRecursive(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // Recursive Approach
    public static void printSequenceRecursive(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fibRecursive(i) + " ");
        }
        System.out.println();
    }
    /*
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(N)
     */

    // Optimal Iterative Approach
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
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int n = 8;

        System.out.print("Using Recursion: ");
        printSequenceRecursive(n);

        System.out.print("Using Optimal: ");
        printSequenceOptimal(n);
    }
}
