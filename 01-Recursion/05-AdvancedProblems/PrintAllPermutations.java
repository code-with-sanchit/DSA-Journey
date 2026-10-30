import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {

    private static void permuteVisitedHelper(int[] arr, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(arr[i]);

                permuteVisitedHelper(arr, visited, current, result);

                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }

    // Approach 1: Using Visited Array
    public static List<List<Integer>> permuteUsingVisited(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        permuteVisitedHelper(arr, visited, new ArrayList<>(), result);
        return result;
    }
    /*
     * Time Complexity: O(N! * N)
     * Space Complexity: O(N)
     */

    private static void permuteSwapHelper(int[] arr, int start, List<List<Integer>> result) {
        if (start == arr.length) {
            List<Integer> current = new ArrayList<>();
            for (int num : arr) {
                current.add(num);
            }
            result.add(current);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            permuteSwapHelper(arr, start + 1, result);
            swap(arr, start, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Approach 2: Optimal In-Place Swap
    public static List<List<Integer>> permuteOptimal(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        permuteSwapHelper(arr, 0, result);
        return result;
    }
    /*
     * Time Complexity: O(N! * N)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        System.out.println("Using In-Place Swap (Optimal):");
        List<List<Integer>> permutations = permuteOptimal(arr);
        for (List<Integer> perm : permutations) {
            System.out.println(perm);
        }
    }
}
