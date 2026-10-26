class Node {
    int data; 
    Node next; 
    
    Node(int data, Node next) {
        this.data = data; 
        this.next = next;
    }

    Node(int data) {
        this.data = data; 
        this.next = null;
    }
}

class DeleteNodeWithValueX {

    static Node optimalApproach(Node head, int val) {
        if (head == null) {
            return null;
        }

        if (head.data == val) {
            return head.next;
        }

        Node temp = head; 
        Node prev = null;

        while (temp != null) {

            if (temp.data == val) {
                prev.next = prev.next.next;
                break;
            }

            prev = temp; 
            temp = temp.next;
        }

        return head;
    }

    static void printLL(Node head) {
        Node temp = head; 
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test Case 1: Value is in the middle
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        System.out.println("Original List: 5 -> 10 -> 15 -> null");
        System.out.println("Deleting value 10:");
        printLL(optimalApproach(head1, 10)); // Expected: 5 -> 15 -> null

        // Test Case 2: Value is at the head
        Node head2 = new Node(5);
        head2.next = new Node(10);
        System.out.println("\nOriginal List: 5 -> 10 -> null");
        System.out.println("Deleting value 5:");
        printLL(optimalApproach(head2, 5)); // Expected: 10 -> null

        // Test Case 3: Value is not in the list
        Node head3 = new Node(5);
        System.out.println("\nOriginal List: 5 -> null");
        System.out.println("Deleting value 100:");
        printLL(optimalApproach(head3, 100)); // Expected: 5 -> null
    }
}


/**
 * TC: O(N) in the worst case if the value is at the end or not found
 * SC: O(1) because we use no extra memory
 */
