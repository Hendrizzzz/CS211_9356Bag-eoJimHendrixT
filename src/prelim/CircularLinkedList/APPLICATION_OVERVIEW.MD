# MusicPlayer Program

## Overview

The `MusicPlayer` program is a simple Java application designed for managing and interacting with a collection of songs. It allows users to create, delete, view, and play songs using a custom circular doubly linked list (`MyDoublyLinkedCircularList`). Additionally, the program supports downloading songs from a file and efficiently manages song data.

## Features

- **Create a Song**: Add new songs to the playlist.
- **Delete a Song**: Remove existing songs from the playlist.
- **View Song List**: Display a list of all songs in the playlist.
- **Download Stock Songs**: Load a predefined set of songs from a file.
- **Play a Song**: Play a specific song from the playlist.
- **Play All Songs**: Play all songs in the playlist sequentially with an option to continue.
- **Exit**: Save current data and exit the program.

## Program Structure

### Main Class: `MusicPlayer`

The `MusicPlayer` class controls the program flow and user interactions. It manages the following functionalities:

- **Create a Song**: Prompts the user to enter details for a new song and adds it to the circular linked list.
- **Delete a Song**: Allows the user to delete a song by specifying its title and artist.
- **View Song List**: Displays the list of all songs in the circular linked list.
- **Download Stock Songs**: Reads a file containing predefined songs and adds them to the playlist.
- **Play a Song**: Plays a selected song from the playlist.
- **Play All Songs**: Plays all songs in the playlist, with an option to continue playing the list.
- **Exit**: Saves data to a file and exits the application.

### Reference Class: `Song`

The `Song` class represents an individual song with the following attributes:

- **Title**: The title of the song.
- **Artist**: The artist of the song.

It also includes methods for playing the song.

### Custom Data Structure: `MyDoublyLinkedCircularList<T>`

The program utilizes a custom circular doubly linked list (`MyDoublyLinkedCircularList<T>`) to store instances of `Song`. This data structure supports:

- **Insertion**: Adding new songs to the list.
- **Deletion**: Removing songs from the list.
- **Traversal**: Iterating through the list to access and play songs.

## Program Flow

1. **Startup**: On startup, the program reads existing song data from a file (if available) to initialize the playlist.
2. **User Menu**: The user is presented with a menu to choose an action:
    - **Create a Song**: Input details for a new song and add it to the list.
    - **Delete a Song**: Remove a specified song from the playlist.
    - **View Song List**: Display all songs currently in the playlist.
    - **Download Stock Songs**: Load songs from a predefined file into the playlist.
    - **Play a Song**: Play a specific song based on user input.
    - **Play All Songs**: Play all songs in the playlist with an option to continue.
    - **Exit**: Save the current state and exit the program.
3. **File Management**: The program reads from and writes to files to manage song data, including the initial song list and downloaded stock songs.
4. **Exit and Save**: Before exiting, the program saves the current state of the song playlist for future use.


## File Structure

- `src/prelim/CircularLinkedList/`: Source files for the program.
- `src/prelim/CircularLinkedList/Songs.txt`: File containing existing songs to be loaded on startup.
- `src/prelim/CircularLinkedList/StockedSongs.txt`: File containing stock songs to be downloaded.

