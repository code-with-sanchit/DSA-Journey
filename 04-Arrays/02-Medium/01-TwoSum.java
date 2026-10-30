import java.util.Arrays; 
import java.util.HashMap; 

class TwoSum {

    // Approach 1: Brute Force
    public static int[] twoSumBrute(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return new int[]{-1,-1};
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    /*
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */

    // Approach 2: Better (Hashing)
    public static int[] twoSumBetter(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return new int[]{-1,-1};
        }

        HashMap<Integer,Integer> seen = new HashMap<>(); 

        for (int i = 0; i < arr.length; i++) {
            int needed = target - arr[i]; 

            if (seen.containsKey(needed)) {
                return new int[]{seen.get(needed),i};
            }
            seen.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    // Approach 3: Optimal (Two Pointers)
    public static int[] twoSumOptimal(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return new int[]{-1,-1}; 
        }

        Arrays.sort(arr);  

        int left = 0, right = arr.length - 1; 

        while (left < right) {
            int sum = arr[left] + arr[right]; 

            if (sum == target) {
                return new int[]{arr[left], arr[right]};
            } else if (sum < target) {
                left ++;
            } else {
                right --;
            }
        }

        return new int[]{-1,-1};
    }
    /*
     * Time Complexity: O(N log N)
     * Space Complexity: O(1)
     */

    public static void main (String[] args) {
        int[] arr = {2,7,11,15}; 
        int target = 9; 
        int[] result = twoSumOptimal(arr, target);
        System.out.println(Arrays.toString(result));
    }
}
