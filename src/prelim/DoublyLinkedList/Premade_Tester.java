package prelim.DoublyLinkedList;

import prelim.CustomInteger;
import prelim.DoublyLinkedNode;

public class Premade_Tester {
    public static void main(String[] args) {
        // Create a new doubly linked list
        MyDoublyLinkedList<CustomInteger> integers = new MyDoublyLinkedList<>();
        System.out.println("Initial Size: " + integers.getSize());


        // Insert elements 1 to 12
        for (int i = 1; i <= 12; i++) {
            integers.insert(new CustomInteger(i));
        }

        printBorder();
        // Display list details
        System.out.println("Size after inserting numbers 1-12: " + integers.getSize());
        printList(integers);

        printBorder();
        // Delete the first element
        System.out.println("\nDeleting the first element (1): ");
        integers.delete(new CustomInteger(1));
        printList(integers);

        printBorder();
        // Delete the last element
        System.out.println("\nDeleting the last element (12): ");
        integers.delete(new CustomInteger(12));
        printList(integers);

        printBorder();
        // Delete an element in the middle
        System.out.println("\nDeleting an element somewhere in the middle (6): ");
        integers.delete(new CustomInteger(6));
        printList(integers);

        printBorder();
        // Insert a new element at the end
        System.out.println("\nInserting a new element (13): ");
        integers.insert(new CustomInteger(13));
        printList(integers);

        printBorder();
        // Retrieve the 8th element
        System.out.println("\nGetting the 8th element: ");
        System.out.println(integers.get(7)); // index at 7

        printBorder();
        // Get the index of an element
        System.out.println("\nGetting the index of the element 11: ");
        System.out.println(integers.search(new CustomInteger(11)));

        printBorder();
        // Edge case: Deleting all elements
        System.out.println("\nDeleting all elements (Tail):");
        while (integers.getSize() > 0) {
            System.out.println(integers.getTail() + " is deleted");
            integers.delete(integers.getTail()); // Delete from the tail to demonstrate deletion in reverse order
            printList(integers);
            printBorder();
        }


        printBorder();
        // Edge case: Trying to delete from an empty list
        System.out.println("\nAttempting to delete from an empty list:");
        boolean result = integers.delete(new CustomInteger(1));
        System.out.println("Delete result: " + result);
    }

    private static void printBorder() {
        System.out.println("======================================================================");
    }

    // print the list from head to tail and tail to head
    private static void printList(MyDoublyLinkedList<CustomInteger> integers) {
        System.out.println("Head: " + integers.getHead());
        System.out.println("Tail: " + integers.getTail());
        printHeadToTail(integers);
        printTailToHead(integers);
    }

    // Print the list from head to tail
    private static void printHeadToTail(MyDoublyLinkedList<CustomInteger> integers) {
        System.out.print("\nTraversing from head to tail: ");
        DoublyLinkedNode<CustomInteger> currentNode = integers.getHeadNode();
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    // Print the list from tail to head
    private static void printTailToHead(MyDoublyLinkedList<CustomInteger> integers) {
        System.out.print("\nTraversing from tail to head: ");
        DoublyLinkedNode<CustomInteger> currentNode = integers.getTailNode();
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getPrevious();
        }
        System.out.println();
    }
}
