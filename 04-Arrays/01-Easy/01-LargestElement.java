class LargestElement {

    public static int findLargest(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int largest = arr[0]; 

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i]; 
            }
        }

        return largest; 
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int[] arr = {4,7,8,6,7,6}; 
        System.out.println(findLargest(arr)); 
    }
}
