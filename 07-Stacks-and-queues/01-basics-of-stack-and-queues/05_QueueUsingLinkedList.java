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

    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
    /*
     * Time Complexity: O(1) for enqueue, dequeue, peek, isEmpty
     * Space Complexity: O(N)
     */

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(5);
        queue.enqueue(10);
        System.out.println("Front element: " + queue.peek());
        queue.dequeue();
        System.out.println("Front after dequeue: " + queue.peek());
        System.out.println("Is empty: " + queue.isEmpty());
    }
}
