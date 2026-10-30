import java.util.Scanner; 

public class NumberHashing {

    static int[] precomputeFrequency(int[] arr, int maxVal) {
        int[] hash = new int[maxVal + 1]; 
        for (int x: arr) {
            hash[x]++;
        }
        return hash;
    }
    /*
     * Time Complexity: O(N) to precompute frequencies, O(1) per query
     * Space Complexity: O(maxVal) for the hash array
     */

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,5,5,10}; 
        int maxVal = 1000;

        int[] hash = precomputeFrequency(arr,maxVal); 

        System.out.println("Count of 5: "+ hash[5]);
        System.out.println("Count of 2: " + hash[2]);
        System.out.println("Count of 7: " + hash[7]);
    }
}
