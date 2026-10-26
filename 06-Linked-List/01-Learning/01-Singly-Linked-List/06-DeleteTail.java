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

class DeleteTail {

    static Node optimalApproach(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node temp = head; 

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

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
        // Test Case 1: Normal List
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        System.out.println("Original List:");
        printLL(head1);
        head1 = optimalApproach(head1);
        System.out.println("After deleting tail:");
        printLL(head1);

        // Test Case 2: Single Node
        System.out.println("\nOriginal List (Single Node):");
        Node head2 = new Node(100);
        printLL(head2);
        head2 = optimalApproach(head2);
        System.out.println("After deleting tail:");
        printLL(head2);

        // Test Case 3: Empty List
        System.out.println("\nOriginal List (Empty):");
        Node head3 = null;
        printLL(head3);
        head3 = optimalApproach(head3);
        System.out.println("After deleting tail:");
        printLL(head3);

    }
}


/**
 * TC: O(N) where N is the length of the list
 * SC: O(1) because we use no extra memory
 */