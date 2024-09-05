# MVPLadderGenerator Program Algorithm

## Overview

The `MVPLadderGenerator` class generates an MVP ladder for basketball players based on their performance in a single game. The program allows users to input player data, sort players by their MVP score, and save the data.

## Run Method

- **Display Introduction**: Show introductory messages about the program and its context.


## 1. Initialization

- **Setup Constants**: Define ANSI escape codes and initialize a fixed-size array list for players.
- **Variables**: Set up a `BufferedReader` for user input.

## 2. Main Method

- **Create Instance**: Instantiate `MVPLadderGenerator`.
- **Start Thread**: Run the `MVPLadderGenerator` in a separate thread.
- **Join Thread**: Wait for the thread to complete.
- **Start Program**: Call the `start` method to begin the program.

## 3. Start Method

- **Press Enter**: Prompt user to press Enter to continue.
- **Read Players**: Load player data from file.
- **Display Header**: Show the program title and instructions.

- **Main Menu Loop**:
    - Continuously prompt the user to choose from the following options:
        - **Fill Players**: Complete entry for 5 players.
        - **Add 1 Player**: Add a single player to the list.
        - **Remove 1 Player**: Remove a player from the list.
        - **Check a Player**: Display details of a player.
        - **Clear All Players**: Clear the list of all players.
        - **Show MVP Ladder**: Display the MVP ladder.
        - **Save and Exit**: Save player data and exit.
        - **Don't Save and Quit**: Exit without saving.

## 4. Read Players

- **Load Data**: Read player data from `Players.txt` and populate the player list.
- **Handle Exceptions**: Manage file read errors and list overflow exceptions.

## 5. Read Choice

- **Display Menu**: Show the available options to the user.
- **Validate Input**: Ensure user input is a valid choice (1-8).

## 6. Show Menu

- **Menu Options**: Display options for user actions.

## 7. Press Enter

- **Prompt User**: Ask the user to press Enter to proceed.

## 8. Read Player

- **Input Player Details**: Prompt user to enter details for a player and return a `Player` object.

## 9. Read Position

- **Validate Position**: Ensure the player’s position is within the valid range (1-5).

## 10. Read String

- **Input Validation**: Ensure the user’s input is a non-empty string.

## 11. Read Byte

- **Input Validation**: Read and validate a byte value, ensuring it meets required conditions.

## 12. Fill Players

- **Add 5 Players**: Prompt user to enter details for 5 players.

## 13. Add 1 Player

- **Add Player**: Add a single player to the list.

## 14. Remove 1 Player

- **Remove Player**: Prompt user for player details and remove the player if found.

## 15. Form Player

- **Create Player Object**: Collect details to create a `Player` object for search or removal.

## 16. Check a Player

- **Search Player**: Find and display details of a player based on user input.

## 17. Clear All Players

- **Reset List**: Clear all players from the list.

## 18. Show MVP Ladder

- **Sort Players**: Sort players by MVP score in descending order.
- **Display Ladder**: Show the top 5 players in the MVP ladder.

## 19. Sort Players

- **Selection Sort**: Implement selection sort algorithm to sort players based on MVP scores.

## 20. Save

- **Save Data**: Write player data to `Players.txt` and exit the program.


