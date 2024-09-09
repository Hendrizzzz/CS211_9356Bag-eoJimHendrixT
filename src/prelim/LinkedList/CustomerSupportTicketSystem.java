package prelim.LinkedList;

import prelim.LinkedList.Objects.Customer;
import prelim.LinkedList.Objects.SupportEngineer;
import prelim.LinkedList.Objects.SupportTicket;

import java.io.*;
import java.util.NoSuchElementException;


/**
 * CustomerSupportTicketSystem is a program that simulates a simple ticket system
 * where customers can sign up, log in, and submit support tickets, while
 * support engineers can view and resolve tickets.
 */
public class CustomerSupportTicketSystem {


    // ANSI escape codes for formatting console output
    private static final String BOLD = "\033[1m";
    private static final String RESET = "\033[0m";
    private static final String GREEN = "\033[32m";

    // File paths for saving and loading customer, support engineer, and support ticket data
    private static final String CUSTOMER_LIST_FILE = "src/prelim/LinkedList/Database/Customers.txt";
    private static final String SUPPORT_ENGINEER_LIST_FILE = "src/prelim/LinkedList/Database/SupportEngineers.txt";
    private static final String SUPPORT_TICKETS_LIST_FILE = "src/prelim/LinkedList/Database/SupportTickets.txt";

    // Better to use ArrayList for both, but I'd like to test my Custom Implementation of Singly-LinkedList
    // Custom implementation of a Singly-LinkedList to manage customers, engineers, and tickets
    private static final MySinglyLinkedList<Customer> customerList = new MySinglyLinkedList<>();
    private static final MySinglyLinkedList<SupportEngineer> supportEngineerList = new MySinglyLinkedList<>();

    private static final MySinglyLinkedList<SupportTicket> supportTickets = new MySinglyLinkedList<>();

    // Current logged-in users
    private static Customer currentCustomerUser;
    private static SupportEngineer currentSupportEngineerUser;


