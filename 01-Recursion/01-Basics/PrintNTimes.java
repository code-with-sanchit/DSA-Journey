// Problem: Print a statement N times using recursion
// Time: O(N) | Space: O(N) (call stack)

public class PrintNTimes {

    public static void printN(int n) {
        // Base case: stop when n reaches 0 or less
        if (n <= 0) {
            return;
        }

        System.out.println("Programming");

        // Recursive call with reduced value
        printN(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        printN(n);
    }
}