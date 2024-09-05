# AccountWarden Program Algorithm


The `AccountWarden` class manages user accounts, allowing users to add, remove, view, and save account information. The program interacts with a file to persist account data and utilizes a growing array list to manage accounts in memory.

## Run Method

- **Initialize Program**: Instantiate `AccountWarden` and start the main loop.
- **Read Data**: Load existing account data from the file.
- **Main Menu Loop**: Continuously prompt the user to select actions such as adding or removing accounts.

## 1. Initialization

- **Define Constants**: Set ANSI escape codes for text formatting (e.g., bold, green, red).
- **File Path**: Specify the path for storing account data (`src/prelim/DynamicArray/Accounts.txt`).
- **Data Structure**: Initialize `accounts` as a `MyGrowingArrayList<Account>` to manage account objects.
- **BufferedReader**: Prepare a `BufferedReader` for user input.

## 2. Main Method

- **Create Instance**: Instantiate `AccountWarden`.
- **Invoke `run()`**: Start the main loop of the program.

## 3. Run Method

- **Read Data**: Call `readData()` to load account information from the file into memory.
- **Display Menu**: Use `showMenu()` to present options to the user.
- **Main Menu Loop**:
    - Continuously prompt the user to choose an action:
        - **Add Account**: Call `addAccount()` to add a new account.
        - **Remove Account**: Call `removeAccount()` to remove an existing account.
        - **View Accounts**: Call `viewAccounts()` to display all accounts without passwords.
        - **View Accounts with Passwords**: Call `viewAccountsWithPasswords()` to display all accounts with passwords.
        - **Save Changes**: Call `saveChanges()` to write account data to the file.
        - **Exit**: Terminate the program.

## 4. Read Data

- **Open File**: Create `BufferedReader` to read from `FILE_PATH`.
- **Process File Content**:
    - For each line, split by commas to extract account details.
    - Create `Account` objects and insert them into the `accounts` list.
- **Handle Exceptions**: Catch and handle `IOException`.

## 5. Read Choice

- **Display Menu**: Show available actions to the user.
- **Validate Input**: Ensure the user’s choice is a valid byte (1-6).

## 6. Show Menu

- **Menu Options**: Display options for user actions.

## 7. Press Enter

- **Prompt User**: Ask the user to press Enter to continue after each action.

## 8. Add Account

- **Input Details**: Prompt the user to enter account details (email, username, password).
- **Create Account Object**: Instantiate an `Account` object and add it to the list.

## 9. Remove Account

- **Input Details**: Prompt the user to enter the email and username of the account to remove.
- **Remove Account**: Attempt to remove the account from the list and provide feedback on the result.

## 10. View Accounts

- **Display Accounts**: Iterate over the `accounts` list and display account details without passwords.

## 11. View Accounts with Passwords

- **Display Accounts**: Iterate over the `accounts` list and display account details including passwords.

## 12. Save Changes

- **Open File**: Create `BufferedWriter` to write to `FILE_PATH`.
- **Write Data**: Write each account’s details to the file, formatted as CSV.
- **Handle Exceptions**: Catch and handle `IOException`.

## 13. Read String

- **Input Validation**: Read and return a non-empty string from the user.

