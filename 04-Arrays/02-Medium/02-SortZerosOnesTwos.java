import java.util.Arrays;

class SortZerosOnesTwos {

    // Approach 1: Brute Force
    public static void sortBrute(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        Arrays.sort(arr);
    }
    /*
     * Time Complexity: O(N log N)
     * Space Complexity: O(1)
     */

    // Approach 2: Better (Counting)
    public static void sortBetter(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return; 
        }

        int count0 = 0, count1 = 0, count2 = 0; 

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) count0++; 
            else if (arr[i] == 1) count1++; 
            else count2++;
        }

        int index = 0; 

        for (int i = 0; i < count0; i++) {
            arr[index++] = 0; 
        }
        for (int i = 0; i < count1; i++) {
            arr[index++] = 1; 
        }
        for (int i = 0; i < count2; i++) {
            arr[index++] = 2; 
        }
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    // Approach 3: Optimal (Dutch National Flag Algorithm)
    public static void sortOptimal(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int low = 0, mid = 0, high = arr.length - 1; 

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low]; 
                arr[low] = arr[mid]; 
                arr[mid] = temp; 
                low ++; 
                mid ++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid]; 
                arr[mid] = arr[high]; 
                arr[high] = temp; 
                high --;
            }
        }
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortOptimal(arr);
        System.out.println(Arrays.toString(arr)); 
    }
}
