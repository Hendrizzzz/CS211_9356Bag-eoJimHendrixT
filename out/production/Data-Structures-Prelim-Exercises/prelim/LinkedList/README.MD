# CustomerSupportTicketSystem Program Algorithm

## 1. Initialization

- **Setup Constants**: Define ANSI escape codes, file paths, and initialize linked lists.
- **Variables**: Set variables for the current logged-in user (customer or support engineer).

## 2. Start Main Program

- **Create Instance**: Instantiate the `CustomerSupportTicketSystem` class.
- **Run Method**: Call the `run` method to start the main program loop.

## 3. Run Method Execution

- **Load Previous Data**:
    - **Read Support Tickets**: Load support tickets from file using `readSupportTickets`.
    - **Read Support Engineers**: Load support engineers from file using `readSupportEngineers`.
    - **Read Customers**: Load customers and their associated support tickets from file using `readCustomers`.

- **Main Menu Loop**:
    - Continuously prompt the user to choose between Support Engineer, Customer, or Save and Exit.
    - Handle user input based on the selected option:
        - **If Support Engineer**:
            - Call `handleSupportEngineer` to manage support engineer tasks.
        - **If Customer**:
            - Call `handleCustomer` to manage customer tasks.
        - **If Save and Exit**:
            - Call `saveData` to save current data to files.
            - Exit the program.

## 4. Handle Support Engineer Tasks

- Prompt the support engineer for actions (e.g., view tickets, update ticket status).
- Perform the selected action using appropriate methods.
- Return to the main menu after completing the task.

## 5. Handle Customer Tasks

- Prompt the customer for actions (e.g., submit a ticket, view ticket status).
- Perform the selected action using appropriate methods.
- Return to the main menu after completing the task.

## 6. Save Data

- Call `saveSupportTickets` to save support tickets to file.
- Call `saveSupportEngineers` to save support engineers to file.
- Call `saveCustomers` to save customers and their associated tickets to file.

## 7. Exit Program

- Perform any necessary cleanup operations (e.g., closing files).
- End the program.
