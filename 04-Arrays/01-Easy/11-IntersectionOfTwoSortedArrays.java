import java.util.ArrayList; 
import java.util.HashMap; 

class IntersectionOfTwoSortedArrays {

    // Approach 1: Brute Force
    public static ArrayList<Integer> findIntersectionBrute(int[] arr1, int[] arr2) {
        ArrayList<Integer> intersection = new ArrayList<>(); 
        boolean[] visited = new boolean[arr2.length]; 

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j] && !visited[j]) {
                    intersection.add(arr1[i]); 
                    visited[j] = true; 
                    break;
                }
            }
        }
        return intersection; 
    }
    /*
     * Time Complexity: O(N * M)
     * Space Complexity: O(M)
     */

    // Approach 2: Better (Hashing)
    public static ArrayList<Integer> findIntersectionBetter(int[] arr1, int[] arr2) {
        ArrayList<Integer> intersection = new ArrayList<>(); 
        HashMap<Integer, Integer> freq = new HashMap<>(); 

        for (int num: arr2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1); 
        }

        for (int num: arr1) {
            if (freq.containsKey(num) && freq.get(num) > 0) {
                intersection.add(num); 
                freq.put(num, freq.get(num) - 1); 
            }
        }
        return intersection; 
    }
    /*
     * Time Complexity: O(N + M)
     * Space Complexity: O(M)
     */

    // Approach 3: Optimal (Two Pointers)
    public static ArrayList<Integer> findIntersectionOptimal(int[] arr1, int[] arr2) {
        ArrayList<Integer> intersection = new ArrayList<>(); 
        int i = 0, j = 0; 
        int n = arr1.length, m = arr2.length; 

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                i++; 
            } else if (arr2[j] < arr1[i]) {
                j++; 
            } else {
                intersection.add(arr1[i]); 
                i++; 
                j++; 
            }
        }
        return intersection; 
    }
    /*
     * Time Complexity: O(N + M)
     * Space Complexity: O(1)
     */

    public static void main (String[] args) {
        int[] arr1 = {1,2,2,3,3,4,5,6}; 
        int[] arr2 = {2,2,3,5}; 

        System.out.println(findIntersectionBrute(arr1,arr2)); 
        System.out.println(findIntersectionBetter(arr1,arr2));
        System.out.println(findIntersectionOptimal(arr1,arr2)); 
    }
}
