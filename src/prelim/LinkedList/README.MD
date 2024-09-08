# Support Ticket Management System

## Overview
This program is designed to manage support tickets submitted by customers and resolved by support engineers. It features separate menus for customers and support engineers, allowing them to submit issues, view submitted or pending tickets, and resolve open issues.

## **Classes:**

* `CustomerSupportTicketSystem` - Manages the program loop, user login/signup, and data persistence.
* `Customer` - Represents a customer with attributes like name, ID, password, email, and an associated support ticket (optional).
* `SupportEngineer` - Represents a support engineer with attributes like name, ID, password, and email.
* `SupportTicket` - Represents a support ticket with attributes like customer, title, description, ticket number, and status.
* `MySinglyLinkedList`  - A custom implementation of a singly-linked list used to manage customers, engineers, and tickets.

## **Files:**

* `CUSTOMER_LIST_FILE` - Stores customer data.
* `SUPPORT_ENGINEER_LIST_FILE` - Stores support engineer data.
* `SUPPORT_TICKETS_LIST_FILE` - Stores support ticket data.

## Program Flow
1. **User Login:**
    - Depending on the user role (Support Engineer or Customer), the corresponding menu is displayed.

2. **Support Engineer Actions:**
    - Support engineers can view all issues, view pending or solved issues, and resolve open issues.

3. **Customer Actions:**
    - Customers can submit new issues, view submitted issues, and update the status of their issues.

4. **Issue Management:**
    - Support tickets are tracked through their statuses (Open, Solved).
    - Customers can update their issues, while support engineers can resolve them.

5. **Logout:**
    - Both customers and support engineers have the option to log out of the system.


## Pseudocode

### 1. Main Class Structure
- **Support Ticket Management System**
    - Variables:
        - `currentSupportEngineerUser`: Holds the currently logged-in support engineer.
        - `currentCustomerUser`: Holds the currently logged-in customer.
        - `supportTickets`: List/array to store submitted support tickets.
        - `customerList`: List/array to store customer details.

### 2. Menu Display Functionality
- **`displayMenu(isSupportEngineer)`**
    - Display menu options based on user role (Support Engineer or Customer).
    - Support Engineer Menu Options:
        1. View All Submitted Issues
        2. View Pending Issues
        3. View Solved Issues
        4. Resolve an Issue
        5. Logout
    - Customer Menu Options:
        1. Submit New Issue
        2. View Submitted Issues
        3. Update Issue Status
        4. Logout

### 3. User Input Functions
- **`readString(prompt, reader)`**
    - Read a string input from the user.
    - Ensure that the input does not contain commas.
    - Return valid input string.

- **`readByte(prompt, reader)`**
    - Read a byte input from the user.
    - Handle invalid inputs and prompt for retry.
    - Return the valid byte input.

### 4. Support Engineer End Functions
- **`showSupportEngineerEnd(reader)`**
    - Display support engineer menu and handle user selections.
    - Perform actions such as viewing submitted, pending, or solved issues, and resolving open issues.

- **`showAllSubmittedSupportTickets()`**
    - Display a list of all submitted support tickets.
    - If no tickets are available, print a message indicating no issues have been submitted.

- **`showPendingIssues()`**
    - Display a list of all pending (open) support tickets.
    - If no pending tickets are available, print a message indicating no issues are yet to solve.

- **`showSolvedIssues()`**
    - Display a list of all solved support tickets.
    - If no solved tickets are available, print a message indicating no issues have been solved yet.

- **`resolveAnIssue(reader)`**
    - Find the first open support ticket and display it.
    - Prompt the support engineer to resolve the issue.
    - Update the ticket status to "Solved" if the issue is resolved.

### 5. Customer End Functions
- **`showCustomerEnd(reader)`**
    - Display customer menu and handle user selections.
    - Perform actions such as submitting a new issue, viewing submitted issues, and updating issue status.

- **`submitNewIssue(reader)`**
    - Prompt the customer to enter the title and description of the new issue.
    - Create a new support ticket and add it to the `supportTickets` list.
    - Confirm successful submission to the customer.

- **`viewSubmittedIssues()`**
    - Display all issues submitted by the current customer.
    - If no issues have been submitted, print a message indicating so.

- **`updateIssueStatus(reader)`**
    - Prompt the customer to enter the ticket number for the issue to update.
    - Find the support ticket and allow the customer to update its status.
    - Confirm the status update with the customer.

### 6. Helper Functions
- **`findSupportTicketByNumber(ticketNumber)`**
    - Search for a support ticket by its ticket number.
    - Return the `SupportTicket` object if found, or `null` if not found.


## Notes
- The system ensures that inputs from users are validated, and error handling is in place.
- Commas in user input are restricted to prevent issues with CSV processing.
- Not perfect program.
