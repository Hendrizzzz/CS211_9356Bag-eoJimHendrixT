# FileEditor Program

## Overview

The `FileEditor` program is a simple text file manager built in Java. It allows users to create, open, edit, view past versions, and delete text files. The program also implements a custom doubly linked list data structure (`MyDoublyLinkedList`) to manage the storage of text files efficiently.

## Program Structure

### Main Class: `FileEditor`
The main class of the program is `FileEditor`. It controls the overall flow of the program and manages the user interaction with the following features:

- **Create a New File**: Create and store new text files.
- **Open a File**: Open existing files, edit them, and view past versions.
- **Delete a File**: Delete existing files.
- **Exit**: Save the data and exit the program.

### Reference Class: `TextFile`
The `TextFile` class represents an individual text file. Each text file has the following attributes:

- **Title**: The name of the text file.
- **Contents**: The content of the text file.
- **Last Modified Date**: The timestamp of the last modification.
- **Versions**: A history of past versions of the text file.

### Custom Data Structure: `MyDoublyLinkedList<T>`
The program uses a custom (my) implementation of a doubly linked list (`MyDoublyLinkedList<T>`) to store instances of `TextFile`. The doubly linked list provides efficient insertion and deletion operations, which are useful for handling the dynamic list of text files and their versions. It supports:

- **Insertion**: Adds a new item to the list.
- **Deletion**: Removes an item from the list.
- **Access**: Retrieves items based on their index.

## Program Flow

1. **Startup**: When the program starts, it reads data from a file (if available) to load previously created text files into memory.
2. **User Menu**: The user is presented with a menu to choose an action:
    - **Create a New File**: Prompts the user to enter a title and content for the new file. The file is then added to the doubly linked list.
    - **Open a File**: Displays a list of all available files. The user can select a file to view its contents, edit it, or view past versions. Any changes are saved as a new version.
    - **Delete a File**: Prompts the user to enter the title of the file to delete. The program then removes the file from the doubly linked list.
    - **Exit**: Saves all data to a file and exits the program.
3. **File Management**: The program provides functionality to edit files, view past versions, and restore files to previous versions.
4. **Exit and Save**: Upon exiting, the program saves the current state of the text files for future sessions.

## Files and Classes

### `FileEditor`
The main entry point for the program. It contains the logic for handling user input, file creation, file editing, file deletion, and version management.

### `TextFile`
A class that represents a text file. It stores the title, contents, last modified date, and past versions of the file.

### `MyDoublyLinkedList<T>`
A custom implementation of a doubly linked list used to manage the collection of `TextFile` objects. This class provides basic operations like insertion, deletion, and retrieval.

### `MyDoublyLinkedList<T>`
A custom implementation of a doubly linked list used to manage the collection of `TextFile` objects. This class provides basic operations like insertion, deletion, and retrieval, ensuring efficient management of the text files.

## How the Custom Doubly Linked List is Used

1. **Managing Versions**: Each TextFile in the list has an attribute MyDoublyLinkedList<TextFile> which contains the past versions of that file. When a file is edited, a new version is created and stored in the doubly linked list associated with that file. This allows efficient access to both the current version and past versions of the file.

2. **Adding New Files**: When a new file is created, it is added as a node in the doubly linked list. Each node in the list contains a reference to a TextFile object. The new node is linked to the previous and next nodes, maintaining the bidirectional chain of the list.

3. **Traversing Files**: The doubly linked list allows the program to traverse files in both directions. For example, when the user selects an option to view files, the program can iterate through the list from the head node to display the files in order. This traversal capability also enables the program to access specific files quickly.

4. **Deleting Files**: When a file is deleted, the corresponding node is removed from the doubly linked list. The removal operation adjusts the links between the neighboring nodes, ensuring the continuity of the list while removing the reference to the deleted file.

