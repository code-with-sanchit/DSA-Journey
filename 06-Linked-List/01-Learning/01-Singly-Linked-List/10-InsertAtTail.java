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

class InsertAtTail {

    static Node optimalApproach(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(val);

        return head; 
    }

    static void printLL(Node head) {
        Node temp = head; 
        while (temp != null) {
            System.out.println(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test Case 1: Normal List
        Node head1 = new Node(5);
        head1.next = new Node(10);
        System.out.println("Original List: 5 -> 10 -> null");
        System.out.println("Inserting 15 at the tail:");
        printLL(optimalApproach(head1, 15)); // Expected: 5 -> 10 -> 15 -> null

        // Test Case 2: Empty List (Edge Case)
        Node head2 = null;
        System.out.println("\nOriginal List: null");
        System.out.println("Inserting 100 at the tail:");
        printLL(optimalApproach(head2, 100)); // Expected: 100 -> null
    }
}

/**
 * TC: O(N) because we have to walk to the end of the list
 * SC: O(1) because we only create one new node
 */