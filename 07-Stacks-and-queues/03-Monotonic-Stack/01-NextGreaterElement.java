import java.util.Stack; 
import java.util.Arrays; 

class NextGreaterElement {

    // Brute Force Approach 
    static int[] bruteForce(int[] arr) {
        if (arr == null || arr.length == 0){
            return new int[0];
        }
        int n = arr.length; 
        int [] result = new int[n]; 

        for (int i = 0; i < n; i++) {
            result[i] = -1;
            for (int j = i+ 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }
/**
 * TC: O(N^2) because of the nested loops.
* SC: O(N) to store the answer.
 */

    /** Optimal Appraoch */
    static int[] optimalApproach(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int n = arr.length;
        int[] result = new int[n];
        Stack <Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
/**
 * TC: 0(N) where N is the size of the array 
 * SC: 0(N) for the stack and the result array
 */

    public static void main(String[] args) {
        // Test Case 1: Mixed array
        int[] arr1 = {4, 1, 2, 5};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Brute Force: " + Arrays.toString(bruteForce(arr1)));
        System.out.println("Optimal:     " + Arrays.toString(optimalApproach(arr1))); 
        // Expected: [5, 2, 5, -1]

        // Test Case 2: Strictly decreasing array
        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println("\nInput: " + Arrays.toString(arr2));
        System.out.println("Optimal:     " + Arrays.toString(optimalApproach(arr2))); 
        // Expected: [-1, -1, -1, -1, -1]

        // Test Case 3: Edge Case (Single Element)
        int[] arr3 = {10};
        System.out.println("\nInput: " + Arrays.toString(arr3));
        System.out.println("Optimal:     " + Arrays.toString(optimalApproach(arr3)));
        // Expected: [-1]
    }

}

