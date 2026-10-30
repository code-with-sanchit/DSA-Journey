import java.util.Arrays; 

class TrappingRainWater {

    static int bruteForce(int[] arr) {
        if (arr == null || arr.length <= 2) return 0; 

        int n = arr.length; 
        int totalWater = 0; 

        for (int i = 0; i < n; i++) {
            int leftMax = 0; 
            int rightMax = 0; 

            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, arr[j]);
            }

            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }

            totalWater += Math.min(leftMax, rightMax) - arr[i];
        }
        return totalWater;
    }
/**
 * Time Complexity: O(N^2) because for every element, we loop left and right.
* Space Complexity: O(1)
*/
   static int betterApproach(int[] arr) {
    if (arr == null || arr.length <= 2) return 0; 

    int n = arr.length; 
    int[] leftMaxArray = new int[n];
    int[] rightMaxArray = new int[n];

    leftMaxArray[0] = arr[0];
    for (int i = 1; i < n; i++) {
        leftMaxArray[i] = Math.max(leftMaxArray[i-1], arr[i]);
    }
    rightMaxArray[n-1] = arr[n-1];
    for (int i = n-2; i >= 0; i--) {
        rightMaxArray[i] = Math.max(rightMaxArray[i+1], arr[i]);
    }

    int totalWater = 0; 
    for (int i = 0; i < n; i++) {
        totalWater += Math.min(leftMaxArray[i], rightMaxArray[i]) - arr[i];
    }
    return totalWater;
   }

   /**
    * Time Complexity: 0(N)
    * Space Complexity: 0(N)
    */

   static int optimalApproach(int[] arr) {
    if (arr == null || arr.length <= 2) return 0;

    int n = arr.length; 
    int left = 0; 
    int right = n - 1; 
    
    int leftMax = 0; 
    int rightMax = 0; 
    int totalWater = 0; 

    while (left <= right) {
        if (arr[left] <= arr[right]) {
            if (arr[left] >= leftMax) {
                leftMax = arr[left];   // Update left max 
            } else {
                totalWater += leftMax - arr[left];  // Trap Water
            }
            left++;  // Move left pointer
        }
        // If the right building is smaller, we process the right side.
        else {
            if (arr[right] >= rightMax) {
                rightMax = arr[right];    // Update right max 
            } else {
                totalWater += rightMax - arr[right];  // Trap Water
            }
            right --;  // Move right pointer   
        }
    }
    return totalWater;
   }


   public static void main(String[] args) {
        // Test Case 1: Standard heights map
        int[] arr1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Elevations: " + Arrays.toString(arr1));
        System.out.println("Brute Force: " + bruteForce(arr1));
        System.out.println("Better:      " + betterApproach(arr1));
        System.out.println("Optimal:     " + optimalApproach(arr1)); 
        // Expected: 6

        // Test Case 2: Flat ground (no water can be trapped)
        int[] arr2 = {2, 2, 2, 2};
        System.out.println("\nElevations: " + Arrays.toString(arr2));
        System.out.println("Optimal:     " + optimalApproach(arr2)); 
        // Expected: 0

        // Test Case 3: Pyramid shape (no water can be trapped)
        int[] arr3 = {1, 2, 3, 2, 1};
        System.out.println("\nElevations: " + Arrays.toString(arr3));
        System.out.println("Optimal:     " + optimalApproach(arr3)); 
        // Expected: 0
    }
}

/**
 * Time Complexity: 0(N)
 * Space Complexity: 0(1)
 */