    public static void main(String[] args) {
        CustomerSupportTicketSystem myProgram;

        try {
            myProgram = new CustomerSupportTicketSystem();
            myProgram.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Runs the main program loop, prompting the user to log in or sign up,
     * and handling the corresponding actions based on their role (customer or support engineer).
     */
    private void run() {
        readPreviousData(); // Load previous data from files

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String prompt1 = "Support Engineer(0), Customer(1), Save and Exit(2): ";
            String prompt2 = "Log in (1) or Sign up (0) : ";

            // Determine if the user is a support engineer or customer
            System.out.println("USER TYPE: ");
            boolean isSupportEngineer = readChoice(reader, prompt1);

            // Determine if the user wants to log in or sign up
            System.out.println("ACTION TYPE: ");
            boolean isSignUp = readChoice(reader, prompt2);

            if (isSignUp) {
                boolean isSignedUp = signUpPage(reader, isSupportEngineer);
                if (isSignedUp && isSupportEngineer) {
                    showSupportEngineerEnd(reader);
                }
                else if (isSignedUp) {
                    showCustomerEnd(reader);
                }
            }
            else {
                boolean isLoggedIn = logInPage(reader, isSupportEngineer);
                if (isLoggedIn && isSupportEngineer) {
                    showSupportEngineerEnd(reader);
                }
                else if (isLoggedIn) {
                    showCustomerEnd(reader);
                }
            }
        }
    }


    /**
     * Reads previous data for customers, support engineers, and support tickets from their respective files.
     */
    private void readPreviousData() {
        readCustomers();
        readSupportEngineers();
        readSupportTickets();

    }


    /**
     * Reads the support tickets data from the file and populates the supportTickets linked list.
     */
    private void readSupportTickets() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SUPPORT_TICKETS_LIST_FILE))){
            String line;

            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");

                SupportTicket supportTicket = new SupportTicket();
                Customer customer = new Customer();
                customer.setName(attributes[0]);
                customer.setId(attributes[1]);
                customer.setPassword(attributes[2]);
                customer.setEmail(attributes[3]);
                customer.setIssue(supportTicket);

                supportTicket.setTitle(attributes[4]);
                supportTicket.setIssueDescription(attributes[5]);
                supportTicket.setTicketNumber(Integer.parseInt(attributes[6]));
                supportTicket.setStatus(attributes[7]);
                supportTicket.setCustomer(customer);

                supportTickets.insert(supportTicket);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    /**
     * Reads the support engineers data from the file and populates the supportEngineerList linked list.
     */
    private void readSupportEngineers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SUPPORT_ENGINEER_LIST_FILE))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                String name = attributes[0];
                String id = attributes[1];
                String password = attributes[2];
                String email = attributes[3];

                SupportEngineer customerSupportRep = new SupportEngineer(name, id, password, email);
                supportEngineerList.insert(customerSupportRep);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Reads the customers' data from the file and populates the customerList linked list.
     */
    private void readCustomers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMER_LIST_FILE))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                String name = attributes[0];
                String id = attributes[1];
                String password = attributes[2];
                String email = attributes[3];
                Customer customer = new Customer(name, id, password, email);

                // If there is a support ticket associated with the customer, parse it
                if (attributes.length > 4) {
                    SupportTicket supportTicket = new SupportTicket();
                    supportTicket.setCustomer(customer);
                    supportTicket.setTitle(attributes[4]);
                    supportTicket.setIssueDescription(attributes[5]);
                    supportTicket.setTicketNumber(Integer.parseInt(attributes[6]));
                    supportTicket.setStatus(attributes[7]);

                    customer.setIssue(supportTicket);
                }
                customerList.insert(customer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Prompts the user for a choice (Support Engineer, Customer, or Save and Exit) and reads their input.
     *
     * @param reader BufferedReader for reading user input.
     * @param prompt The prompt message to display.
     * @return true if the user chose Support Engineer, false otherwise.
     */
    private boolean readChoice(BufferedReader reader, String prompt) {
        System.out.println(prompt);
        while (true) {
            System.out.print(GREEN + ">> " + RESET);
            try {
                byte choice = Byte.parseByte(reader.readLine().trim());

                if (choice == 0)
                    return true; // Support Engineer
                else if (choice == 1)
                    return false; // Customer
                else if (choice == 2) {
                    saveData();
                    System.exit(0); // Save data and exit the program
                }
                else
                    System.out.println("Unknown input. Try again. ");

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter an integer. ");
            }
        }
    }


    /**
     * Saves customer, support engineer, and support ticket data to their respective files.
     */
    private void saveData() {
        saveCustomers();
        saveSupportEngineers();
        saveSupportTickets();
    }

    // Saving method
    private void saveCustomers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMER_LIST_FILE))){
            for (int i = 0; i < customerList.getSize(); i++) {
                Customer c = customerList.get(i);
                writer.write(c.getName() + "," + c.getId() + "," + c.getPassword() + "," + c.getEmail() + ",");

                if (c.getIssue() != null) {
                        writer.write(c.getIssue().getTitle() + "," + c.getIssue().getIssueDescription() + "," +
                        c.getIssue().getTicketNumber() + "," + c.getIssue().getStatus());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Saving method
    private void saveSupportEngineers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SUPPORT_ENGINEER_LIST_FILE))){
            for (int i = 0; i < supportEngineerList.getSize(); i++) {
                SupportEngineer se = supportEngineerList.get(i);
                writer.write(se.getName() + "," + se.getId() + "," + se.getPassword() + "," + se.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // Save method
    private void saveSupportTickets() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SUPPORT_TICKETS_LIST_FILE))){
            for (int i = 0; i < supportTickets.getSize(); i++){
                SupportTicket st = supportTickets.get(i);
                writer.write(st.getCustomer().getName() + "," + st.getCustomer().getId() + "," + st.getCustomer().getPassword() + "," +
                                st.getCustomer().getEmail() + "," + st.getTitle() + "," + st.getIssueDescription() + "," +
                                st.getTicketNumber() + "," + st.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Prompts the user to log in and verifies their credentials.
     *
     * @param reader BufferedReader for reading user input.
     * @param isSupportEngineer Indicates if the user is a support engineer.
     * @return true if the user successfully logs in, false otherwise.
     */
    private boolean logInPage(BufferedReader reader, boolean isSupportEngineer) {
        System.out.println(BOLD + "LOGGING IN... " + RESET);
        String id;
        String password;
        while (true) {
            id = readString("Enter your ID: ", reader);
            password = readString("Password: ", reader);

            try {
                if (isSupportEngineer) {
                    SupportEngineer supportEngineer = new SupportEngineer(id, password);
                    currentSupportEngineerUser = supportEngineerList.getElement(supportEngineer);
                } else {
                    Customer customer = new Customer(id, password);
                    currentCustomerUser = customerList.getElement(customer);
                }
                return true;
            } catch (NoSuchElementException e){
                System.out.println("Account doesn't exist. Either id or password is wrong or try signing-up. ");

                byte confirmation = readByte("Continue Logging in? \nContinue(1) or Cancel(0): ", reader);
                if (confirmation == 0) {
                    System.out.println();
                    return false;
                }
            }
        }

    }


    /**
     * Handles the sign-up process for either a support engineer or a customer.
     *
     * @param reader The BufferedReader for reading user input.
     * @param isSupportEngineer Boolean indicating if the user is a support engineer.
     * @return True if the account is successfully created, false otherwise.
     */
    private boolean signUpPage(BufferedReader reader, boolean isSupportEngineer) {
        System.out.println(BOLD + "SIGNING UP... " + RESET);

        // Generate a unique ID for the user
        String id = generateUserId(isSupportEngineer);
        System.out.println("Your ID will be: " + id + ". Please remember it. ");

        // Get user details
        String name = readString("Name: ", reader);
        String password = readPassword(reader);
        String email = readString("Email: ", reader);

        // Confirm account creation
        if (!confirmAccountCreation(reader)) {
            System.out.println(BOLD + "Account not created. \n" + RESET);
            return false;
        }

        // Create and add the new user to the list
        if (isSupportEngineer) {
            createAndAddSupportEngineer(name, id, password, email);
        } else {
            createAndAddCustomer(name, id, password, email);
        }

        System.out.println(BOLD + GREEN + "ACCOUNT SUCCESSFULLY CREATED AND SIGNED UP! \n" + RESET);
        return true;
    }

    /**
     * Generates a unique ID for the user.
     *
     * @param isSupportEngineer Boolean indicating if the user is a support engineer.
     * @return The generated user ID as a string.
     */
    private String generateUserId(boolean isSupportEngineer) {
        int newId = isSupportEngineer ? supportEngineerList.getSize() + 1 : customerList.getSize() + 1;
        return String.valueOf(newId);
    }

    /**
     * Prompts the user to set and confirm a strong password.
     *
     * @param reader The BufferedReader for reading user input.
     * @return The confirmed strong password.
     */
    private String readPassword(BufferedReader reader) {
        while (true) {
            String password = readString("Set a strong password: ", reader);
            String rePassword = readString("Retype your password: ", reader);

            if (!password.equals(rePassword)) {
                System.out.println("Passwords didn't match. Try again.");
            } else if (password.length() < 8) {
                System.out.println("Password is weak. The password should contain at least 8 characters. Try again.");
            } else {
                return password;
            }
        }
    }

    /**
     * Prompts the user to confirm account creation.
     *
     * @param reader The BufferedReader for reading user input.
     * @return True if the user confirms, false otherwise.
     */
    private boolean confirmAccountCreation(BufferedReader reader) {
        while (true) {
            byte confirmation = readByte("Confirm Account Creation? \nProceed(1) or Cancel(0): ", reader);
            System.out.println();
            if (confirmation == 1) {
                return true;
            } else if (confirmation == 0) {
                return false;
            }
        }
    }

    /**
     * Creates a new Support Engineer and adds them to the list.
     *
     * @param name The name of the new support engineer.
     * @param id The ID of the new support engineer.
     * @param password The password for the new support engineer.
     * @param email The email of the new support engineer.
     */
    private void createAndAddSupportEngineer(String name, String id, String password, String email) {
        SupportEngineer supportEngineer = new SupportEngineer(name, id, password, email);
        supportEngineerList.insert(supportEngineer);
        currentSupportEngineerUser = supportEngineer;
    }

    /**
     * Creates a new Customer and adds them to the list.
     *
     * @param name The name of the new customer.
     * @param id The ID of the new customer.
     * @param password The password for the new customer.
     * @param email The email of the new customer.
     */
    private void createAndAddCustomer(String name, String id, String password, String email) {
        Customer customer = new Customer(name, id, password, email);
        customerList.insert(customer);
        currentCustomerUser = customer;
    }


    /**
     * Reads a string input from the user, ensuring it does not contain commas.
     *
     * @param prompt The prompt message to display to the user.
     * @param reader The BufferedReader for reading user input.
     * @return The valid input string.
     */
    private String readString(String prompt, BufferedReader reader) {
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            try {
                input = reader.readLine();
                // Check if input contains a comma
                if (input.contains(",")) { // Ban commas because it makes the reading of csv file misbehave
                    System.out.println("Input cannot contain commas. Please try again.");
                } else {
                    validInput = true; // Valid input, exit loop
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return input;
    }


    /**
     * Reads a byte input from the user, handling invalid inputs.
     *
     * @param prompt The prompt message to display to the user.
     * @param reader The BufferedReader for reading user input.
     * @return The byte input from the user.
     */
    private byte readByte(String prompt, BufferedReader reader) {
        System.out.print(prompt);
        while (true) {
            try {
                return Byte.parseByte(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer. ");
            }
        }
    }



    /**
     * Displays the menu for support engineers and handles their choices.
     *
     * @param reader The BufferedReader for reading user input.
     */
    private void showSupportEngineerEnd(BufferedReader reader) {
        System.out.println(BOLD + "\nSUPPORT ENGINEER'S END. ");
        System.out.println("Welcome " + currentSupportEngineerUser.getName() + "!" + RESET);
        while (true) {
            displayMenu(true);

            byte choice = readByte("", reader);

            switch (choice) {
                case 1 -> showAllSubmittedSupportTickets();
                case 2 -> showPendingIssues();
                case 3 -> showSolvedIssues();
                case 4 -> resolveAnIssue(reader);
                case 5 -> {
                    System.out.println("\n");
                    return;
                }
            }
        }

    }


    /**
     * Shows a list of all pending support tickets.
     */
    private void showPendingIssues() {
        if (supportTickets.getSize() == 0) {
            System.out.println(BOLD + "There are no issues yet to solve. " + RESET);
            return;
        }

        System.out.println(BOLD + "\nLIST OF PENDING SUPPORT TICKETS: " + RESET);
        System.out.printf(BOLD + "%-15s%-25s%-20s%-25s%n", "Ticket Number", "Title", "Status", "Customer" + RESET);
        for (int i = 0; i < supportTickets.getSize(); i++) {
            SupportTicket st = supportTickets.get(i);
            if (st.getStatus().equals("Open"))
                System.out.printf("%-15s%-25s%-20s%-25s%n", st.getTicketNumber(), st.getTitle(), st.getStatus(), st.getCustomer().getName());
        }
        System.out.println();
    }


    /**
     * Shows a list of all submitted support tickets.
     */
    private void showAllSubmittedSupportTickets() {
        if (supportTickets.getSize() == 0) {
            System.out.println(BOLD + "There are no issues yet submitted. " + RESET);
            return;
        }

        System.out.println(BOLD + "\nLIST OF ALL SUBMITTED SUPPORT TICKETS: " + RESET);
        System.out.printf(BOLD + "%-15s%-25s%-20s%-25s%n", "Ticket Number", "Title", "Status", "Customer" + RESET);
        for (int i = 0; i < supportTickets.getSize(); i++) {
            SupportTicket st = supportTickets.get(i);
            System.out.printf("%-15s%-25s%-20s%-25s%n", st.getTicketNumber(), st.getTitle(), st.getStatus(), st.getCustomer().getName());
        }
        System.out.println();
    }


    /**
     * Shows a list of solved support tickets.
     */
    private void showSolvedIssues() {
        boolean isTicketsSolved = false;
        for (int i = 0; i < supportTickets.getSize(); i++){
            SupportTicket st = supportTickets.get(i);
            if (st.getStatus().equals("Solved")) {
                isTicketsSolved = true;
                break;
            }
        }

        if (isTicketsSolved) {
            System.out.println(BOLD + "\nLIST OF  SOLVED SUPPORT TICKETS. ");
            System.out.printf("%-15s%-25s%-20s%-25s%n", "Ticket Number", "Title", "Status", "Customer" + RESET);
            for (int i = 0; i < supportTickets.getSize(); i++) {
                SupportTicket st = supportTickets.get(i);
                if (st.getStatus().equals("Solved"))
                    System.out.printf("%-15s%-25s%-20s%-25s%n", st.getTicketNumber(), st.getTitle(), st.getStatus(), st.getCustomer().getName());
            }
        } else {
            System.out.println(BOLD + "There are no issues solved yet. " + RESET);
        }
        System.out.println();

    }


    /**
     * Resolves an open support issue.
     *
     * @param reader The BufferedReader for reading user input.
     */
    private void resolveAnIssue(BufferedReader reader) {
        boolean isIssuesToResolvePresent = false;
        for (int i = 0; i < supportTickets.getSize(); i++){
            SupportTicket st = supportTickets.get(i);
            if (st.getStatus().equals("Open")) {
                isIssuesToResolvePresent = true;
                break;
            }
        }

        if (isIssuesToResolvePresent) {
            SupportTicket st = null;
            System.out.println(BOLD + "\nSUPPORT TICKET TO SOLVE: " + RESET);
            for (int i = 0; i < supportTickets.getSize(); i++) {
                st = supportTickets.get(i);
                if (st.getStatus().equals("Open")) {
                    System.out.println(st);
                    break;
                }
            }

            // Ask if the issue is solved
            String status = readString("\nIssue Solved(Y) or (N)? :", reader);
            if (status.equalsIgnoreCase("Y")) {
                supportTickets.getElement(st).setStatus("Solved");
                customerList.getElement(supportTickets.getElement(st).getCustomer()).getIssue().setStatus("Solved");
                System.out.println(BOLD + "The issue is successfully solved! " + RESET);
            }
        } else {
            System.out.println(BOLD + "There are no issues solved yet. " + RESET);
        }
        System.out.println();
    }


    /**
     * Displays the menu for customers and handles their choices.
     *
     * @param reader The BufferedReader for reading user input.
     */
    private void showCustomerEnd(BufferedReader reader) {
        System.out.println(BOLD + "\nWelcome " + currentCustomerUser.getName() + "!" + RESET);
        while (true) {
            displayMenu(false);

            byte choice = readByte("", reader);

            switch (choice) {
                case 1 -> submitNewIssue(reader);
                case 2 -> viewSubmittedIssues();
                case 3 -> updateIssueStatus(reader);
                case 4 -> {
                    System.out.println("\n");
                    return;
                }
            }
        }
    }

    /**
     * Allows the customer to submit a new issue.
     *
     * @param reader The BufferedReader for reading user input.
     */
    private void submitNewIssue(BufferedReader reader) {
        System.out.println(BOLD + "SUBMITTING NEW ISSUE" + RESET);

        String title = readString("Title: ", reader);
        String description = readString("Description: ", reader);

        // Create a new support ticket
        int ticketNumber =(supportTickets.getSize() + 1);
        SupportTicket newIssue = new SupportTicket(customerList.getElement(currentCustomerUser), title, description, ticketNumber, "Open");
        supportTickets.insert(newIssue);

        System.out.println(BOLD + GREEN + "Your issue has been successfully submitted. " + RESET);
    }

    /**
     * Views the issues submitted by the customer.
     */
    private void viewSubmittedIssues() {
        boolean hasSubmittedIssues = false;
        for (int i = 0; i < supportTickets.getSize(); i++) {
            if (supportTickets.get(i).getCustomer().equals(currentCustomerUser)) {
                hasSubmittedIssues = true;
                break;
            }
        }

        if (hasSubmittedIssues) {
            System.out.println(BOLD + "YOUR SUBMITTED ISSUES" + RESET);
            for (int i = 0; i < supportTickets.getSize(); i++) {
                SupportTicket st = supportTickets.get(i);
                if (st.getCustomer().equals(currentCustomerUser)) {
                    System.out.println(st + "\n");
                }
            }
        } else {
            System.out.println(BOLD + "You have not submitted any issues yet." + RESET);
        }
        System.out.println();
    }

    /**
     * Updates the status of a submitted issue.
     *
     * @param reader The BufferedReader for reading user input.
     */
    private void updateIssueStatus(BufferedReader reader) {
        System.out.println(BOLD + "UPDATE ISSUE STATUS" + RESET);

        int ticketNumber = readByte("Enter the ticket number to update: ", reader);
        SupportTicket ticket = findSupportTicketByNumber(ticketNumber);

        if (ticket == null) {
            System.out.println(BOLD + "No issue found with the provided ticket number." + RESET);
            return;
        }

        System.out.println("Current Status: " + ticket.getStatus());
        String newStatus = readString("Enter new status: ", reader);

        ticket.setStatus(newStatus);
        System.out.println(BOLD + GREEN + "The issue status has been updated." + RESET);
        System.out.println();
    }

    /**
     * Finds a support ticket by its number.
     *
     * @param ticketNumber The ticket number to search for.
     * @return The SupportTicket object if found, null otherwise.
     */
    private SupportTicket findSupportTicketByNumber(int ticketNumber) {
        for (int i = 0; i < supportTickets.getSize(); i++) {
            SupportTicket ticket = supportTickets.get(i);
            if (ticket.getTicketNumber() == ticketNumber) {
                return ticket;
            }
        }
        return null;
    }

    /**
     * Displays the menu options for both support engineers and customers.
     *
     * @param isSupportEngineer Boolean indicating if the user is a support engineer.
     */
    private void displayMenu(boolean isSupportEngineer) {
        if (isSupportEngineer) {
            System.out.println(BOLD + "\nSupport Engineer Menu" + RESET);
            System.out.println("1. View All Submitted Issues");
            System.out.println("2. View Pending Issues");
            System.out.println("3. View Solved Issues");
            System.out.println("4. Resolve an Issue");
            System.out.println("5. Logout");
        } else {
            System.out.println(BOLD + "\nCustomer Menu" + RESET);
            System.out.println("1. Submit New Issue");
            System.out.println("2. View Submitted Issues");
            System.out.println("3. Update Issue Status");
            System.out.println("4. Logout");
        }
    }

} // end of the class
