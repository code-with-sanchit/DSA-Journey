import java.util.Arrays; 

class MoveZerosToEnd {

    // Approach 1: Brute Force
    public static void moveZerosBrute(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length; 
        int[] temp = new int[n]; 
        int index = 0; 

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[index++] = arr[i]; 
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i]; 
        }
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    // Approach 2: Optimal (Two Pointers)
    public static void moveZerosOptimal(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; 
        }

        int j = 0; 

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
                j++; 
            }
        }
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static void main (String[] args) {
        int[] arr = {0,1,0,3,12}; 
        moveZerosOptimal(arr); 

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
