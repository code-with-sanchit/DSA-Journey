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

class InsertAtTail {

    static Node optimalApproach(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }

        Node temp = head; 

        while (temp.next != null) {
            temp = temp.next;
        }

        Node newNode = new Node(val); 
        temp.next = newNode; 

        return head;
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    static void printLL(Node head) {
        Node temp = head; 

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        System.out.println("Original List: 5 -> 10 -> 15 -> null");
        System.out.println("Inserting 20 at Tail:");
        printLL(optimalApproach(head1, 20)); 

        Node head2 = null;
        System.out.println("\nOriginal List (Empty): null");
        System.out.println("Inserting 100 at Tail:");
        printLL(optimalApproach(head2, 100)); 
    }
}
