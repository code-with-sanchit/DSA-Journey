class LinearSearch {

    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 9, 3};
        int target = 1;

        System.out.println(search(arr, target));
    }
}
