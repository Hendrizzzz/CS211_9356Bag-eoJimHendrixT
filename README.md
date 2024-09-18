# Java Data Structures Project

#### This project, "Project 1 of the Prelims in Data Structures," demonstrates the implementation of various data structures, including linked lists and dynamic arrays, in Java. 

## Project Structure

### Packages and Classes

####  **prelim Package**
- This package serves as the primary container for different sub-packages and core classes related to data structures.


#### 1. **Classes/Interfaces just under the Prelim Package**
- **ListOverflowException**: Custom exception to handle overflow cases in data structures.
- **MyLinkedList, MyArrayList**: Custom implementations of linked lists and array lists.
- **CustomInteger**: Custom class to handle integer-based operations.
- **MyList, DoublyLinkedNode**: Interfaces for linked lists and doubly linked list nodes.
- **MainTester**: Main tester class to run various data structure tests.


#### 2. **CircularLinkedList Package**
- **Classes:**
    - `Song`: Represents a song object.
    - `MusicPlayer`: Main class that utilizes circular linked list functionality.
    - `PreMadeTester`: A tester class to demonstrate linked list behavior.
    - `MyDoublyLinkedCircularList`: Custom implementation of a circular doubly linked list.
    - `Tester`: Main tester class for the circular linked list implementation.
- **Resources:**
    - `StockedSongs.txt`: Pre-loaded data for testing the circular linked list.
    - `Songs.txt`: Input data for the music player application.
- **Documentation Files:**
    - `APPLICATION_SIMULATION.MD`: Simulates the application scenario for the circular linked list.
    - `APPLICATION_OVERVIEW.MD`: Overview of how the circular linked list functions.
    - `CIRCULAR_LINKEDLIST_TEST.MD`: Testing details for the circular linked list.

#### 3. **DoublyLinkedList Package**
- **Classes:**
    - `FileEditor`: Implements file editing functionality.
    - `TextFile`: Represents a text file object.
    - `PreMadeTester`: A tester for the doubly linked list.
    - `MyDoublyLinkedList`: Custom implementation of a doubly linked list.
    - `Tester`: Main tester class for the doubly linked list.
- **Documentation Files:**
    - `APPLICATION_SIMULATION.MD`: Simulates the application scenario for the doubly linked list.
    - `APPLICATION_OVERVIEW.MD`: Overview of how the doubly linked list functions.
    - `DOUBLYLINKEDLIST_TEST.MD`: Testing details for the doubly linked list.

#### 4. **LinkedList Package**
- **Classes:**
    - `SupportEngineer`: Represents a support engineer responsible for handling customer tickets.
    - `SupportTicket`: Represents a customer support ticket with details of the issue.
    - `CustomerSupportTicketSystem`: Main system class that handles support tickets using a singly linked list structure.
    - `Customer`: Represents a customer raising support tickets.
    - `Node`: A generic node class used in the linked list implementation.
    - `Tester`: Tester class for the linked list implementation.
    - `MySinglyLinkedList`: Custom implementation of a singly linked list.

- **Resources:**
    - **Database Package:**
        - `SupportEngineers.txt`: Stores data of support engineers for the system.
        - `SupportTickets.txt`: Pre-loaded customer support tickets for testing.
        - `Customers.txt`: Stores customer information for generating tickets.

- **Documentation Files:**
    - `APPLICATION_SIMULATION.MD`: Simulates the application scenario for the linked list.
    - `APPLICATION_OVERVIEW.MD`: Overview of how the linked list functions.
    - `LINKEDLIST_TEST.MD`: Testing details for the linked list implementation.


#### 5. **DynamicArray Package**
- **Classes:**
    - `MyGrowingArrayList`: Custom implementation of a dynamic array (similar to an ArrayList).
    - `AccountWarden`: The main class responsible for handling accounts in a dynamic array.
    - `Account`: Represents an account object.
    - `Tester`: Tests the dynamic array functionality.
- **Resources:**
    - `Accounts.txt`: Stores account data for the `AccountWarden`.
- **Documentation Files:**
    - `APPLICATION_SIMULATION.MD`: Simulation for the dynamic array application.
    - `APPLICATION_OVERVIEW.MD`: Overview of the dynamic array structure and usage.
    - `ARRAYLIST_TEST.MD`: Testing documentation for the dynamic array.

#### 6. **FixedArray Package**
- **Classes:**
    - `MyFixedArrayList`: Custom implementation of a fixed-size array.
    - `Player`: Represents a player object.
    - `MVPLadderGenerator`: The main class for generating MVP ladders using a fixed array.
    - `Tester`: Tester class for fixed array functionality.
- **Resources:**
    - `Players.txt`: Stores player data for the `MVPLadderGenerator`.
- **Documentation Files:**
    - `APPLICATION_SIMULATION.MD`: Simulation for the fixed array application.
    - `APPLICATION_OVERVIEW.MD`: Overview of the fixed array structure and usage.
    - `FIXEDARRAY_TEST.MD`: Testing documentation for the fixed array.


### Additional Files
- `.gitattributes`: Git configuration for managing large file storage and attributes.
- `allclasses-index.html`: Auto-generated HTML file listing all classes within the project.
- `CS211_9356Bag-eoJimHendrixT.zip`: Compressed archive of project resources.

## How to Run the Project
1. **To run the tester classes**, execute the `MainTester` class, which is located directly under the `prelim` package (outside of any specific sub-package). This class contains the `main` method and will run tests across all implemented data structures.
2. The individual tester classes (e.g., `Tester` in `CircularLinkedList`, `Tester` in `DoublyLinkedList`, etc.) are designed to support the testing process but **do not contain a `main` method**. They are invoked through the `MainTester` class.
3. Input files like `Songs.txt`, `Accounts.txt`, and `Players.txt` are pre-loaded with data. You may modify them to test additional cases.


## Documentation
Each package includes markdown files that explain the implementation, simulation, and testing of the data structures. Review these files for a better understanding of how the code is organized:
- `APPLICATION_SIMULATION.MD`: Provides a detailed simulation of the application scenario.
- `APPLICATION_OVERVIEW.MD`: High-level overview of each data structure.
- `TEST.MD`: Explanation of test cases and expected results.

