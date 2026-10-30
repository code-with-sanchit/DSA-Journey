import java.util.Arrays; 

class NumberOfGreaterElementsToTheRight {

    static int[] optimalApproach(int[] arr, int[] queries) {
        if (arr == null || queries == null) return new int[0];

        int n = arr.length; 
        int q = queries.length; 
        int[] result = new int[q];

        for(int i = 0; i < q; i++) {
            int queryIndex = queries[i];
            int count = 0;

            for (int j = queryIndex + 1; j < n; j++) {
                if (arr[j] > arr[queryIndex]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
    /*
     * Time Complexity: O(Q * N)
     * Space Complexity: O(Q)
     */

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 2, 7, 5, 8, 10, 6};
        int[] queries1 = {0, 5}; 
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Queries (Indices): " + Arrays.toString(queries1));
        System.out.println("Result: " + Arrays.toString(optimalApproach(arr1, queries1))); 

        int[] arr2 = {10, 9, 8, 7};
        int[] queries2 = {0, 1, 2, 3}; 
        System.out.println("\nArray: " + Arrays.toString(arr2));
        System.out.println("Queries (Indices): " + Arrays.toString(queries2));
        System.out.println("Result: " + Arrays.toString(optimalApproach(arr2, queries2))); 
    }
}
