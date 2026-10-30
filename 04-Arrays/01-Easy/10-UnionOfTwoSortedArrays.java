import java.util.ArrayList; 
import java.util.TreeSet; 

class UnionOfTwoSortedArrays {

    // Approach 1: Brute Force (TreeSet)
    public static ArrayList<Integer> findUnionBrute(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<>(); 

        for (int val: arr1) {
            set.add(val);
        }
        for (int val: arr2) {
            set.add(val);
        }

        return new ArrayList<>(set); 
    }
    /*
     * Time Complexity: O((N + M) log(N + M))
     * Space Complexity: O(N + M)
     */

    // Approach 2: Optimal (Two Pointers)
    public static ArrayList<Integer> findUnionOptimal(int[] arr1, int[] arr2) {
        ArrayList<Integer> union = new ArrayList<>(); 
        int i = 0, j = 0; 
        int n = arr1.length, m = arr2.length; 

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]); 
                }
                i++;
            } else {
                if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++; 
            }
        }

        while (i < n) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++; 
        }

        while (j < m) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++; 
        }

        return union; 
    }
    /*
     * Time Complexity: O(N + M)
     * Space Complexity: O(N + M)
     */

    public static void main (String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};

        System.out.println("Brute: " + findUnionBrute(arr1, arr2));
        System.out.println("Optimal: " + findUnionOptimal(arr1, arr2));
    }
}
