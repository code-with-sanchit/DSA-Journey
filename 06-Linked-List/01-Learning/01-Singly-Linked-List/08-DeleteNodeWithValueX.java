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
        System.out.println("Deleting value 10:");
        printLL(optimalApproach(head1, 10));

        Node head2 = new Node(5);
        head2.next = new Node(10);
        System.out.println("\nOriginal List: 5 -> 10 -> null");
        System.out.println("Deleting value 5:");
        printLL(optimalApproach(head2, 5));

        Node head3 = new Node(5);
        System.out.println("\nOriginal List: 5 -> null");
        System.out.println("Deleting value 100:");
        printLL(optimalApproach(head3, 100));
    }
}
