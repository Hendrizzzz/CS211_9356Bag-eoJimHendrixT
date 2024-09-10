# Doubly Linked Circular List Implementation Testing

This document provides a comprehensive guide to testing the functionality of a custom doubly linked circular list implementation. The features tested include adding and deleting elements, traversing the list in both directions, searching for elements by value, accessing elements by index, and viewing the list’s head, tail, and size.

## Features Tested

1. **Add Integer**
2. **Delete Integer**
3. **Show List**
4. **Traverse List Tail to Head**
5. **Traverse List Twice**
6. **Visit Nodes x Times**
7. **Search for Element's Position**
8. **Get Element at Index**
9. **View Head**
10. **View Tail**
11. **Get Size**
12. **Quit**

## Testing Overview

### 1. Adding Integers

**Objective:** Test the ability to insert multiple integers into the doubly linked circular list.

**Procedure:**

1. Start the program.
2. Choose the option to add integers.
3. Input the number of integers to add.
4. Enter each integer value.

**Simulation:**

```plaintext
1. Add integer
2. Delete integer
3. Show List
4. Traverse List Tail to Head
5. Traverse LinkedList twice
6. Visit nodes x times
7. Search for element's position
8. Get element at index
9. View Head
10. View Tail
11. Get Size
12. Quit

1
How many integers to add: 10
Integer to Add (index 0): 1
Integer to Add (index 1): 2
Integer to Add (index 2): 3
Integer to Add (index 3): 4
Integer to Add (index 4): 5
Integer to Add (index 5): 6
Integer to Add (index 6): 7
Integer to Add (index 7): 8
Integer to Add (index 8): 9
Integer to Add (index 9): 10
```

**Verification**
```plaintext
Option 3: (Show List)
Traversing from head to tail: 
t <- Head -> 1  <-->  2  <-->  3  <-->  4  <-->  5  <-->  6  <-->  7  <-->  8  <-->  9  <-->  10 <- Tail -> h
```


### 2. Deleting Elements
**Objective:** Test the ability to delete an element from the doubly linked circular list.

**Procedure:**

1. Choose the option to delete an element.
2. Enter the value of the element to delete.

**Expected Result:** The specified element is removed from the list if it exists.

**Simulation:**

```plaintext
Option 2: (Delete Integer)
Integer to Delete: 7
Deletion Success.
```

**Verification**
```plaintext
Option 3: (Show List)
Traversing from head to tail: 
t <- Head -> 1  <-->  2  <-->  3  <-->  4  <-->  5  <-->  6  <-->  8  <-->  9  <-->  10 <- Tail -> h
```

### 3. Traversing the List (Head to Tail)
**Objective:** Test the ability to traverse the list from the head to the tail and display all elements.

**Procedure:**

1. Choose the option to traverse the list.
2. View the elements as they are printed from head to tail.

**Expected Result:** The list should be displayed in the correct order, starting from the head.

**Simulation:**

```plaintext
Traversing from head to tail: 
t <- Head -> 1  <-->  2  <-->  3  <-->  4  <-->  5  <-->  6  <-->  8  <-->  9  <-->  10 <- Tail -> h
```

### 4. Traversing the List (Tail to Head)
**Objective:** Test the ability to traverse the list from tail to head.

**Procedure:**

1. Choose the option to traverse the list in reverse.

**Simulation:**

```plaintext
4
Traversing from tail to head: 
h <- Tail -> 10  <-->  9  <-->  8  <-->  6  <-->  5  <-->  4  <-->  3  <-->  2  <-->  1 <- Head -> t
```


### 7. Searching for an Element's Position
   **Objective:** Test the ability to find the position of a specific element.

**Procedure:**

1. Choose the option to search for an element’s position.
2. Enter the integer to search.

**Simulation:**

```plaintext
7
Enter the integer to search (returns the index): 5
The integer 5 is found at index 4
```

**Verification**
```plaintext
Option 3: (Show List)
Traversing from head to tail: 
t <- Head -> 1  <-->  2  <-->  3  <-->  4  <-->  5  <-->  6  <-->  8  <-->  9  <-->  10 <- Tail -> h
```


### 8. Getting an Element at a Specific Index
**Objective**: Test the ability to get an element by its index.

**Procedure:**

1. Choose the option to get an element at a specific index.
2. Enter the index value.

**Simulation:**

```plaintext
8
Enter the index: 8
There is no index 8 yet in the list. 

8
Enter the index: 7
The number at index 7 is 9
```

**Verification**
```plaintext
Option 3: (Show List)
Traversing from head to tail: 
t <- Head -> 1  <-->  2  <-->  3  <-->  4  <-->  5  <-->  6  <-->  8  <-->  9  <-->  10 <- Tail -> h
```


### 9. Viewing the Head
**Objective:** Test the ability to view the head of the list.

**Procedure:**

1. Choose the option to view the head.

**Simulation:**

```plaintext
9
Head: 1
```


### 10. Viewing the Tail
**Objective:** Test the ability to view the tail of the list.

**Procedure:**

1. Choose the option to view the tail.

**Simulation:**

```plaintext
10
Tail: 9
```


### 11. Getting the Size of the List. Viewing the Head
**Objective:** Test the ability to get the size of the list.

**Procedure:**

1. Choose the option to get the size of the list.

**Simulation:**

```plaintext
11
Size: 8
```



