package prelim.CircularLinkedList;

import prelim.CustomInteger;
import prelim.DoublyLinkedNode;

import java.util.Scanner;

/**
 * Tester class for interacting with MyDoublyLinkedCircularList via console.
 * Supports adding, deleting, searching, and traversing elements in the list.
 */
public class Tester {
    protected static final MyDoublyLinkedCircularList<CustomInteger> integers = new MyDoublyLinkedCircularList<>();


    /**
     * Main method to run the interactive console program.
     *
     * @param args command-line arguments (not used)
     */
    public void run() {
        boolean exploring = true;
        while (exploring) {
            showOptions();
            int choice = readInt(1, 11);
            switch (choice) {
                case 1 -> addInteger();
                case 2 -> deleteInteger();
                case 3 -> traverseList(integers);
                case 4 -> traverseInReverse(integers);
                case 5 -> traverseListTwice(integers); // To show the connection of the head and tail nodes
                case 6 -> searchIndexElement();
                case 7 -> getElementAtIndex();
                case 8 -> System.out.println("\nHead : " + integers.getHead());
                case 9 -> System.out.println("\nTail : " + integers.getTail());
                case 10 -> System.out.println("\nSize: " + integers.getSize());
                case 11 -> exploring = false;
            }
            System.out.println();
        }
    }

    private void addInteger() {
        System.out.print("How many integers to add: ");
        int size = readInt(1, 100);
        int i = 0;
        while (i < size) {
            System.out.print("Integer to Add (index " + i + "): ");
            int integer = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            integers.insert(new CustomInteger(integer));
            i++;
        }
    }

    private void deleteInteger() {
        System.out.print("Integer to Delete: ");
        int integer = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (integers.delete(new CustomInteger(integer))) {
            System.out.println("Deletion Success.");
        } else {
            System.out.println(integer + " is not in the list.");
        }
    }

    /**
     * Traverses the list from head to tail and prints the elements.
     *
     * @param integers the circular doubly linked list to traverse
     */
    <T> void traverseList(MyDoublyLinkedCircularList<CustomInteger> integers) {
        if (integers.getHeadNode() == null) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("\nTraversing from head to tail:");
        StringBuilder output = new StringBuilder();
        output.append("t <- Head -> ");
        DoublyLinkedNode<T> currentNode = (DoublyLinkedNode<T>) integers.getHeadNode();
        do {
            output.append(currentNode.getData());

            // Check if the next node is not the head (end of the loop)
            if (!currentNode.getNext().equals(integers.getHeadNode())) {
                output.append("  <-->  ");
            }

            currentNode = currentNode.getNext();
        } while (!currentNode.equals(integers.getHeadNode())); // Stop when we loop back to the head

        output.append(" <- Tail -> h");
        System.out.println(output.toString());
    }


    /**
     * Traverses the list from tail to head and prints the elements.
     *
     * @param integers the circular doubly linked list to traverse in reverse
     */
    <T> void traverseInReverse(MyDoublyLinkedCircularList<CustomInteger> integers) {
        if (integers.getTailNode() == null) {
            System.out.println("The list is empty.");
            return;
        }

        StringBuilder output = new StringBuilder();
        output.append("h <- Tail -> ");
        DoublyLinkedNode<T> currentNode = (DoublyLinkedNode<T>) integers.getTailNode();

        do {
            output.append(currentNode.getData());

            // Check if the previous node is not the tail (end of the loop)
            if (!currentNode.getPrevious().equals(integers.getTailNode())) {
                output.append("  <-->  ");
            }

            currentNode = currentNode.getPrevious();
        } while (!currentNode.equals(integers.getTailNode())); // Stop when we loop back to the tail

        output.append(" <- Head -> t");
        System.out.println(output.toString());
    }


    /**
     * Traverses the list twice, printing each element.
     *
     * @param integers the circular doubly linked list to traverse
     */
    <T> void traverseListTwice(MyDoublyLinkedCircularList<CustomInteger> integers) {
        if (integers.getHeadNode() == null) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("\nTraversing the List Twice:");
        DoublyLinkedNode<T> currentNode = (DoublyLinkedNode<T>) integers.getHeadNode();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < integers.getSize(); j++) {
                System.out.print(currentNode.getData() + " <--> ");
                currentNode = currentNode.getNext();
            }
        }
        System.out.println("(End of traversal)");
    }

    private void searchIndexElement() {
        System.out.print("Enter the integer to search (returns the index): ");
        int integerToSearch = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        int index = integers.search(new CustomInteger(integerToSearch));

        if (index == -1) {
            System.out.println("The integer is not in the list.");
        } else {
            System.out.println("The integer " + integerToSearch + " is found at index " + index);
        }
    }

    private void getElementAtIndex() {
        System.out.print("Enter the index: ");
        int index = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        try {
            CustomInteger result = integers.get(index);
            System.out.println("The number at index " + index + " is " + result);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no index " + index + " yet in the list.");
        }
    }

    private int readInt(int min, int max) {
        Scanner kInput = new Scanner(System.in);
        while (true) {
            try {
                int choice = Integer.parseInt(kInput.nextLine());
                if (choice < min || choice > max) {
                    System.out.println("Invalid: Must be " + min + " to " + max + " only.");
                    continue;
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    private void showOptions() {
        System.out.println("""
                MY CIRCULAR DOUBLY-LINKEDLIST
                1. Add integer
                2. Delete integer
                3. Show List
                4. Traverse List Tail to Head
                5. Traverse LinkedList twice
                6. Search for element's position
                7. Get element at index
                8. View Head
                9. View Tail
                10. Get Size
                11. Quit
                """);
    }

} // end of the class
