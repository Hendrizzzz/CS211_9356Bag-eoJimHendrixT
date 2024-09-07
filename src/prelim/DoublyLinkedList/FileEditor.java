package prelim.DoublyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class FileEditor {

    // ANSI escape codes for formatting console output
    private static final String BOLD = "\033[1m";
    private static final String RESET = "\033[0m";
    private static final String GREEN = "\033[32m";

    private static final MyDoublyLinkedList<TextFile> TEXT_FILES = new MyDoublyLinkedList<>();

    public static void main(String[] args) {
        FileEditor myProgram;

        try {
            myProgram = new FileEditor();
            myProgram.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run() {
        readData();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            byte choice = readChoice(reader);

            switch (choice) {
                case 1 -> createNewFile(reader);
                case 2 -> openFile(reader);
                case 3 -> deleteFile(reader);
                case 4 -> {
                    saveData();
                    System.exit(0);
                }
            }
        }
    }


    private void readData() {

    }


    private byte readChoice(BufferedReader reader) {
        displayMenu();

        while (true) {
            byte choice = readByte("Choose an option: ", reader, 1, 5);
            if (choice < 1 || choice > 5) {
                System.out.println("Choice not found. Try again. ");
                continue;
            }
            return choice;
        }
    }

    private void displayMenu() {
        System.out.println("""
                FILE READER MENU:
                1. Create a new file
                2. Open a file
                3. Delete a file
                4. Exit
                """);
    }

    private byte readByte(String prompt, BufferedReader reader, int lowerLimit, int upperLimit) {
        System.out.print(prompt);
        while (true) {
            try {
                byte choice = Byte.parseByte(reader.readLine());
                if (choice < lowerLimit || choice > upperLimit) {
                    System.out.println("Invalid: Choice must be between " + lowerLimit + " to " + upperLimit + " only. Try again. ");
                    continue;
                }

              return choice;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter an integer. ");
            }
        }
    }

    private String stringReader(String prompt, BufferedReader reader) {
        System.out.print(prompt);
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private void createNewFile(BufferedReader reader) {
        System.out.println(BOLD + "\nCreating a text file.... " + RESET);

        String title = stringReader("Title: ", reader);
        TextFile textFile = new TextFile(title, new Date());
        TEXT_FILES.insert(textFile);

        System.out.println(GREEN + "The file has been successfully created. \n" + RESET);
    }

    private void openFile(BufferedReader reader) {
        if (TEXT_FILES.getSize() == 0) {
            System.out.println(BOLD + "There are no files yet created. \n" + RESET);
            return;
        }

        System.out.println(BOLD + "\nOpening a file.... " + RESET);
        displayTEXT_FILES();
        byte fileToOpenIndex = readByte("File to Open: ", reader, 1, TEXT_FILES.getSize());
        while (true) {
            TextFile textFile = TEXT_FILES.get(fileToOpenIndex - 1);
            displayFile(fileToOpenIndex, textFile);
            System.out.print("""
                    1. Edit File
                    2. See past versions
                    3. Exit
                    """);
            byte choice = readByte("Choose what to do: ", reader, 1, 3);
            switch (choice) {
                case 1 -> editFile(reader, textFile);
                case 2 -> seePastVersions(textFile, reader);
                case 3 -> {
                    System.out.println();
                    return;
                }
            }
        }
    }

    private void displayFile(byte fileToOpenIndex, TextFile textFile) {
        System.out.println();
        if (textFile.getStringContents().isBlank()) {
            System.out.println("The text file has no contents yet....");
        }
        System.out.println(textFile.toString() + "\n");
    }

    private void displayTEXT_FILES() {
        System.out.printf("%-9s%-20s%-30s%n", "File No.", "Title", "Last Modified");
        for (int i = 0; i < TEXT_FILES.getSize(); i++){
            TextFile tf = TEXT_FILES.get(i);
            System.out.printf("%-9d%-20s%-30s%n", i + 1, tf.getTitle(), tf.getLastModified());
        }
        System.out.println();
    }

    private void editFile(BufferedReader reader, TextFile textFile) {
        System.out.println(BOLD + "\nEditing file... " + RESET);
        String newTitle = stringReader("New title (leave blank if keep the old title): ", reader);
        if (newTitle.isEmpty())
            newTitle = textFile.getTitle();
        System.out.println("Please enter the new contents of the file.\nYou can copy and paste the old contents above, then make any modifications as needed.");
        System.out.println("Enter 'Quit101' to stop editing. ");
        MyDoublyLinkedList<String> newContents = new MyDoublyLinkedList<>();
        while (true) {
            try {
                String line = reader.readLine();
                if (line.equals("Quit101"))
                    break;

                newContents.insert(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        byte choice = readByte("Save Changes? Yes(1) or No(2):  ", reader, 1, 2);
        if (choice == 1) {
            textFile.setContents(newTitle, newContents);
            System.out.println(BOLD + "");
        }

    }

    private void seePastVersions(TextFile textFile, BufferedReader reader) {
        if (textFile.getVersions().getSize() == 0) {
            System.out.println(BOLD + "File " + textFile.getTitle() + " has currently no past versions. \n" + RESET);
            return;
        }

        System.out.println(BOLD + "\nPast versions of " + textFile.getTitle() + ". " + RESET);
        System.out.printf("%-12s%-20s%-30s%n", "Version No.", "Title", "Last Modified");
        for (int i = 0; i < textFile.getVersions().getSize(); i++) {
            TextFile tf = textFile.getVersions().get(i);
            System.out.printf("%-12d%-20s%-30s%n", i + 1, tf.getTitle(), tf.getLastModified().toString());
        }
        byte versionNumber = readByte("Enter version number to Open: ", reader, 1, textFile.getVersions().getSize());
        System.out.println("\nVersion No. " + versionNumber);
        System.out.println(textFile.getVersions().get(versionNumber - 1));

        if (stringReader("Restore a previous version of this file? (Y/N): ", reader).equalsIgnoreCase("Y")) {
            textFile.setContents(textFile.getContents());
            TEXT_FILES.delete(textFile);
            TEXT_FILES.insert(textFile.getVersions().get(versionNumber - 1));
            System.out.println(GREEN + "Restoration complete: The file has been reverted to the earlier version. " + RESET);
        }
    }

    private void deleteFile(BufferedReader reader) {
        System.out.println(BOLD + "\nDeleting a file.... " + RESET);
        String title = stringReader("Title: ", reader);

        boolean isDeleted = TEXT_FILES.delete(new TextFile(title, new Date()));

        if (isDeleted)
            System.out.println(GREEN + "File has been successfully deleted! " + RESET);
        else
            System.out.println("FILE DELETION FAILED: file not found. ");
    }

    private void saveData() {

    }
}
