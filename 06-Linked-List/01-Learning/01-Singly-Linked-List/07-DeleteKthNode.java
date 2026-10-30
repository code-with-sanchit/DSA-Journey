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
    /*
     * Time Complexity: O(K) where worst case is O(N)
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
        System.out.println("Deleting K = 2:");
        printLL(optimalApproach(head1, 2));

        Node head2 = new Node(5);
        head2.next = new Node(10);
        System.out.println("\nOriginal List: 5 -> 10 -> null");
        System.out.println("Deleting K = 1:");
        printLL(optimalApproach(head2, 1));

        Node head3 = new Node(5);
        System.out.println("\nOriginal List: 5 -> null");
        System.out.println("Deleting K = 5:");
        printLL(optimalApproach(head3, 5));
    }
}
