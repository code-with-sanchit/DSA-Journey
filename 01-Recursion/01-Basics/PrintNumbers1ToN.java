// Problem: Print 1 to N using recursion (Backtracking / Head Recursion)
// Time: O(N) | Space: O(N) (call stack)

public class PrintNumbers1ToN {

    public static void printNumbers(int n) {
        // Base case: stop when n reaches 0 or less
        if (n <= 0) {
            return;
        }

        // Call first, print later -> prints 1 to N as calls return
        printNumbers(n - 1);

        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = 5;
        printNumbers(n);
    }
}