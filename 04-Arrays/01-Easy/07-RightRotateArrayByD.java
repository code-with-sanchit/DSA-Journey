class RightRotateArrayByD {

    // Approach 1: Brute Force
    public static void rotateBrute(int[] arr, int d) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        d = d % n;

        for (int count = 0; count < d; count++) {
            int last = arr[n - 1];
            for (int i = n - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = last;
        }
    }
    /*
     * Time Complexity: O(N * D)
     * Space Complexity: O(1)
     */

    // Approach 2: Optimal (Reversal Algorithm)
    public static void rotateOptimal(int[] arr, int d) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        d = d % n;

        reverse(arr, n - d, n - 1);
        reverse(arr, 0, n - d - 1);
        reverse(arr, 0, n - 1);
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotateOptimal(arr, 2);

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
