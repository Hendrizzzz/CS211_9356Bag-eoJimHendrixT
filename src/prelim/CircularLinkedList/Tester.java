package prelim.CircularLinkedList;

import prelim.CircularLinkedList.MyDoublyLinkedCircularList;
import prelim.CustomInteger;
import prelim.DoublyLinkedNode;

import java.util.Scanner;

public class Tester {
    private static final MyDoublyLinkedCircularList<CustomInteger> integers = new MyDoublyLinkedCircularList<>();

    public static void main(String[] args) {


        while (true) {
            showOptions();
            int choice = readInt(1,12);
            switch (choice) {
                case 1-> addInteger();
                case 2 -> deleteInteger();
                case 3 -> traverseList();
                case 4 -> traverseInReverse();
                case 5 -> traverseListTwice(); // To show the connection of the head and tail nodes
                case 6 -> traverse(30);
                case 7 -> searchIndexElement();
                case 8 -> getElementAtIndex();
                case 9 -> System.out.println("\nHead : " + integers.getHead());
                case 10 -> System.out.println("\nTail : " + integers.getTail());
                case 11 -> System.out.println("\nSize: " + integers.getSize());
                case 12 -> System.exit(0);
            }
            System.out.println();
        }
    }


    private static void addInteger() {
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

    private static void deleteInteger() {
        System.out.print("Integer to Delete: ");
        int integer = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (integers.delete(new CustomInteger(integer)))
            System.out.println("Deletion Success. ");
        else
            System.out.println(integer + " is not in the list. ");
    }

    // Exceptions are not applied here
    private static void traverseList() {
        System.out.println("\nTraversing from head to tail: ");
        System.out.print("t <- Head -> ");
        DoublyLinkedNode<CustomInteger> currentNode = integers.getHead();
        System.out.print(currentNode.getData() + "  <-->  ");
        currentNode = currentNode.getNext();
        while (!currentNode.equals(integers.getHead())) {
            System.out.print(currentNode.getData());

            if (! currentNode.getNext().equals(integers.getHead()))
                System.out.print("  <-->  ");
            currentNode = currentNode.getNext();
        }
        System.out.print(" <- Tail -> h");
    }

    // Catching null pointer exceptions are not applied here
    private static void traverseInReverse() {
        System.out.println("\nTraversing from tail to head: ");
        System.out.print("h <- Tail -> ");
        DoublyLinkedNode<CustomInteger> currentNode = integers.getTail();
        System.out.print(currentNode.getData() + "  <-->  ");
        currentNode = currentNode.getPrevious();
        while (!currentNode.equals(integers.getTail())) {
            System.out.print(currentNode.getData());

            if (! currentNode.getPrevious().equals(integers.getTail()))
                System.out.print("  <-->  ");
            currentNode = currentNode.getPrevious();
        }
        System.out.print(" <- Head -> t");
    }

    // Catching null pointer exceptions are not applied here
    private static void traverseListTwice(){
        System.out.println("\nTraversing the List Twice: ");
        DoublyLinkedNode<CustomInteger> currentNode = integers.getHead();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < integers.getSize(); j++) {
                System.out.print(currentNode.getData() + " <--> ");

                currentNode = currentNode.getNext();
            }
        }
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
                4. Traverse List Tail to Head
                5. Traverse LinkedList twice
                6. Visit nodes x times
                7. Search for element's position
                8. Get element at index
                9. View Head
                10. View Tail
                11. Get Size
                12. Quit
                """);
    }

    private static void traverse(int count) {
        int i = 0;
        DoublyLinkedNode<CustomInteger> integer = integers.getHead();
        while (i < count) {
            System.out.print(integer.getData() + " <-> ");

            integer = integer.getNext();
            i++;
        }
    }
}
