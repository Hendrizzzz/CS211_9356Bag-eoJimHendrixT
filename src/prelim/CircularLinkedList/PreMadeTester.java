package prelim.CircularLinkedList;

import prelim.CustomInteger;

/**
 * A test class to demonstrate the usage of MyDoublyLinkedCircularList with CustomInteger elements.
 */
public class PreMadeTester {

    /**
     * Main method that initializes a MyDoublyLinkedCircularList and performs various operations.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        MyDoublyLinkedCircularList<CustomInteger> integers = new MyDoublyLinkedCircularList<>();
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

        System.out.println("Size after 12 elements: " + integers.getSize());
        System.out.println("Head: " + integers.getHead());
        System.out.println("Tail: " + integers.getTail() + "\n");

        printHeadToTail(integers);
        printTailToHead(integers);

        System.out.println("\n\nDeleting the head (1): ");
        integers.delete(new CustomInteger(1));
        System.out.println("New Head: " + integers.getHead());

        printTailToHead(integers);
        printHeadToTail(integers);

        System.out.println("\n\nDeleting the tail (12): ");
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

        traverseListTwice(integers);


        System.out.print("\n\nGetting the 4th element: ");
        System.out.println(integers.get(3) + "\n\n"); // index at 3

        System.out.print("Getting the index of the element 9: ");
        System.out.println(integers.search(new CustomInteger(9)));

    }


    private static void printHeadToTail(MyDoublyLinkedCircularList<CustomInteger> integers) {
        Tester.traverseList(integers);
    }

    private static void printTailToHead(MyDoublyLinkedCircularList<CustomInteger> integers) {
        Tester.traverseInReverse(integers);
    }

    private static void traverseListTwice(MyDoublyLinkedCircularList<CustomInteger> integers){
        Tester.traverseListTwice(integers);
    }

} // end of the class
