public class GCDUsingRecursion {

    // Brute Force Approach
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
    /*
     * Time Complexity: O(min(a, b))
     * Space Complexity: O(1)
     */

    // Optimal Recursive Approach (Euclidean Algorithm)
    public static int gcdRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcdRecursive(b, a % b);
    }
    /*
     * Time Complexity: O(log(min(a, b)))
     * Space Complexity: O(log(min(a, b)))
     */

    // Optimal Iterative Approach (Euclidean Algorithm)
    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
    /*
     * Time Complexity: O(log(min(a, b)))
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int a = 20, b = 8;

        System.out.println("Brute Force: " + gcdBruteForce(a, b));
        System.out.println("Optimal Recursive: " + gcdRecursive(a, b));
        System.out.println("Optimal Iterative: " + gcdIterative(a, b));
    }
}
