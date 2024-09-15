package prelim.LinkedList;

import prelim.CustomInteger;

import java.util.Scanner;


/**
 * A class for testing operations on MyFixedSizeArrayList.
 * Provides options to add, delete, search, and retrieve integers from the list.
 */
public class Tester {
    private static final MySinglyLinkedList<CustomInteger> integers = new MySinglyLinkedList<>();


    public void run() {
        boolean exploring = true;
        while (exploring) {
            showOptions();
            int choice = readInt(1,9);
            switch (choice) {
                case 1 -> addInteger();
                case 2 -> deleteInteger();
                case 3 -> traverseList();
                case 4 -> searchIndexElement();
                case 5 -> getElementAtIndex();
                case 6 -> System.out.println("\nHead: " + integers.getHead());
                case 7 -> System.out.println("\nTail: " + integers.getTail());
                case 8 -> System.out.println("\nSize: " + integers.getSize());
                case 9 -> exploring = false;
            }
            System.out.println();
        }
    }


    /**
     * Adds an integer to the list.
     */
    private void addInteger() {
        System.out.println("How many integers to add: ");
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
     * Adds an integer to the list.
     */
    private void deleteInteger() {
        System.out.print("Integer to Delete: ");
        int integer = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (integers.delete(new CustomInteger(integer)))
            System.out.println("Deletion Success. ");
        else
            System.out.println(integer + " is not in the list. ");
    }


    /**
     * Displays all integers in the list.
     */
    private void traverseList() {
        System.out.println("\nTraversing from head to tail:");
        Node<CustomInteger> currentNode = integers.getHeadNode();

        if (currentNode == null) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.print("Head -> ");
        while (currentNode != null) {
            System.out.print(currentNode.getData());
            if (currentNode.getNext() != null) {
                System.out.print(" --> ");
            }
            currentNode = currentNode.getNext();
        }

        System.out.println(" <- Tail");
    }


    /**
     * Searches for an integer in the list and displays its index.
     */
    private void searchIndexElement() {
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
     * @param min The minimum valid value.
     * @param max The maximum valid value.
     * @return The validated integer input.
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
                MY SINGLY-LINKEDLIST
                1. Add integer
                2. Delete integer
                3. Show List
                4. Search for element's position
                5. Get element at index
                6. Get head
                7. Get tail
                8. Get size
                9. Quit
                """);
    }

}
