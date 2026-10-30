import java.util.Stack; 
import java.util.Arrays; 

class AsteroidCollision {

    // Optimal Approach
    static int[] optimalApproach(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) return new int[0];

        Stack <Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int current = asteroids[i];
            boolean isDestroyed = false;

            while(!stack.isEmpty() && stack.peek() > 0 && current < 0){

                if (stack.peek() < Math.abs(current)) {
                    stack.pop();
                    continue;
                }
                else if (stack.peek() == Math.abs(current)) {
                    stack.pop();
                    isDestroyed = true; 
                    break;
                }
                else {
                    isDestroyed = true;
                    break;
                }
            }

            if (!isDestroyed) {
                stack.push(current);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    public static void main(String[] args) {
        int[] arr1 = {5, 10, -5};
        System.out.println("Asteroids: " + Arrays.toString(arr1));
        System.out.println("Result:    " + Arrays.toString(optimalApproach(arr1))); 

        int[] arr2 = {8, -8};
        System.out.println("\nAsteroids: " + Arrays.toString(arr2));
        System.out.println("Result:    " + Arrays.toString(optimalApproach(arr2))); 

        int[] arr3 = {10, 2, -5};
        System.out.println("\nAsteroids: " + Arrays.toString(arr3));
        System.out.println("Result:    " + Arrays.toString(optimalApproach(arr3))); 

        int[] arr4 = {-5, 5};
        System.out.println("\nAsteroids: " + Arrays.toString(arr4));
        System.out.println("Result:    " + Arrays.toString(optimalApproach(arr4))); 
    }
}
