package prelim.LinkedList;

import prelim.CustomInteger;
import prelim.DoublyLinkedList.MyDoublyLinkedList;
import prelim.DoublyLinkedNode;

import java.util.Scanner;

public class Tester {
    private static final MyDoublyLinkedList<CustomInteger> integers = new MyDoublyLinkedList<>();

    public static void main(String[] args) {

        while (true) {
            showOptions();
            int choice = readInt(1,6);
            switch (choice) {
                case 1 -> addInteger();
                case 2 -> deleteInteger();
                case 3 -> traverseList();
                case 4 -> searchIndexElement();
                case 5 -> getElementAtIndex();
                case 6 -> System.exit(0);
            }
            System.out.println();
        }
    }


    private static void addInteger() {
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

    private static void deleteInteger() {
        System.out.print("Integer to Delete: ");
        int integer = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (integers.delete(new CustomInteger(integer)))
            System.out.println("Deletion Success. ");
        else
            System.out.println(integer + " is not in the list. ");
    }

    private static void traverseList() {
        System.out.println("\nTraversing from head to tail: ");
        System.out.print("Head -> ");

        DoublyLinkedNode<CustomInteger> currentNode = integers.getHead();
        System.out.print(currentNode.getData() + "  -->  ");
        currentNode = currentNode.getNext();

        while (currentNode != null) {
            System.out.print(currentNode.getData());

            if (currentNode.getNext() != null)
                System.out.print("  -->  ");
            currentNode = currentNode.getNext();
        }
        System.out.print(" <- Tail");
    }


    private static void searchIndexElement() {
        System.out.print("Enter the integer to search (returns the index): ");
        int integerToSearch = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        int index = integers.search(new CustomInteger(integerToSearch));

        if (index == -1)
            System.out.println("The integer is not in the list. ");
        else
            System.out.println("The integer " + integerToSearch + " is found at index " + index);
    }

    private static void getElementAtIndex() {
        System.out.print("Enter the index: ");
        int index = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        try {
            CustomInteger result = integers.get(index);
            System.out.println("The number at index " + index + " is " + result);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no index " + index + " yet in the list. ");
        }

    }

    private static int readInt(int min, int max) {
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

    private static void showOptions() {
        System.out.println("""
                1. Add integer
                2. Delete integer
                3. Show List
                4. Search for element's position
                5. Get element at index
                6. Quit
                """);
    }

}
