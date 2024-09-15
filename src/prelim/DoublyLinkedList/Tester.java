package prelim.DoublyLinkedList;

import prelim.CustomInteger;
import prelim.DoublyLinkedNode;

import java.util.Scanner;


/**
 * Tester class for MyDoublyLinkedList with operations such as adding, deleting, and traversing a list of CustomIntegers.
 */
public class Tester {
    private static final MyDoublyLinkedList<CustomInteger> integers = new MyDoublyLinkedList<>();

    public void run() {
        boolean exploring = true;
        while (exploring) {
            showOptions();
            int choice = readInt(1,10);
            switch (choice) {
                case 1 -> addInteger();
                case 2 -> deleteInteger();
                case 3 -> traverseList();
                case 4 -> traverseInReverse();
                case 5 -> searchIndexElement();
                case 6 -> getElementAtIndex();
                case 7 -> System.out.println("\nHead: " + integers.getHead());
                case 8 -> System.out.println("\nTail: " + integers.getTail());
                case 9 -> System.out.println("\nSize: " + integers.getSize());
                case 10 -> exploring = false;
            }
            System.out.println();
        }
    }


    /**
     * Adds a specified number of integers to the list.
     */
    private void addInteger() {
        System.out.println("\nOption 1: (Add Integer)");
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

    /**
     * Deletes an integer from the list.
     */
    private void deleteInteger() {
        System.out.println("\nOption 2: (Delete Integer)");
        System.out.print("Integer to Delete: ");
        int integer = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (integers.delete(new CustomInteger(integer)))
            System.out.println("Deletion Success. ");
        else
            System.out.println(integer + " is not in the list. ");
    }


    /**
     * Traverses and displays the list from head to tail.
     */
    private void traverseList() {
        System.out.println("\nOption 3: View List");
        System.out.println("Traversing from head to tail:");
        DoublyLinkedNode<CustomInteger> currentNode = integers.getHeadNode();

        if (currentNode == null) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.print("Head -> ");

        do {
            System.out.print(currentNode.getData());
            if (currentNode.getNext() != null) {
                System.out.print(" <--> ");
            }
            currentNode = currentNode.getNext();
        } while (currentNode != null && currentNode != integers.getHeadNode());

        System.out.println(" <- Tail");
    }


    /**
     * Traverses and displays the list from tail to head.
     */
    private void traverseInReverse() {
        System.out.println("\nOption 4: View List in Reverse");
        System.out.println("Traversing from tail to head:");
        DoublyLinkedNode<CustomInteger> currentNode = integers.getTailNode();

        if (currentNode == null) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.print("Tail -> ");

        do {
            System.out.print(currentNode.getData());

            if (currentNode.getPrevious() != null) {
                System.out.print(" <--> ");
            }
            currentNode = currentNode.getPrevious();

        } while (currentNode != null && currentNode != integers.getTailNode());
        System.out.println(" <- Head");
    }


    /**
     * Searches for an integer in the list and displays its index.
     */
    private void searchIndexElement() {
        System.out.println("Option 5 : (View Index)");
        System.out.print("Enter the integer to search (returns the index): ");
        int integerToSearch = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        int index = integers.search(new CustomInteger(integerToSearch));

        if (index == -1)
            System.out.println("The integer is not in the list. ");
        else
            System.out.println("The integer " + integerToSearch + " is found at index " + index);
    }


    /**
     * Retrieves and displays the integer at a specified index.
     */
    private void getElementAtIndex() {
        System.out.println("Option 6 : (Search Element)");
        System.out.print("Enter the index: ");
        int index = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        try {
            CustomInteger result = integers.get(index);
            System.out.println("The number at index " + index + " is " + result);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no index " + index + " yet in the list. ");
        }

    }


    /**
     * Reads an integer input from the user within a specified range.
     *
     * @param min the minimum valid value
     * @param max the maximum valid value
     * @return the user input as an integer
     */
    private int readInt(int min, int max) {
        Scanner kInput = new Scanner(System.in);
        while (true) {
            try  {
                int choice = Integer.parseInt(kInput.nextLine());
                if (choice < min || choice > max) {
                    System.out.println("Invalid: Must be " + min + " to " + max + " only. ");
                    continue;
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. ");
            }
        }
    }

    private void showOptions() {
        System.out.println("""
                MY DOUBLY-LINKEDLIST
                1. Add integer
                2. Delete integer
                3. Show List
                4. Traverse List Tail to Head
                5. Search for element's position
                6. Get element at index
                7. Get Head
                8. Get Tail
                9. Get Size
                10. Quit
                """);
    }

} // end of the class
