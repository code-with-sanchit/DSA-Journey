import java.util.HashMap;

class FindTheSingleNumber {

    // Approach 1: Brute Force
    public static int findSingleBrute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            if (count == 1) {
                return arr[i];
            }
        }

        return -1;
    }
    /*
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */

    // Approach 2: Better (Hashing)
    public static int findSingleBetter(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (freq.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    // Approach 3: Optimal (XOR)
    public static int findSingleXOR(int[] arr) {
        int result = 0;

        for (int num : arr) {
            result = result ^ num;
        }

        return result;
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println(findSingleBrute(arr));
        System.out.println(findSingleBetter(arr));
        System.out.println(findSingleXOR(arr));
    }
}
