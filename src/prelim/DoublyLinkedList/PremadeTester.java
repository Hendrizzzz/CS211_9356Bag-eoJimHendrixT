package prelim.DoublyLinkedList;

import prelim.DoublyLinkedNode;


/**
 * A premade tester for the MyDoublyLinkedList class.
 * Demonstrates insertion, deletion, and traversal of a doubly linked list.
 */
public class PremadeTester {
    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> integers = new MyDoublyLinkedList<>();
        System.out.println("Initial Size: " + integers.getSize());

        integers.insert(1);
        integers.insert(2);
        integers.insert(3);
        integers.insert(4);
        integers.insert(5);
        integers.insert(6);
        integers.insert(7);
        integers.insert(8);
        integers.insert(9);
        integers.insert(10);
        integers.insert(11);
        integers.insert(12);

        System.out.println("Size after Numbers 1-12: " + integers.getSize());
        System.out.println("Head: " + integers.getHead());
        System.out.println("Tail: " + integers.getTail() + "\n");

        printHeadToTail(integers);
        printTailToHead(integers);

        System.out.println("\n\nDeleting the first element (1): ");
        integers.delete(1);
        System.out.println("New Head: " + integers.getHead());

        printTailToHead(integers);
        printHeadToTail(integers);

        System.out.println("\n\nDeleting the last element (12): ");
        integers.delete(12);
        System.out.println("New Tail: " + integers.getTail());

        printHeadToTail(integers);
        printTailToHead(integers);

        System.out.println("\n\nDeleting something somewhere (6): ");
        integers.delete(6);

        printHeadToTail(integers);
        printTailToHead(integers);

        System.out.println("\n\nInserting a new element (13): ");
        integers.insert(13);

        System.out.println("New tail: " + integers.getTail());
        printHeadToTail(integers);
        printTailToHead(integers);


        System.out.print("\n\nGetting the 8th element: ");
        System.out.println(integers.get(7) + "\n\n"); // index at 7

        System.out.print("Getting the index of the element 11: ");
        System.out.println(integers.search(11));

    }


    private static void printHeadToTail(MyDoublyLinkedList<Integer> integers) {
        System.out.println("\nTraversing from head to tail: ");
        DoublyLinkedNode<Integer> currentNode = integers.getHeadNode();
        for (int i = 0; i < integers.getSize(); i++) {
            System.out.print(currentNode.getData() + "  ");

            currentNode = currentNode.getNext();
        }
    }

    private static void printTailToHead(MyDoublyLinkedList<Integer> integers) {
        System.out.println("\nTraversing from tail to head: ");
        DoublyLinkedNode<Integer> currentNode = integers.getTailNode();
        for (int i = integers.getSize() - 1; i >= 0; i--) {
            System.out.print(currentNode.getData() + "  ");

            currentNode = currentNode.getPrevious();
        }
    }
}
