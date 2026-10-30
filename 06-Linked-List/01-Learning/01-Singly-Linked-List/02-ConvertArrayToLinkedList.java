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

class ConvertArrayToLinkedList {

    static Node optimalApproach(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node mover = head; 

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]); 
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
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
        int[] arr1 = {1, 2, 3};
        System.out.print("Input: [1, 2, 3] | Output: ");
        printLL(optimalApproach(arr1));

        int[] arr2 = {};
        System.out.print("Input: [] | Output: ");
        printLL(optimalApproach(arr2));
    }
}
