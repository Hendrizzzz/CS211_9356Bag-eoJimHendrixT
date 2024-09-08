# MVP Ladder Generator

## Overview

This program is designed to calculate and generate a Most Valuable Player (MVP) ladder based on player performance stats from a single game. It ranks players based on their performance metrics, allowing for a clear view of the top performers in the game.

## Classes

- **MVPLadderGenerator** - Manages the program loop, user input, and MVP ladder generation.
- **Player** - Represents a player with attributes like name, ID, and performance statistics.
- **PlayerStats** - Represents the performance metrics of a player, such as points scored, assists, and rebounds.
- **MVP** - Represents the MVP ranking, with attributes like player, rank, and score.

## Files

- **PLAYER_LIST_FILE** - Stores player data.
- **PLAYER_STATS_FILE** - Stores performance statistics for each player.
- **MVP_LADDER_FILE** - Stores the generated MVP ladder.

## Program Flow

### User Input:

- Users provide performance stats for each player.
- The system calculates the MVP rankings based on these stats.

### MVP Ladder Generation:

- Calculate scores for each player based on their performance metrics.
- Rank players from highest to lowest score to generate the MVP ladder.

### Display Rankings:

- Display the MVP ladder showing the top performers and their scores.

## Pseudocode

### 1. Main Class Structure
MVPLadderGenerator
- **Variables:**
    - `playerList`: List/array to store player details.
    - `playerStatsList`: List/array to store player performance stats.
    - `mvpLadder`: List/array to store the generated MVP rankings.

### 2. Menu Display Functionality
`displayMenu()`
- Display options for the user to input player stats or view the MVP ladder.
- Options:
    - Input Player Stats
    - View MVP Ladder
    - Exit

### 3. User Input Functions
`readString(prompt, reader)`
- Read a string input from the user.
- Return the valid input string.

`readDouble(prompt, reader)`
- Read a double input from the user for performance metrics.
- Handle invalid inputs and prompt for retry.
- Return the valid double input.

### 4. MVP Ladder Generation Functions
`generateMVP()`
- Calculate scores for each player based on performance metrics.
- Rank players and generate the MVP ladder.

`displayMVPLadder()`
- Display the MVP ladder showing the rankings and scores of the top players.

### 5. Helper Functions
`findPlayerByID(playerID)`
- Search for a player by their ID.
- Return the Player object if found, or null if not found.

`calculatePlayerScore(playerStats)`
- Calculate the total score for a player based on their performance metrics.
- Return the calculated score.

## Notes

- The program ensures that inputs are validated and error handling is implemented.
- The performance metrics are used to calculate scores and rank players.
- The MVP ladder is generated and displayed based on the calculated scores.
- Ensure that player data and performance stats are correctly formatted and accurate for proper ladder generation.
