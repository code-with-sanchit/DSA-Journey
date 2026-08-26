/**
 * Problem: Implement a Queue using a Linked List
 * Difficulty: Easy
 * Pattern: Queue Implementation
 * Approach: Use a singly linked list. Keep track of both 'front' and 'rear' pointers.
 *           enqueue() adds elements at the 'rear' (tail) of the list.
 *           dequeue() removes elements from the 'front' (head) of the list.
 *           Both operations run in O(1) time complexity.
 * 
 * Time Complexity: O(1) for enqueue, dequeue, peek, isEmpty
 * Space Complexity: O(N) - grows dynamically
 */

class QueueUsingLinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    private Node front;
    private Node rear;

    public QueueUsingLinkedList() {
        front = null;
        rear = null;
    }

    // Add element to the rear of the queue
    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (rear == null) {
            front = newNode;
            rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Remove element from the front of the queue
    public void dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
            return;
        }
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    // Look at the front element without removing it
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    // Check if queue has no elements
    public boolean isEmpty() {
        return front == null;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(5);
        queue.enqueue(10);
        System.out.println("Front element: " + queue.peek()); // 5
        queue.dequeue();
        System.out.println("Front after dequeue: " + queue.peek()); // 10
        System.out.println("Is empty: " + queue.isEmpty()); // false
    }
}
