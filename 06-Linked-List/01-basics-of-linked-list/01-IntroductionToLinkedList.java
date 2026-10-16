/**
 * Topic: Introduction to Linked List 
 * Pattern: Linked List Basics
 * 
 * Approach: 
 * 1. Create a Node class that holds data and a link (next) to the next node. 
 * 2. Convert an array into an linked list by chaining nodes one by one. 
 * 3. Traverse the list by starting at head and moving through next until null.
 * 4. Length and Search are just traversals with a small extra job.
 * 
 * Time Complexity: 
 *      Build: 0(n) , Traverse: 0(n) , Length = 0(n) , Search = 0(n)
 * Space Complexity: 0(n) for notes of the list 
 *                   0(1) extra for traversal
 */

class IntroductionToLinkedList {
    static class Node {
        int data; 
        Node next; 

        Node (int data) {
            this.data = data; 
            this.next = null;
        }
        Node(int data, Node next) {
            this.data = data; 
            this.next = next;
        }
    }

    // Build a linked list from an array and returns the head 
    static Node arrayToLinkedList(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);    // first node becomes head
        Node mover = head;               // mover walks along the list as we add nodes 

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]); 
            mover.next = temp;   // attach new node at the end 
            mover = temp;       // move forward 
        }
        return head; 
    }

    // Print all nodes from head to the end 
    static void printList(Node head) {
        Node temp = head; 
        while (temp!= null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Count how many nodes are present 
    static int lengthOfList(Node head) {
        int count = 0; 
        Node temp = head; 
        while (temp != null) {
            count ++; 
            temp = temp.next;
        }
        return count; 
    }

    // Check if a value exists in the list 
    static boolean searchInList(Node head, int value) {
        Node temp = head; 
        while (temp != null) {
            if (temp.data == value) return true; 
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,8,7}; 

        Node head = arrayToLinkedList(arr);

        printList(head);   // 2 5 8 7 
        System.out.println(lengthOfList(head));  // 4
        System.out.println(searchInList(head,8));  // true
        System.out.println(searchInList(head,10));  // false
    }
}