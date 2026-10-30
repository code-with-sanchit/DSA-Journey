class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; 
        }

        int i = 0; 

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++; 
                arr[i] = arr[j]; 
            }
        }

        return i + 1; 
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,4,4}; 
        int uniqueCount = removeDuplicates(arr); 

        for (int k = 0; k < uniqueCount; k++) { 
            System.out.print(arr[k] + " "); 
        } 
    }   
}
