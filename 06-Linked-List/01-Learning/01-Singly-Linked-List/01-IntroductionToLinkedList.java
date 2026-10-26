
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

class IntroductionToLinkedList {

    static Node constructLL(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    static void printLL(Node head) {
        Node temp = head;
        System.out.print("Linked List: ");

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    static int getLength(Node head) {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 8};
        System.out.println("Input Array: [2, 4, 6, 8]");
        Node head1 = constructLL(arr1);
        printLL(head1);
        System.out.println("Length: " + getLength(head1));

        int[] arr2 = {10};
        System.out.println("\nInput Array: [10]");
        Node head2 = constructLL(arr2);
        printLL(head2);
        System.out.println("Length: " + getLength(head2));

        int[] arr3 = {};
        System.out.println("\nInput Array: []");
        Node head3 = constructLL(arr3);
        printLL(head3);
        System.out.println("Length: " + getLength(head3));
    }
}
