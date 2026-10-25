// Problem: Reverse an Array
// Iterative: Time O(N), Space O(1) | Recursive: Time O(N), Space O(N)

import java.util.Arrays;

public class ReverseAnArray {

    // 1. Recursive Helper Function
    private static void reverseRecursiveHelper(int[] arr, int start, int end) {
        // Base case: pointers meet or cross
        if (start >= end) {
            return;
        }

        // Swap elements at start and end
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        // Recursive call with inward pointers
        reverseRecursiveHelper(arr, start + 1, end - 1);
    }

    // Public wrapper for clean recursive usage
    public static void reverseRecursive(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        reverseRecursiveHelper(arr, 0, arr.length - 1);
    }

    // 2. Optimal Iterative Approach (Two-Pointer Loop)
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

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        reverseRecursive(arr1);
        System.out.println("Using Recursion: " + Arrays.toString(arr1));

        int[] arr2 = {10, 20, 30, 40};
        reverseIterative(arr2);
        System.out.println("Using Loop: " + Arrays.toString(arr2));
    }
}