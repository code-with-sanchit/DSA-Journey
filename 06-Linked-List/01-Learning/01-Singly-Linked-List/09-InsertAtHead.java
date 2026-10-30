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

class InsertAtHead {

    static Node optimalApproach(Node head, int val) {
        Node temp = new Node(val, head); 
        return temp; 
    }
    /*
     * Time Complexity: O(1)
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
        System.out.println("Original List: 5 -> 10 -> null");
        System.out.println("Inserting 1 at Head:");
        printLL(optimalApproach(head1, 1)); 

        Node head2 = null; 
        System.out.println("\nOriginal List (Empty): null");
        System.out.println("Inserting 100 at Head:");
        printLL(optimalApproach(head2, 100)); 
    }
}
