import java.util.Stack; 
import java.util.Arrays; 

class SumOfSubarrayMinimums {

    // Brute Force Approach
    static int bruteForce(int[] arr) {
        if (arr == null || arr.length == 0) return 0; 

        int n = arr.length; 
        int totalSum = 0; 
        int mod = (int)(1e9 + 7);

        for (int i = 0; i < n; i++) {
            int currentMin = arr[i]; 
            for (int j = i; j < n; j++) {
                currentMin = Math.min(currentMin, arr[j]); 
                totalSum = (totalSum + currentMin) % mod;
            }
        }
        return totalSum;
    }
    /*
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */

    static int[] findNSE(int[] arr) {
        int n = arr.length; 
        int[] nse = new int[n]; 
        Stack <Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    static int[] findPSE(int[] arr) {
        int n = arr.length; 
        int[] pse = new int[n]; 
        Stack <Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    // Optimal Approach
    static int optimalApproach(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int n = arr.length; 
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        long totalSum = 0; 
        int mod = (int)(1e9 + 7);

        for (int i = 0; i < n; i++) {
            long leftCount = i - pse[i];
            long rightCount = nse[i] - i;

            long totalSubarrays = leftCount * rightCount; 

            long value = (totalSubarrays * arr[i]) % mod;
            
            totalSum = (totalSum + value) % mod;
        }
        
        return (int)totalSum;
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 2, 4};
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Brute Force: " + bruteForce(arr1));
        System.out.println("Optimal:     " + optimalApproach(arr1)); 

        int[] arr2 = {11, 81, 94, 43, 3};
        System.out.println("\nArray: " + Arrays.toString(arr2));
        System.out.println("Optimal:     " + optimalApproach(arr2)); 
    }
}
