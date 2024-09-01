package prelim.LinkedList;

import java.io.*;
import java.util.NoSuchElementException;

public class CustomerSupportTicketSystem {

    private static final String BOLD = "\033[1m";
    private static final String RESET = "\033[0m";
    private static final String GREEN = "\033[32m";

    private static final String CUSTOMER_LIST_FILE = "src/prelim/LinkedList/Database/Customers.txt";
    private static final String SUPPORT_ENGINEER_LIST_FILE = "src/prelim/LinkedList/Database/SupportEngineers.txt";

    // Better to use ArrayList for both, but I'd like to test my Custom Implementation of Singly-LinkedList
    private static final MySinglyLinkedList<Customer> customerList = new MySinglyLinkedList<>();
    private static final MySinglyLinkedList<SupportEngineer> supportEngineerList = new MySinglyLinkedList<>();

    private static final MySinglyLinkedList<SupportTicket> supportTickets = new MySinglyLinkedList<>();

    private static Customer currentCustomerUser;

    public static void main(String[] args) {
        CustomerSupportTicketSystem myProgram;

        try {
            myProgram = new CustomerSupportTicketSystem();
            myProgram.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run() {
        readPreviousData();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String prompt1 = "Support Engineer(0), Customer(1), Save and Exit(2): ";
            String prompt2 = "Log in (1) or Sign up (0) : ";

            boolean isSupportEngineer = readChoice(reader, prompt1);
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


    private void readPreviousData() {
        readCustomers();
        readSupportEngineers();
    }

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

                SupportTicket supportTicket = new SupportTicket();
                supportTicket.setCustomer(customer);
                supportTicket.setTitle(attributes[4]);
                supportTicket.setIssueDescription(attributes[5]);
                supportTicket.setTicketNumber(Integer.parseInt(attributes[6]));
                supportTicket.setStatus(attributes[7]);

                customer.setIssue(supportTicket);
                customerList.insert(customer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean readChoice(BufferedReader reader, String prompt) {
        System.out.println(prompt);
        while (true) {
            System.out.print(GREEN + ">> " + RESET);
            try {
                byte choice = Byte.parseByte(reader.readLine().trim());

                if (choice == 0)
                    return true;
                else if (choice == 1)
                    return false;
                else if (choice == 2) {
                    saveData();
                    System.exit(0);
                }
                else
                    System.out.println("Unknown input. Enter '0' to Log in or '1' to Sign up. ");

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter an integer. ");
            }
        }
    }

    private void saveData() {
        saveCustomers();
        saveSupportEngineers();
    }

    private void saveCustomers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMER_LIST_FILE))){
            for (int i = 0; i < customerList.getSize(); i++) {
                Customer c = customerList.get(i);
                writer.write(c.getName() + "," + c.getId() + "," + c.getPassword() + "," + c.getEmail() + "," +
                        c.getIssue().getTitle() + "," + c.getIssue().getIssueDescription() + "," +
                        c.getIssue().getTicketNumber() + "," + c.getIssue().getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
                    supportEngineerList.getElement(supportEngineer);
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


    private boolean signUpPage(BufferedReader reader, boolean isSupportEngineer) {
        System.out.println(BOLD + "SIGNING UP... " + RESET);

        String id;
        if (isSupportEngineer)
            id = String.valueOf(supportEngineerList.getSize() + 1);
        else
            id = String.valueOf(customerList.getSize() + 1);

        System.out.println("Your ID will be '" + id + "'. " );
        String name = readString("Name: ", reader);
        String password;
        while (true) {
            password = readString("Set a strong password: ", reader);
            String rePassword = readString("Retype your password: ", reader);

            if (!password.equals(rePassword))
                System.out.println("Passwords didn't match. Try again. ");
            else if (password.length() < 8)
                System.out.println("Password is weak. The password should contain at least 8 characters. Try again. ");
            else
                break;
        }
        String email = readString("Email: ", reader);
        while (true){
            byte confirmation = readByte("Confirm Account Creation? \nProceed(1) or Cancel(0): ", reader);
            System.out.println();
            if (confirmation == 1)
                break;
            else if (confirmation == 0) {
                System.out.println(BOLD + "Account not created. \n" + RESET);
                return false;
            }
        }

        if (isSupportEngineer){
            SupportEngineer supportEngineer = new SupportEngineer(name, id, password, email);
            supportEngineerList.insert(supportEngineer);
        } else {
            Customer customer = new Customer(name, id, password, email);
            customerList.insert(customer);
            currentCustomerUser = customer;
        }
        System.out.println(BOLD + GREEN + "ACCOUNT SUCCESSFULLY CREATED AND SIGNED UP! \n" + RESET);
        return true;
    }


    private String readString(String prompt, BufferedReader reader) {
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            try {
                input = reader.readLine();
                // Check if input contains a comma
                if (input.contains(",")) {
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



    private void showSupportEngineerEnd(BufferedReader reader) {
        System.out.println(BOLD + "\nSUPPORT ENGINEER'S END. " + RESET);
        while (true) {
            System.out.print("""
                    \nNothing yet to browse here......
                    Choose an Action:
                    1. View pending support tickets
                    2. Resolve an issue
                    3. Log out and Exit
                    """);

            byte choice = readByte("", reader);

            switch (choice) {
                case 1 -> showPendingSupportTickets();
                case 2 -> resolveAnIssue(reader);
                case 3 -> {
                    System.out.println("\n");
                    return;
                }
            }
        }

    }

    private void showPendingSupportTickets() {
        if (supportTickets.getSize() == 0) {
            System.out.println(BOLD + "There are no issues yet to solve. " + RESET);
            return;
        }

        System.out.printf(BOLD + "%-15s%-25s%-15s%-25s%n", "Ticket Number", "Title", "Status", "Customer" + RESET);
        for (int i = 0; i < supportTickets.getSize(); i++) {
            SupportTicket st = supportTickets.get(i);
            System.out.printf("%-15s%-25s%-15s%-25s%n", st.getTicketNumber(), st.getTitle(), st.getStatus(), st.getCustomer().getName());
        }
        System.out.println();
    }

    private void resolveAnIssue(BufferedReader reader) {
        if (supportTickets.getSize() == 0) {
            System.out.println(BOLD + "There are no issues yet to solve. " + RESET);
            return;
        }
        System.out.println(BOLD + "SUPPORT TICKET TO SOLVE: " + RESET);
        System.out.println(supportTickets.get(0).toString()); // retrieve the first element

        String status = readString("\nIssue Solved(Y) or (N)? :", reader);
        if (status.equalsIgnoreCase("Y")) {
            supportTickets.get(0).setStatus("Solved");
            supportTickets.delete(supportTickets.get(0));
            System.out.println(BOLD + "The issue is successfully solved! " + RESET);
        }
    }

    private void showCustomerEnd(BufferedReader reader) {
        while (true) {
            System.out.print("""
                    Nothing yet to browse here......
                    Choose an Action:
                    1. Submit a Support Ticker
                    2. Log out and Exit
                    """);

            byte choice = readByte("", reader);

            if (choice == 1) {
                if (currentCustomerUser.getIssue() == null) {
                    String title = readString("Enter the title for your Ticket: ", reader);
                    String issueDescription = readString("Description of the Issue: ", reader);
                    int issueNumber = supportTickets.getSize() + 1;
                    String status = "Open";
                    System.out.println("The issue number for your support ticket is " + issueNumber);

                    SupportTicket supportTicket = new SupportTicket(customerList.getElement(currentCustomerUser), title, issueDescription, issueNumber, status);
                    customerList.getElement(currentCustomerUser).setIssue(supportTicket);
                    supportTickets.insert(supportTicket);
                    System.out.println(BOLD + "Your ticket support has been successfully submitted. Please wait for at least 48 hours. "  + "\n" + RESET);
                } else {
                    System.out.println("You have a pending ticket support submission: ");
                    System.out.println(currentCustomerUser.getIssue().toString() + "\n");

                    String choice1 = readString("Remove Support Ticket, Yes(Y) or No(N)?: ", reader);

                    if (choice1.equalsIgnoreCase("Y")) {
                        customerList.getElement(currentCustomerUser).setIssue(null);
                        System.out.println(BOLD + "Ticket issue has been removed. \n" + RESET);
                        return;
                    }
                    System.out.println("\n");
                }
            }
            else {
                System.out.println("\n");
                return;
            }

        }
    }
}
