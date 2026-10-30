class LeftRotateArrayByOne {

    public static void rotateByOne(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int first = arr[0]; 

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i+1]; 
        }

        arr[arr.length - 1] = first; 
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static void main (String[] args) {
        int[] arr = {1,2,3,4,5}; 
        rotateByOne(arr); 

        for (int val: arr) {
            System.out.print(val + " ");
        }
    }
}
