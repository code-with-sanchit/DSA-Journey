public class PrintNumbers1ToN {

    public static void printNumbers(int n) {
        if (n <= 0) {
            return;
        }

        printNumbers(n - 1);

        System.out.print(n + " ");
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    public static void main(String[] args) {
        int n = 5;
        printNumbers(n);
    }
}
