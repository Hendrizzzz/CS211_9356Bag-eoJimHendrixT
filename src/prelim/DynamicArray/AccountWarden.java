package prelim.DynamicArray;

import java.io.*;


/**
 * Stores and Saves accounts
 */
public class AccountWarden {
    private static final String BOLD = "\033[1m";
    private static final String RESET = "\033[0m";
    private static final String GREEN = "\033[0;32m";  // Green color
    private static final String RED = "\033[31m";

    private static final File FILE_PATH = new File("src/prelim/DynamicArray/Accounts.txt");
    private static final MyGrowingArrayList<Account> accounts = new MyGrowingArrayList<>();


    public static void main(String[] args) {
        AccountWarden myProgram;

        try {
            myProgram = new AccountWarden();
            myProgram.run();
        } catch (Exception e ){
            e.printStackTrace();
        }
    }


    /**
     * Starts the main loop of the program, handling user input and executing actions.
     */
    private void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readData();

        while (true) {
            byte choice = readChoice(reader);

            switch (choice) {
                case 1 -> addAccount(reader);
                case 2 -> removeAccount(reader);
                case 3 -> viewAccounts(reader);
                case 4 -> viewAccountsWithPasswords(reader);
                case 5 -> saveChanges(reader);
                case 6 -> System.exit(0);
            }
        }
    }


    /**
     * Reads account data from the file and populates the account list.
     */
    private void readData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] attributes = line.split(",");
                String email = attributes[0];
                String username = attributes[1];
                String password = attributes[2];

                Account account = new Account(email, username, password);
                accounts.insert(account);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Reads the user's choice from the console.
     *
     * @param reader The BufferedReader used to read input.
     * @return The user's choice as a byte.
     */
    private byte readChoice(BufferedReader reader) {
        showMenu();
        while (true) {
            try {
                byte choice = Byte.parseByte(reader.readLine());

                if (choice < 0 || choice > 6) {
                    System.out.println("Invalid input. Please select only from 1 - 6. ");
                    continue;
                }

                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer. ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * Displays the menu options to the user.
     */
    private void showMenu() {
        System.out.println("""
                ACCOUNT WARDEN
                1. Add Account
                2. Remove Account
                3. View Accounts
                4. View Accounts with Passwords
                5. Save Changes
                6. Exit
                """);
    }



    /**
     * Adds a new account based on user input.
     *
     * @param reader The BufferedReader used to read user input.
     */
    private void addAccount(BufferedReader reader) {
        System.out.println(BOLD + "\nADDING ACCOUNT.... " + RESET);

        // Prompt for Account Details
        System.out.print("Email : ");
        String emailAddress = readString(reader);
        System.out.print("Username (if applicable) : ");
        String username = readString(reader);
        System.out.print("Password : ");
        String password = readString(reader);

        // Create Account Object
        Account account = new Account(emailAddress, username, password);

        // Add Account Object to the List
        accounts.insert(account);
        System.out.println(BOLD + GREEN + "ACCOUNT ADDED SUCCESSFULLY!\n" + RESET );
        pressEnterToContinue(reader);
    }



    /**
     * Removes an existing account based on user input.
     *
     * @param reader The BufferedReader used to read user input.
     */
    private void removeAccount(BufferedReader reader) {
        System.out.println(BOLD + "\nREMOVING ACCOUNT.... " + RESET);

        // Prompt for Account Details
        System.out.print("Email : ");
        String email = readString(reader);
        System.out.print("Username : ");
        String username = readString(reader);

        // Remove Account in the list
        Account account = new Account(email, username);
        boolean isDeleted = accounts.delete(account);

        if (isDeleted)
            System.out.println(BOLD + GREEN + "ACCOUNT REMOVED SUCCESSFULLY!\n" + RESET );
        else
            System.out.println(BOLD + RED + "ACCOUNT IS NOT IN THE LIST. NO ACCOUNT IS REMOVED.\n" + RESET );

        pressEnterToContinue(reader);
    }


    /**
     * Displays all accounts without passwords.
     *
     * @param reader The BufferedReader used to read user input.
     */
    private void viewAccounts(BufferedReader reader) {
        if (accounts.getSize() == 0) {
            System.out.println(BOLD + "\nTHERE ARE NO ACCOUNTS IN THE VAULT. \n " + RESET);
            return;
        }

        System.out.println(BOLD + "\nACCOUNTS IN THE VAULT: " + RESET);
        for (int i = 0; i < accounts.getSize(); i++){
            System.out.println(accounts.indexOf(i).toString(false) + "\n");
        }
        pressEnterToContinue(reader);
    }


    /**
     * Displays all accounts with passwords.
     *
     * @param reader The BufferedReader used to read user input.
     */
    private void viewAccountsWithPasswords(BufferedReader reader) {
        if (accounts.getSize() == 0) {
            System.out.println(BOLD + "\nTHERE ARE NO ACCOUNTS IN THE VAULT. \n " + RESET);
            return;
        }

        System.out.println(BOLD + "\nACCOUNTS WITH PASSWORDS IN THE VAULT: " + RESET);
        for (int i = 0; i < accounts.getSize(); i++){
            System.out.println(accounts.indexOf(i).toString() + "\n");
        }
        pressEnterToContinue(reader);
    }


    /**
     * Saves all accounts to the file.
     *
     * @param reader The BufferedReader used to read user input.
     */
    private void saveChanges(BufferedReader reader) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))){
            for (int i = 0; i < accounts.getSize(); i++) {
                Account account = accounts.indexOf(i);
                writer.write(account.getEmailAddress() + "," + account.getUsername() + "," + account.getPassword());
                writer.newLine();
            }
            pressEnterToContinue(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Prompts the user to press 'Enter' to continue.
     *
     * @param reader The BufferedReader used to read user input.
     */
    private void pressEnterToContinue(BufferedReader reader) {
        System.out.println("\nPress 'Enter' to continue. ");
        try {
            reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Reads a line of input from the user and trims leading and trailing whitespace.
     *
     * @param reader The BufferedReader used to read user input.
     * @return The input string from the user.
     */
    private String readString(BufferedReader reader) {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

} // end of the class