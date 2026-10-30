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
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    static void printLL(Node head) {
        Node temp = head; 
        while (temp != null) {
            System.out.println(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        System.out.println("Original List: 5 -> 10 -> 15 -> null");
        System.out.println("Inserting 100 before 15:");
        printLL(optimalApproach(head1, 100, 15));

        Node head2 = new Node(5);
        head2.next = new Node(10);
        System.out.println("\nOriginal List: 5 -> 10 -> null");
        System.out.println("Inserting 100 before 5:");
        printLL(optimalApproach(head2, 100, 5));

        Node head3 = new Node(5);
        head3.next = new Node(10);
        System.out.println("\nOriginal List: 5 -> 10 -> null");
        System.out.println("Inserting 100 before 50 (not in list):");
        printLL(optimalApproach(head3, 100, 50));
    }
}
