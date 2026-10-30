import java.util.HashMap; 

class LongestSubarrayWithSumKPositivesAndNegatives {

    // Approach 1: Brute Force
    public static int longestSubarrayBrute(int[] arr, int k) {
        int maxLen = 0; 
        int n = arr.length; 

        for (int i = 0; i < n; i++) {
            int sum = 0; 
            for (int j = i; j < n; j++) {
                sum += arr[j]; 
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1); 
                }
            }
        }
        return maxLen; 
    }
    /*
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */

    // Approach 2: Optimal (Prefix Sum with Hashing)
    public static int longestSubarrayOptimal(int[] arr, int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>(); 
        int maxLen = 0; 
        int currentSum = 0; 

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i]; 

            if (currentSum == k) {
                maxLen = i + 1; 
            }

            int remainder = currentSum - k; 
            if (prefixSumMap.containsKey(remainder)) {
                int len = i - prefixSumMap.get(remainder); 
                maxLen = Math.max(maxLen, len); 
            }

            if (!prefixSumMap.containsKey(currentSum)) {
                prefixSumMap.put(currentSum, i); 
            }
        }
        return maxLen; 
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    public static void main (String[] args) {
        int[] arr = {1, -1, 5, -2, 3}; 
        int k = 3; 

        System.out.println("Brute: " + longestSubarrayBrute(arr, k)); 
        System.out.println("Optimal: " + longestSubarrayOptimal(arr, k)); 
    }
}
