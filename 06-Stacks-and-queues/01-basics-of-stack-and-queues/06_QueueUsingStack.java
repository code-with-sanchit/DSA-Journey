import java.util.Stack;

/**
 * Problem: Implement a Queue using Stacks
 * Difficulty: Medium
 * Pattern: Queue Implementation using Stacks
 * Approach: Use two stacks (stack1 and stack2). 
 *           - enqueue(): Push the element to stack1. (O(1))
 *           - dequeue(): If stack2 is empty, move all elements from stack1 to stack2 (reversing their order).
 *                        Then, pop the top element from stack2. (Amortized O(1))
 *           - peek(): If stack2 is empty, move all elements from stack1 to stack2.
 *                     Then, return the top element of stack2 without popping it. (Amortized O(1))
 * 
 * Time Complexity: O(1) for enqueue, Amortized O(1) for dequeue/peek
 * Space Complexity: O(N)
 */

class QueueUsingStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Add element to the rear of the queue
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Remove element from the front of the queue
    public void dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }
        
        // If stack2 is empty, transfer all elements from stack1
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }

    // Look at the front element without removing it
    public int peek() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // If stack2 is empty, transfer all elements from stack1
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if queue has no elements
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Front element: " + queue.peek()); // 1
        queue.dequeue();
        System.out.println("Front after dequeue: " + queue.peek()); // 2
        queue.dequeue();
        System.out.println("Is empty: " + queue.isEmpty()); // false
        queue.dequeue();
        System.out.println("Is empty after popping all: " + queue.isEmpty()); // true
    }
}
