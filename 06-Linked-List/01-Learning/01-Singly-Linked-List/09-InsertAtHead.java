class Node {
    int data; 
    Node next; 
    Node (int data, Node next) {
        this.data = data; 
        this.next = next; 
    }
    Node(int data) {
        this.data = data; 
        this.next = null;
    }
}

class InsertAtHead {

    static Node optimalApproach(Node head, int val) {
        
        Node temp = new Node(val, head);
        return temp;
    }

    static void printLL(Node head) {
        Node temp = head; 
        while (temp != null) {
            System.out.println(temp.data + " -> ");
            temp = temp.next; 
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test Case 1: Normal List
        Node head1 = new Node(10);
        head1.next = new Node(15);
        System.out.println("Original List: 10 -> 15 -> null");
        System.out.println("Inserting 5 at the head:");
        printLL(optimalApproach(head1, 5)); // Expected: 5 -> 10 -> 15 -> null

        // Test Case 2: Empty List (Edge Case)
        Node head2 = null;
        System.out.println("\nOriginal List: null");
        System.out.println("Inserting 100 at the head:");
        printLL(optimalApproach(head2, 100)); // Expected: 100 -> null
    }
}


/**
 * TC: O(1) because we only change one pointer
 * SC: O(1) because we only create one new node
 */