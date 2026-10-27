import java.util.Stack; 
import java.util.Arrays; 

class NextGreaterElementII {

    /** Brute Force */

    static int[] bruteForce(int[] arr) {
        if (arr == null || arr.length == 0){
            return new int[0];
        }

        int n = arr.length; 
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = -1;

            for (int j = 1; j < n; j++) {
                int circularIndex = (i + j) % n;

                if (arr[circularIndex] > arr[i]) {
                    result[i] = arr[circularIndex];
                    break;
                }
            }
        }
        return result;
    }

/**
     * * TC: O(N^2) because we use a nested loop.
     * SC: O(N) for the result array.
*/
     

/** Optimal Approach */
     static int[] optimalApproach(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int n = arr.length; 
        int[] result = new int[n];
        Stack <Integer> stack = new Stack<>();

        for (int i = (2 * n) - 1; i >= 0; i--) {
            int realIndex = i % n;

            while (!stack.isEmpty() && stack.peek() <= arr[realIndex]) {
                stack.pop();
            }

            if (i < n) {
                if (stack.isEmpty()) {
                    result[realIndex] = -1;
                } else {
                    result[realIndex] = stack.peek();
                }
            }
            stack.push(arr[realIndex]);
        }
        return result;
     }
    /**
     * TC: 0(N)
     * SC: 0(N)
     */

     public static void main(String[] args) {
        // Test Case 1: Simple circular array
        int[] arr1 = {1, 2, 1};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Brute Force: " + Arrays.toString(bruteForce(arr1)));
        System.out.println("Optimal:     " + Arrays.toString(optimalApproach(arr1))); 
        // Expected: [2, -1, 2]

        // Test Case 2: Decreasing array (wraps around to the first element)
        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println("\nInput: " + Arrays.toString(arr2));
        System.out.println("Optimal:     " + Arrays.toString(optimalApproach(arr2))); 
        // Expected: [-1, 5, 5, 5, 5]

        // Test Case 3: Edge Case (Single Element)
        int[] arr3 = {10};
        System.out.println("\nInput: " + Arrays.toString(arr3));
        System.out.println("Optimal:     " + Arrays.toString(optimalApproach(arr3))); 
        // Expected: [-1]
     }
}