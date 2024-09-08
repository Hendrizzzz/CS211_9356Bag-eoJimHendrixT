package prelim.FixedArray;

import prelim.CustomInteger;
import prelim.DoublyLinkedList.MyDoublyLinkedList;
import prelim.DoublyLinkedNode;
import prelim.ListOverflowException;

import java.util.Scanner;

public class Tester {
    private static final MyFixedSizeArrayList<CustomInteger> integers = new MyFixedSizeArrayList<>();

    public static void main(String[] args) {


        while (true) {
            showOptions();
            int choice = readInt(1,6);
            switch (choice) {
                case 1 -> addInteger();
                case 2 -> deleteInteger();
                case 3 -> showList();
                case 4 -> searchIndexElement();
                case 5 -> getElementAtIndex();
                case 6 -> System.exit(0);
            }
            System.out.println();
        }
    }


    private static void addInteger() {
        System.out.print("Integer to Add : ");
        int integer = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        try {
            integers.insert(new CustomInteger(integer));
            System.out.println("The integer is inserted. ");
        } catch (ListOverflowException e) {
            System.out.println("Inserting Element unsuccessful. The list is already full at size 5. ");
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

    private static void showList() {
        System.out.println("The list: ");
        for (int i = 0; i < integers.getSize(); i++) {
            System.out.print(integers.get(i) + "  ");
        }
        System.out.println();
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
