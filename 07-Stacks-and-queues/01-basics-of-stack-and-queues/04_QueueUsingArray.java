class QueueUsingArray {
    private int[] arr; 
    private int front; 
    private int rear; 
    private int count; 
    private int capacity; 

    public QueueUsingArray(int size) {
        arr = new int[size]; 
        capacity = size; 
        front = 0; 
        rear = 0; 
        count = 0; 
    }

    public void enqueue(int x) {
        if (count == capacity) {
            System.out.println("Queue Overflow"); 
            return; 
        }
        arr[rear % capacity] = x; 
        rear++; 
        count++; 
    }

    public void dequeue() {
        if (count == 0) {
            System.out.println("Queue Underflow"); 
            return; 
        }
        front++; 
        count--; 
    }

    public int peek() {
        if (count == 0) {
            System.out.println("Queue is Empty"); 
            return -1; 
        }
        return arr[front % capacity]; 
    }

    public boolean isEmpty() {
        return count == 0; 
    }
    /*
     * Time Complexity: O(1) for enqueue, dequeue, peek, isEmpty
     * Space Complexity: O(N)
     */

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(5); 
        queue.enqueue(5); 
        queue.enqueue(10); 
        queue.enqueue(15); 
        System.out.println("Front element: " + queue.peek()); 
        queue.dequeue(); 
        System.out.println("Front after dequeue: " + queue.peek()); 
        System.out.println("Is empty: " + queue.isEmpty()); 
    }
}
