package prelim.DoublyLinkedList;

import prelim.CustomInteger;
import prelim.DoublyLinkedNode;

public class Premade_Tester {
    public static void main(String[] args) {
        MyDoublyLinkedList<CustomInteger> integers = new MyDoublyLinkedList<>();
        System.out.println("Initial Size: " + integers.getSize());

        integers.insert(new CustomInteger(1));
        integers.insert(new CustomInteger(2));
        integers.insert(new CustomInteger(3));
        integers.insert(new CustomInteger(4));
        integers.insert(new CustomInteger(5));
        integers.insert(new CustomInteger(6));
        integers.insert(new CustomInteger(7));
        integers.insert(new CustomInteger(8));
        integers.insert(new CustomInteger(9));
        integers.insert(new CustomInteger(10));
        integers.insert(new CustomInteger(11));
        integers.insert(new CustomInteger(12));

        System.out.println("Size after Numbers 1-12: " + integers.getSize());
        System.out.println("Head: " + integers.getHead());
        System.out.println("Tail: " + integers.getTail() + "\n");

        printHeadToTail(integers);
        printTailToHead(integers);

        System.out.println("\n\nDeleting the first element (1): ");
        integers.delete(new CustomInteger(1));
        System.out.println("New Head: " + integers.getHead());

        printTailToHead(integers);
        printHeadToTail(integers);

        System.out.println("\n\nDeleting the last element (12): ");
        integers.delete(new CustomInteger(12));
        System.out.println("New Tail: " + integers.getTail());

        printHeadToTail(integers);
        printTailToHead(integers);

        System.out.println("\n\nDeleting something somewhere (6): ");
        integers.delete(new CustomInteger(6));

        printHeadToTail(integers);
        printTailToHead(integers);

        System.out.println("\n\nInserting a new element (13): ");
        integers.insert(new CustomInteger(13));

        System.out.println("New tail: " + integers.getTail());
        printHeadToTail(integers);
        printTailToHead(integers);


        System.out.print("\n\nGetting the 8th element: ");
        System.out.println(integers.get(7) + "\n\n"); // index at 7

        System.out.print("Getting the index of the element 11: ");
        System.out.println(integers.search(new CustomInteger(11)));

    }


    private static void printHeadToTail(MyDoublyLinkedList<CustomInteger> integers) {
        System.out.println("\nTraversing from head to tail: ");
        DoublyLinkedNode<CustomInteger> currentNode = integers.getHeadNode();
        for (int i = 0; i < integers.getSize(); i++) {
            System.out.print(currentNode.getData() + "  ");

            currentNode = currentNode.getNext();
        }
    }

    private static void printTailToHead(MyDoublyLinkedList<CustomInteger> integers) {
        System.out.println("\nTraversing from tail to head: ");
        DoublyLinkedNode<CustomInteger> currentNode = integers.getTailNode();
        for (int i = integers.getSize() - 1; i >= 0; i--) {
            System.out.print(currentNode.getData() + "  ");

            currentNode = currentNode.getPrevious();
        }
    }
}
