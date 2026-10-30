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

class InsertAtKthPosition {

    static Node optimalApproach(Node head, int val, int k) {
        if (head == null) {
            if (k == 1) {
                return new Node(val);
            } else {
                return null;
            }
        }
        
        if (k == 1) {
            return new Node(val, head);
        }
        
        int count = 0;
        Node temp = head;
        
        while (temp != null) {
            count++;
            
            if (count == k - 1) {
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                break;
            }
            
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
        System.out.println("Inserting 100 at K = 2:");
        printLL(optimalApproach(head1, 100, 2));

        Node head2 = new Node(5);
        head2.next = new Node(10);
        System.out.println("\nOriginal List: 5 -> 10 -> null");
        System.out.println("Inserting 100 at K = 1:");
        printLL(optimalApproach(head2, 100, 1));

        Node head3 = new Node(5);
        System.out.println("\nOriginal List: 5 -> null");
        System.out.println("Inserting 100 at K = 5:");
        printLL(optimalApproach(head3, 100, 5));
    }
}
