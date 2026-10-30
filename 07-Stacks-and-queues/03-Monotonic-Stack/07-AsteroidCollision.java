import java.util.Stack; 
import java.util.Arrays; 

class AsteroidCollision {

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

    public static void main(String[] args) {
        // Test Case 1: Right-moving (5, 10) and Left-moving (-5)
        // 10 is bigger than -5, so -5 is destroyed. 5 and 10 never collide.
        int[] arr1 = {5, 10, -5};
        System.out.println("Asteroids: " + Arrays.toString(arr1));
        System.out.println("Result:    " + Arrays.toString(optimalApproach(arr1))); 
        // Expected: [5, 10]

        // Test Case 2: Same size crash
        // Both 8 and -8 are destroyed.
        int[] arr2 = {8, -8};
        System.out.println("\nAsteroids: " + Arrays.toString(arr2));
        System.out.println("Result:    " + Arrays.toString(optimalApproach(arr2))); 
        // Expected: []

        // Test Case 3: Chain reaction crash
        // 10 is right-moving. 2 and -5 crash (2 destroyed). Then 10 and -5 crash (-5 destroyed).
        int[] arr3 = {10, 2, -5};
        System.out.println("\nAsteroids: " + Arrays.toString(arr3));
        System.out.println("Result:    " + Arrays.toString(optimalApproach(arr3))); 
        // Expected: [10]

        // Test Case 4: No crash (moving away from each other)
        // -5 moves left, 5 moves right. They never cross paths.
        int[] arr4 = {-5, 5};
        System.out.println("\nAsteroids: " + Arrays.toString(arr4));
        System.out.println("Result:    " + Arrays.toString(optimalApproach(arr4))); 
        // Expected: [-5, 5]
    }
}