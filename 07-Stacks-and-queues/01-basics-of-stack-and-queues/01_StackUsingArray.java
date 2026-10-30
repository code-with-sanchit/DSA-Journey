class StackUsingArray {
    private int[] arr; 
    private int top; 
    private int capacity; 

    public StackUsingArray(int size) {
        arr = new int[size]; 
        capacity = size; 
        top = -1;
    }

    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++; 
        arr[top] = x;
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return;
        }
        top--;
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1; 
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
    /*
     * Time Complexity: O(1) for push, pop, peek, isEmpty
     * Space Complexity: O(N)
     */

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);
        stack.push(5); 
        stack.push(10); 
        stack.push(15); 
        System.out.println("Top element: "+ stack.peek());
        stack.pop(); 
        System.out.println("Top after pop: " + stack.peek());
        System.out.println("Is Empty: " + stack.isEmpty());
    }
}
