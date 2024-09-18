package prelim;

import prelim.FixedArray.Tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * This class serves as the main entry point for testing various data structure implementations.
 */
public class MainTester {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Tester objects
        Tester fixedArray = new Tester();
        prelim.DynamicArray.Tester dynamicArray = new prelim.DynamicArray.Tester();
        prelim.LinkedList.Tester linkedList = new prelim.LinkedList.Tester();
        prelim.DoublyLinkedList.Tester doublyLinkedList = new prelim.DoublyLinkedList.Tester();
        prelim.CircularLinkedList.Tester circularLinkedList = new prelim.CircularLinkedList.Tester();

        boolean exploring = true;
        while (exploring) {
            byte choice = readChoice(reader);

            switch (choice) {
                case 1 -> fixedArray.run();
                case 2 -> dynamicArray.run();
                case 3 -> linkedList.run();
                case 4 -> doublyLinkedList.run();
                case 5 -> circularLinkedList.run();
            }

            if (userDoesNotWantAnymore(reader))
                exploring = false;
        }
    }

    private static byte readChoice(BufferedReader reader) {
        showMenu();

        while (true) {
            try {
                byte choice = Byte.parseByte(reader.readLine());
                if (choice < 1 || choice > 5) {
                    System.out.println("INVALID: choice not found. ");
                    continue;
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("INVALID: input not a number. Try again. ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private static void showMenu() {
        System.out.println("""
                    What do you want to test?
                    1. My Fixed Array
                    2. My Growing Array
                    3. My Singly-LinkedList
                    4. My Doubly-LinkedList
                    5. My Circular Doubly-LinkedList
                    """);
    }

    private static boolean userDoesNotWantAnymore(BufferedReader reader) {
        System.out.println("View another Implementations? " +
                "(Y)es or (N)o?");
        String answer = "";
        while (true) {
            try {
                answer = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (answer.equalsIgnoreCase("N"))
                return true;
            else if (answer.equalsIgnoreCase("Y"))
                return false;
            else
                System.out.print("Enter (Y)es or (N)o: ");
        }

    }

} // end of the class
