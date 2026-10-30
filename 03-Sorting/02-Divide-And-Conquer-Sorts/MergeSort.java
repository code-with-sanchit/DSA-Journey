import java.util.Arrays; 

public class MergeSort {

    static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return; 
        }

        int mid = low + (high - low) / 2; 

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    /*
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */

    static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1]; 

        int left = low;
        int right = mid + 1;
        int k = 0;

        while(left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k] = arr[left]; 
                left++;
            } else {
                temp[k] = arr[right]; 
                right++;
            }
            k++;
        }

        while (left <= mid) {
            temp[k] = arr[left];
            left++;
            k++; 
        }

        while (right <= high) {  
            temp[k] = arr[right]; 
            right++; 
            k++; 
        }

        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i]; 
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11}; 

        mergeSort(arr, 0, arr.length - 1); 

        System.out.println(Arrays.toString(arr));
    }
}
