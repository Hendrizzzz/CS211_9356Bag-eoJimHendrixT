package prelim.CircularLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrayerLeaderTracker {

    // Circular linked-list of students
    private static MyDoublyLinkedCircularList<Student> students = new MyDoublyLinkedCircularList<>();


    public static void main(String[] args) {
        PrayerLeaderTracker myProgram;

        try {
            myProgram = new PrayerLeaderTracker();
            myProgram.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readData();

        int choice = readChoice(reader);

        while (true) {
            switch (choice) {
                case 1 -> createFile();
                case 2 -> addExistingFile();
                case 3 -> checkLeader();
                case 4 -> System.exit(0);
            }
        }
    }

    private void createFile() {
    }


    private void addExistingFile() {
    }

    private void checkLeader() {
    }

    private int readChoice(BufferedReader reader) {
        showMenu();

        while (true) {
            try {
                int choice = Integer.parseInt(reader.readLine());

                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid: Choice must be between 1- 4.");
                    continue;
                }

                return choice;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                System.out.println("Invalid: Input is not an integer. ");
            }
        }
    }

    private void showMenu() {
        System.out.println("""
                1. Create a file
                2. Add existing file
                3. Check prayer leader
                4. Exit
                """);
    }

    private void readData() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ( (line = reader.readLine()) != null) {
                Student student = new Student();
                String[] attributes = line.split(",");

                student.setFirstName(attributes[0]);
                student.setLastName(attributes[1]);
                student.setId(attributes[2]);

                students.insert(student);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
