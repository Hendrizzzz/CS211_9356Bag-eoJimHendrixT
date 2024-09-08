# Account Warden

## Overview

**Account Warden** is a command-line application for managing user accounts. It allows users to add, remove, view, and save account details. Accounts are stored in a text file and managed using a custom implementation of a dynamic array list.

## Features

- **Add Account:** Add new accounts with email, username, and password.
- **Remove Account:** Remove existing accounts by email and username.
- **View Accounts:** View all accounts without passwords.
- **View Accounts with Passwords:** View all accounts with their passwords.
- **Save Changes:** Save all current account data to a file.
- **Exit:** Exit the application.

## Program Structure

### `AccountWarden` Class

This is the main class of the program, responsible for user interactions, file operations, and account management.

- **Constants:**
    - `BOLD`, `RESET`, `GREEN`, `RED`: Color codes for console text formatting.
    - `FILE_PATH`: Path to the file where accounts are stored.
    - `accounts`: An instance of `MyGrowingArrayList` that stores account objects.

- **Methods:**
    - `main(String[] args)`: Entry point of the application. Initializes the `AccountWarden` instance and starts the program.
    - `run()`: Main loop that handles user input and executes actions.
    - `readData()`: Reads account data from the file and populates the account list.
    - `readChoice(BufferedReader reader)`: Reads the user's choice from the console.
    - `showMenu()`: Displays the menu options to the user.
    - `addAccount(BufferedReader reader)`: Adds a new account based on user input.
    - `removeAccount(BufferedReader reader)`: Removes an existing account based on user input.
    - `viewAccounts(BufferedReader reader)`: Displays all accounts without passwords.
    - `viewAccountsWithPasswords(BufferedReader reader)`: Displays all accounts with passwords.
    - `saveChanges(BufferedReader reader)`: Saves all current account data to the file.
    - `pressEnterToContinue(BufferedReader reader)`: Prompts the user to press 'Enter' to continue.
    - `readString(BufferedReader reader)`: Reads a line of input from the user and trims leading and trailing whitespace.

### `Account` Class

The `Account` class represents a user account with the following attributes:

- **Attributes:**
    - `emailAddress`: The email address associated with the account.
    - `username`: The username associated with the account (can be empty if not applicable).
    - `password`: The password associated with the account.

- **Methods:**
    - `Account(String emailAddress, String username, String password)`: Constructor to initialize an account with email, username, and password.
    - `Account(String emailAddress, String username)`: Constructor to initialize an account with email and username (password is optional).
    - `getEmailAddress()`: Returns the email address of the account.
    - `getUsername()`: Returns the username of the account.
    - `getPassword()`: Returns the password of the account.
    - `toString()`: Returns a string representation of the account, including the password if specified.
    - `toString(boolean withPassword)`: Returns a string representation of the account, optionally including the password.

### `MyGrowingArrayList` Class

This custom class is a dynamic array list implementation used to store `Account` objects. It provides flexibility in managing accounts as the list grows or shrinks.

## Program Flow

1. **Initialization:**
    - The `main` method initializes the `AccountWarden` instance and calls the `run` method to start the program.

2. **Data Reading:**
    - The `readData` method is called to read existing account data from `Accounts.txt` and populate the `accounts` list.

3. **User Interaction:**
    - The `run` method enters a loop where it displays the menu and processes user choices:
        - **Add Account (1):** Prompts the user for account details and adds a new account to the list.
        - **Remove Account (2):** Prompts the user for account details and removes the account if it exists.
        - **View Accounts (3):** Displays all accounts without passwords.
        - **View Accounts with Passwords (4):** Displays all accounts with passwords.
        - **Save Changes (5):** Saves all current accounts to `Accounts.txt`.
        - **Exit (6):** Exits the application.

4. **End of Program:**
    - The program exits if the user selects the exit option. Changes to the account data are saved if the user chooses to save before exiting.

## Files

### `AccountWarden.java`

The main class file that contains the core logic of the application, including menu options, account management, and file operations.

### `MyGrowingArrayList.java`

A custom implementation of a dynamic array list used to manage the `Account` objects. This class provides methods to insert, delete, and access elements.

### `Account.java`

Defines the `Account` class with attributes such as email address, username, and password. Includes methods to handle account data and formatting.

### `Accounts.txt`

A text file where account data is stored. The file format is:
`email,`