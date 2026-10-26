
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


class SearchInLinkedList{

    static int optimalApproach(Node head, int target) {
        Node temp = head; 

        while (temp != null) {
            if (temp.data == target) {
                return 1;
            }
            temp = temp.next;
        }
        return 0; 
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15); 

        System.out.println("Linked List: 5 -> 10 -> 15 -> null");
        System.out.println("Search for 10: " + optimalApproach(head, 10)); // Expected: 1
        System.out.println("Search for 20: " + optimalApproach(head, 20)); // Expected: 0
    }
}