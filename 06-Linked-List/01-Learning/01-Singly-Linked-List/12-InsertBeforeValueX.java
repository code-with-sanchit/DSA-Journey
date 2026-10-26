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

class InsertBeforeValueX {

    static Node optimalApproach(Node head, int valToInsert, int beforeValue) {
        if (head == null) {
            return null;
        }

        if (head.data == beforeValue) {
            return new Node(valToInsert, head);
        }
        Node temp = head;

        while (temp.next != null) {

            if (temp.next.data == beforeValue){

                Node newNode = new Node(valToInsert, temp.next);
                temp.next = newNode; 
                break;
            }

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
        // Test Case 1: Insert in the middle
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        System.out.println("Original List: 5 -> 10 -> 15 -> null");
        System.out.println("Inserting 100 before 15:");
        printLL(optimalApproach(head1, 100, 15)); // Expected: 5 -> 10 -> 100 -> 15 -> null

        // Test Case 2: Insert before the head
        Node head2 = new Node(5);
        head2.next = new Node(10);
        System.out.println("\nOriginal List: 5 -> 10 -> null");
        System.out.println("Inserting 100 before 5:");
        printLL(optimalApproach(head2, 100, 5)); // Expected: 100 -> 5 -> 10 -> null

        // Test Case 3: Target value is not in the list
        Node head3 = new Node(5);
        head3.next = new Node(10);
        System.out.println("\nOriginal List: 5 -> 10 -> null");
        System.out.println("Inserting 100 before 50 (not in list):");
        printLL(optimalApproach(head3, 100, 50)); // Expected: 5 -> 10 -> null (no change)
    }
}


/**
 * TC: O(N) in the worst case if X is at the end or not found
 * SC: O(1) because we only create one new node
 */