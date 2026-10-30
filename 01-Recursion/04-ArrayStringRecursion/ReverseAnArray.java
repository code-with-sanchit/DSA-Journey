import java.util.Arrays;

public class ReverseAnArray {

    private static void reverseRecursiveHelper(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseRecursiveHelper(arr, start + 1, end - 1);
    }

    // Recursive Approach
    public static void reverseRecursive(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        reverseRecursiveHelper(arr, 0, arr.length - 1);
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    // Optimal Iterative Approach
    public static void reverseIterative(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        reverseRecursive(arr1);
        System.out.println("Using Recursion: " + Arrays.toString(arr1));

        int[] arr2 = {10, 20, 30, 40};
        reverseIterative(arr2);
        System.out.println("Using Loop: " + Arrays.toString(arr2));
    }
}
