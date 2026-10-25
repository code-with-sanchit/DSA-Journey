// Problem: Print N to 1 using recursion (Tail Recursion)
// Time: O(N) | Space: O(N) (call stack)

public class PrintNumbersNTo1 {

    public static void printNumbers(int n) {
        // Base case: stop when n reaches 0 or less
        if (n <= 0) {
            return;
        }

        // Print first, call later -> prints N down to 1
        System.out.print(n + " ");

        printNumbers(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        printNumbers(n);
    }
}