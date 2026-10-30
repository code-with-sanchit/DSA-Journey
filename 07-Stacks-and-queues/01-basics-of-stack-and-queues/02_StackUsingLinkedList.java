class StackUsingLinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    private Node head;

    public StackUsingLinkedList() {
        head = null;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    public void pop() {
        if (head == null) {
            System.out.println("Stack Underflow");
            return;
        }
        head = head.next;
    }

    public int peek() {
        if (head == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }
    /*
     * Time Complexity: O(1) for push, pop, peek, isEmpty
     * Space Complexity: O(N)
     */

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(5);
        stack.push(10);
        System.out.println("Top element: " + stack.peek());
        stack.pop();
        System.out.println("Top after pop: " + stack.peek());
        System.out.println("Is empty: " + stack.isEmpty());
    }
}
