public class PrimeNumbers {

    private static boolean checkPrimeRecursive(int n, int divisor) {
        if ((long) divisor * divisor > n) {
            return true;
        }

        if (n % divisor == 0) {
            return false;
        }

        return checkPrimeRecursive(n, divisor + 1);
    }

    // Recursive Approach
    public static boolean isPrimeRecursive(int n) {
        if (n <= 1) return false;
        return checkPrimeRecursive(n, 2);
    }
    /*
     * Time Complexity: O(sqrt(N))
     * Space Complexity: O(sqrt(N))
     */

    // Optimal Iterative Approach
    public static boolean isPrimeIterative(int n) {
        if (n <= 1) return false;

        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    /*
     * Time Complexity: O(sqrt(N))
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int n1 = 29;
        int n2 = 15;

        System.out.println(n1 + " is prime (Recursive): " + isPrimeRecursive(n1));
        System.out.println(n2 + " is prime (Iterative): " + isPrimeIterative(n2));
    }
}
