/**
 * Problem: Implement a Queue Using an Array 
 * Difficulty: Easy 
 * Pattern: Queue Implementation 
 * Approach: 
 *    Use a fixed-size array and variables 'front', 'rear', and 'size' to implement a circular queue.
 *    Using a circular queue avoids shifting elements, making both enqueue and dequeue O(1).
 * 
 * Time Complexity: O(1) for enqueue, dequeue, peek, isEmpty
 * Space Complexity: O(N) - fixed size array
 */

class QueueUsingArray {
    private int[] arr; 
    private int front; 
    private int rear; 
    private int size;
    private int capacity; 

    public QueueUsingArray(int cap) {
        capacity = cap; 
        arr = new int[capacity]; 
        front = 0; 
        rear = 0;
        size = 0;
    }

    // Add element to the rear of the queue
    public void enqueue(int x) {
        if (size == capacity) {
            System.out.println("Queue Overflow");
            return;
        }
        arr[rear] = x; 
        rear = (rear + 1) % capacity; 
        size++;
    }

    // Remove element from the front of the queue
    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow");
            return;
        }
        front = (front + 1) % capacity; 
        size--;
    }

    // Look at the front element without removing it
    public int peek() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1; 
        }
        return arr[front];
    }

    // Check if queue has no elements
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(5);
        queue.enqueue(5); 
        queue.enqueue(10); 
        queue.enqueue(15); 
        System.out.println("Front element: " + queue.peek());  // 5
        queue.dequeue(); 
        System.out.println("Front after dequeue: " + queue.peek());  // 10
        System.out.println("Is Empty: " + queue.isEmpty()); // false
    }
}
