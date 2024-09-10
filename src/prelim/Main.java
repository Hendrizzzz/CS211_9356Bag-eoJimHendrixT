package prelim;

import prelim.FixedArray.Tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String[] justAnArgumentToBePassed = new String[1];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean exploring = true;
        while (exploring) {
            byte choice = readChoice(reader);

            switch (choice) {
                case 1 -> Tester.main(justAnArgumentToBePassed);
                case 2 -> prelim.DynamicArray.Tester.main(justAnArgumentToBePassed);
                case 3 -> prelim.LinkedList.Tester.main(justAnArgumentToBePassed);
                case 4 -> prelim.DoublyLinkedList.Tester.main(justAnArgumentToBePassed);
                case 5 -> prelim.CircularLinkedList.Tester.main(justAnArgumentToBePassed);
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
