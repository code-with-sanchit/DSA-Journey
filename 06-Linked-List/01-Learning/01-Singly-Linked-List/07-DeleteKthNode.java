class Node {
    int data; 
    Node next; 
    Node (int data, Node next) {
        this.data = data; 
        this.next = next;
    }

    Node (int data) {
        this.data = data; 
        this.next = null;
    }
}

class DeleteKthNode {

    static Node optimalApproach(Node head, int k) {
        if (head == null) {
            return null;
        }

        if (k == 1){
            return head.next;
        }

        int count = 0; 
        Node temp = head; 
        Node prev = null;

        while (temp != null) {
            count++;

            if (count == k) {
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
            System.out.println(temp.data + " -> ");
            temp = temp.next; 
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test Case 1: Delete middle node (K = 2)
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        System.out.println("Original List: 5 -> 10 -> 15 -> null");
        System.out.println("Deleting K = 2:");
        printLL(optimalApproach(head1, 2)); // Expected: 5 -> 15 -> null

        // Test Case 2: Delete first node (K = 1)
        Node head2 = new Node(5);
        head2.next = new Node(10);
        System.out.println("\nOriginal List: 5 -> 10 -> null");
        System.out.println("Deleting K = 1:");
        printLL(optimalApproach(head2, 1)); // Expected: 10 -> null

        // Test Case 3: K is larger than the list length (Edge Case)
        Node head3 = new Node(5);
        System.out.println("\nOriginal List: 5 -> null");
        System.out.println("Deleting K = 5:");
        printLL(optimalApproach(head3, 5)); // Expected: 5 -> null (no change)
    }
}


/**
 * TC: O(K) which in the worst case is O(N) if K is the last node
 * SC: O(1) because we use no extra memory
 */
