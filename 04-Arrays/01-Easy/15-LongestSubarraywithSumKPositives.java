import java.util.HashMap; 

class LongestSubarraywithSumKPositives {

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

    // Approach 2: Better (Prefix Sum with Hashing)
    public static int longestSubarrayBetter(int[] arr, int k) {
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

    // Approach 3: Optimal (Two Pointers / Sliding Window)
    public static int longestSubarrayOptimal(int[] arr, int k) {
        int left = 0, right = 0; 
        int currentSum = 0; 
        int maxLen = 0; 
        int n = arr.length; 

        while (right < n) {
            currentSum += arr[right]; 

            while (left <= right && currentSum > k) {
                currentSum -= arr[left]; 
                left++; 
            }

            if (currentSum == k) {
                maxLen = Math.max(maxLen, right - left + 1); 
            }

            right++; 
        }

        return maxLen; 
    }
    /*
     * Time Complexity: O(2N) ~ O(N)
     * Space Complexity: O(1)
     */

    public static void main (String[] args) {
        int[] arr = {1,2,3,1,1,1,1,4,2,3}; 
        int k = 3; 

        System.out.println("Brute: " + longestSubarrayBrute(arr, k)); 
        System.out.println("Better: " + longestSubarrayBetter(arr, k)); 
        System.out.println("Optimal: " + longestSubarrayOptimal(arr, k)); 
    }
}
