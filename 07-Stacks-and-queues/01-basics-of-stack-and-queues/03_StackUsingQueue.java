import java.util.Queue; 
import java.util.LinkedList;

class StackUsingQueue {

    private Queue<Integer> queue; 

    public StackUsingQueue() {
        queue = new LinkedList<>(); 
    }

    public void push(int x) {
        queue.add(x);

        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove()); 
        }
    }

    public void pop() {
        if (queue.isEmpty()) {
            System.out.println("Stack Underflow"); 
            return;
        }
        queue.remove(); 
    }

    public int peek() {
        if (queue.isEmpty()) {
            System.out.println("Stack is empty"); 
            return -1; 
        }
        return queue.peek(); 
    }

    public boolean isEmpty() {
        return queue.isEmpty(); 
    }
    /*
     * Time Complexity: O(N) for push, O(1) for pop, peek, isEmpty
     * Space Complexity: O(N)
     */

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue(); 
        stack.push(5); 
        stack.push(10); 
        System.out.println("Top element: " + stack.peek()); 
        stack.pop(); 
        System.out.println("Top after pop: " + stack.peek()); 
        System.out.println("Is empty: " + stack.isEmpty()); 
    }
}
