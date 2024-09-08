package prelim.CircularLinkedList.PureTesterClasses;

import prelim.CircularLinkedList.MyDoublyLinkedCircularList;
import prelim.DoublyLinkedNode;

public class PreMadeTester {
    public static void main(String[] args) {
        MyDoublyLinkedCircularList<Integer> integers = new MyDoublyLinkedCircularList<>();
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

        System.out.println("Size after 12 elements: " + integers.getSize());
        System.out.println("Head: " + integers.getHead());
        System.out.println("Tail: " + integers.getTail() + "\n");

        printHeadToTail(integers);
        printTailToHead(integers);

        System.out.println("\n\nDeleting the head (1): ");
        integers.delete(1);
        System.out.println("New Head: " + integers.getHead());

        printTailToHead(integers);
        printHeadToTail(integers);

        System.out.println("\n\nDeleting the tail (12): ");
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

        traverseListTwice(integers);


        System.out.print("\n\nGetting the 4th element: ");
        System.out.println(integers.get(3) + "\n\n"); // index at 3

        System.out.print("Getting the index of the element 9: ");
        System.out.println(integers.search(9));

    }


    private static void printHeadToTail(MyDoublyLinkedCircularList<Integer> integers) {
        System.out.println("\nTraversing from head to tail: ");
        DoublyLinkedNode<Integer> currentNode = integers.getHead();
        for (int i = 0; i < integers.getSize(); i++) {
            System.out.print(currentNode.getData() + "  ");

            currentNode = currentNode.getNext();
        }
    }

    private static void printTailToHead(MyDoublyLinkedCircularList<Integer> integers) {
        System.out.println("\nTraversing from tail to head: ");
        DoublyLinkedNode<Integer> currentNode = integers.getTail();
        for (int i = integers.getSize() - 1; i >= 0; i--) {
            System.out.print(currentNode.getData() + "  ");

            currentNode = currentNode.getPrevious();
        }
    }

    private static void traverseListTwice(MyDoublyLinkedCircularList<Integer> integers){
        System.out.println("\nTraversing the List Twice: ");
        DoublyLinkedNode<Integer> currentNode = integers.getHead();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < integers.getSize(); j++) {
                System.out.print(currentNode.getData() + "  ");

                currentNode = currentNode.getNext();
            }
        }
    }

} // end of the class
