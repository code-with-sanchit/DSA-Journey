import java.util.Arrays; 

class NumberOfGreaterElementsToTheRight {

    static int[] optimalApproach(int[] arr, int[] queries) {
        if (arr == null || queries == null) return new int[0];

        int n = arr.length; 
        int q = queries.length; 
        int[] result = new int[q];

        // Process each query one by one
        for(int i = 0; i < q; i++) {
            int queryIndex = queries[i];  // The index we need to check
            int count = 0;   // counter for greater elements

            for (int j = queryIndex + 1; j < n; j++) {
                if (arr[j] > arr[queryIndex]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard Array
        int[] arr1 = {3, 4, 2, 7, 5, 8, 10, 6};
        int[] queries1 = {0, 5}; 
        // Query 0 (value 3): greater elements to the right are 4, 7, 5, 8, 10, 6 (Count: 6)
        // Query 5 (value 8): greater elements to the right are 10 (Count: 1)
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Queries (Indices): " + Arrays.toString(queries1));
        System.out.println("Result: " + Arrays.toString(optimalApproach(arr1, queries1))); 
        // Expected: [6, 1]

        // Test Case 2: Strictly Decreasing Array
        int[] arr2 = {10, 9, 8, 7};
        int[] queries2 = {0, 1, 2, 3}; 
        System.out.println("\nArray: " + Arrays.toString(arr2));
        System.out.println("Queries (Indices): " + Arrays.toString(queries2));
        System.out.println("Result: " + Arrays.toString(optimalApproach(arr2, queries2))); 
        // Expected: [0, 0, 0, 0]
    }
}

/**
 * TIME AND SPACE COMPLEXITY (OPTIMAL / ACCEPTED APPROACH):
 * 
* Time Complexity (TC): O(Q * N)
* - Let Q be the number of queries and N be the size of the array.
* - For every query (Q times), we use a 'for' loop to check the numbers to 
*   its right (which takes up to N steps). 
* - Total time is Q multiplied by N.
* 
* Space Complexity (SC): O(Q)
* - We create a 'result' array of size Q to store the answer for each query.
 */