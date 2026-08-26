import java.util.Queue; 
import java.util.LinkedList;

/**
 * Problem: Implement a Stack using a Queue 
 * Difficulty: Medium 
 * Pattern: Stack Implementation using a different Data Structure
 * Approach: Use one queue. Make push() the costly operation. 
 *           Whenever a new element is pushed, add it to the queue, then 
 *           rotate all the older elements to sit behind it (deque them from front and enqueue them back, size - 1 times)
 *           This way, the newest element always ends up at the front of the queue, so as normal dequeue() always removes the most
 *           recently pushed element - which is exactly what pop() needs. 
 * 
 * Time Complexity: 0(N) - for push (due to rotation), 0(1) for pop, peek 
 * Space Complexity: 0(N)
 */


class StackUsingQueue {

    private Queue<Integer> queue; 

    public StackUsingQueue() {
        queue = new LinkedList<>();
    }

    // Add element and rotate so it sits at the front 
    public void push (int x) {
            queue.add(x);
            int size = queue.size(); 

            // Move all elements that were before x to behind x 
            for (int i = 0; i < size - 1; i++) {
                queue.add(queue.poll());
            }
    }

    // Front of queue is always the "top" of the stack 
    public void pop() {
        if (queue.isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }
        queue.poll();
    }

    // Look at the top element without removing it 
    public int peek() {
        if (queue.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return queue.peek();
    }

    // Check if stack has no elements 
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element: "+ stack.peek());  // 3
        stack.pop(); 
        System.out.println("Top after pop: " + stack.peek());  // 2
    }
}