import java.util.Arrays; 

public class BubbleSort {

    static void bubbleSort(int[] arr) {
        int n = arr.length; 

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; 

            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                    swapped = true;
                }
            }

            if (!swapped) {
                break; 
            }
        }
    }
    /*
     * Time Complexity: O(N^2) for worst/average case, O(N) for best case
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int[] arr = {64,25,12,22,11}; 

        bubbleSort(arr); 

        System.out.println(Arrays.toString(arr)); 
    }
}
