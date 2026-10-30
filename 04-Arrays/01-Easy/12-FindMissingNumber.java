class FindMissingNumber {

    // Approach 1: Brute Force
    public static int findMissingBrute(int[] arr, int n) {
        for (int number = 1; number <= n; number++) {
            boolean found = false;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == number) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return number;
            }
        }

        return -1;
    }
    /*
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */

    // Approach 2: Better (Hashing)
    public static int findMissingBetter(int[] arr, int n) {
        boolean[] seen = new boolean[n + 1];

        for (int num : arr) {
            seen[num] = true;
        }

        for (int number = 1; number <= n; number++) {
            if (!seen[number]) {
                return number;
            }
        }

        return -1;
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    // Approach 3: Optimal (Sum Formula)
    public static int findMissingSumFormula(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    // Approach 4: Optimal (XOR)
    public static int findMissingXOR(int[] arr, int n) {
        int xor1 = 0;
        int xor2 = 0;

        for (int i = 1; i <= n; i++) {
            xor1 = xor1 ^ i;
        }

        for (int num : arr) {
            xor2 = xor2 ^ num;
        }

        return xor1 ^ xor2;
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int n = 5;

        System.out.println(findMissingBrute(arr, n));
        System.out.println(findMissingBetter(arr, n));
        System.out.println(findMissingSumFormula(arr, n));
        System.out.println(findMissingXOR(arr, n));
    }
}
