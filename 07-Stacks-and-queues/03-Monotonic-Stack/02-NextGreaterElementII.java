import java.util.Stack; 
import java.util.Arrays; 

class NextGreaterElementII {

    // Brute Force Approach
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
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 1};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Brute Force: " + Arrays.toString(bruteForce(arr1)));
        System.out.println("Optimal:     " + Arrays.toString(optimalApproach(arr1))); 

        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println("\nInput: " + Arrays.toString(arr2));
        System.out.println("Optimal:     " + Arrays.toString(optimalApproach(arr2))); 

        int[] arr3 = {10};
        System.out.println("\nInput: " + Arrays.toString(arr3));
        System.out.println("Optimal:     " + Arrays.toString(optimalApproach(arr3))); 
    }
}
