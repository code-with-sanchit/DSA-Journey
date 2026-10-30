import java.util.Stack; 
import java.util.Arrays; 

class NextSmallerElement {

    // Brute Force Approach
    static int[] bruteForce(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int n = arr.length; 
        int[] result = new int[n]; 

        for (int i = 0; i < n; i++) {
            result[i] = -1; 
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    result[i] = arr[j]; 
                    break;
                }
            }
        }
        return result;
    }
    /*
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */

    // Optimal Approach
    static int[] optimalApproach(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int n = arr.length; 
        int[] result = new int[n];
        Stack <Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
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
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    public static void main(String[] args) {
        int[] arr1 = {4, 8, 5, 2, 25};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Brute Force: " + Arrays.toString(bruteForce(arr1)));
        System.out.println("Optimal:     " + Arrays.toString(optimalApproach(arr1))); 

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("\nInput: " + Arrays.toString(arr2));
        System.out.println("Optimal:     " + Arrays.toString(optimalApproach(arr2))); 

        int[] arr3 = {10};
        System.out.println("\nInput: " + Arrays.toString(arr3));
        System.out.println("Optimal:     " + Arrays.toString(optimalApproach(arr3))); 
    }
}
