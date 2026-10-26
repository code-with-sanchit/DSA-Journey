class Node {
    int data;
    Node next;
    Node(int data, Node next) { this.data = data; this.next = next; }
    Node(int data) { this.data = data; this.next = null; }
}

class InsertAtKthPosition {

    static Node optimalApproach(Node head, int val, int k) {
        // Edge Case: If the list is completely empty
        if (head == null) {
            if (k == 1) {
                return new Node(val); // Insert at position 1 works
            } else {
                return null; // Cannot insert at position > 1 in an empty list
            }
        }
        
        // Edge Case: Inserting exactly at the head
        if (k == 1) {
            return new Node(val, head);
        }
        
        int count = 0;
        Node temp = head;
        
        // Walk through the list
        while (temp != null) {
            count++;
            
            // Stop exactly one node BEFORE the target position
            if (count == k - 1) {
                // 1. Create new node and link it to the rest of the chain
                Node newNode = new Node(val, temp.next);
                // 2. Connect the current node to the new node
                temp.next = newNode;
                break; // Stop looking
            }
            
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
        // Test Case 1: Insert in the middle (K = 2)
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        System.out.println("Original List: 5 -> 10 -> 15 -> null");
        System.out.println("Inserting 100 at K = 2:");
        printLL(optimalApproach(head1, 100, 2)); // Expected: 5 -> 100 -> 10 -> 15 -> null

        // Test Case 2: Insert at the head (K = 1)
        Node head2 = new Node(5);
        head2.next = new Node(10);
        System.out.println("\nOriginal List: 5 -> 10 -> null");
        System.out.println("Inserting 100 at K = 1:");
        printLL(optimalApproach(head2, 100, 1)); // Expected: 100 -> 5 -> 10 -> null

        // Test Case 3: K is larger than the list (Edge Case)
        Node head3 = new Node(5);
        System.out.println("\nOriginal List: 5 -> null");
        System.out.println("Inserting 100 at K = 5:");
        printLL(optimalApproach(head3, 100, 5)); // Expected: 5 -> null (no change)
    }
}

/**
 * * TC: O(K) which is O(N) in the worst case if K is at the end
 * SC: O(1) because we only create one new node
 */