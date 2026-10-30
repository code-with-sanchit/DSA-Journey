public class PrintNTimes {

    public static void printN(int n) {
        if (n <= 0) {
            return;
        }

        System.out.println("Programming");

        printN(n - 1);
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    public static void main(String[] args) {
        int n = 5;
        printN(n);
    }
}
