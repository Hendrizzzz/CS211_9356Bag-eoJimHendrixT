# Doubly Linked List Implementation Testing

This document provides a comprehensive guide to testing the functionality of a custom doubly linked list implementation. The features tested include inserting elements, deleting elements, traversing the list from head to tail, traversing the list in reverse, searching for an element and returning its index, and accessing an element using its index.

## Features Tested

1. **Inserting Elements**
2. **Deleting Elements**
3. **Traversing the List (Head to Tail)**
4. **Traversing the List (Tail to Head)**
5. **Searching for Elements**
6. **Accessing Elements by Index**

## Testing Overview

### 1. Inserting Elements

**Objective:** Test the ability to insert multiple elements into the doubly linked list.

**Procedure:**

1. Start the program.
2. Choose the option to insert elements.
3. Input the number of elements to insert.
4. Enter each element value.

**Expected Result:** Elements are inserted successfully, and the doubly linked list accommodates the new elements.

**Simulation:**

```plaintext
Option 1: (Add Integer)
How many integers to add: 6
Integer to Add (index 0): 11
Integer to Add (index 1): 22
Integer to Add (index 2): 33
Integer to Add (index 3): 44
Integer to Add (index 4): 55
Integer to Add (index 5): 66
```

**Verification**
```plaintext
Option: 3 (Show List)
Traversing from head to tail: 
Head -> 10  <-->  20  <-->  30  <-->  40  <-->  50  <- Tail
```
- We can check that the elements `11, 22, 33, 44, 55, 66` are present in the doubly linked list.

### Deleting Elements

**Objective**: Test the ability to delete an element from the doubly linked list.

**Procedure:**

1. Choose the option to delete an element.
2. Enter the value of the element to delete.

**Expected Result**: The specified element is removed from the list if it exists.

**Simulation:**

```plaintext
Option 2: (Delete Integer)
Integer to Delete: 44
Deletion Success. 
```

**Verification**
```plaintext
Option 3 : (View List)
Traversing from head to tail: 
Head -> 11  <-->  22  <-->  33  <-->  55  <-->  66 <- Tail
```
- Verify that element `30` has been removed from the list.

### 3. Traversing the List (Head to Tail)
**Objective**: Test the ability to traverse the list from the head to the tail and display all elements.

**Procedure**:

1. Choose the option to traverse the list.
2. View the elements as they are printed from head to tail.

**Expected Result**: The list should be displayed in the correct order, starting from the head.

**Simulation:**

```plaintext
Option 3 : (View List)
Traversing from head to tail: 
Head -> 11  <-->  22  <-->  33  <-->  55  <-->  66 <- Tail 
```

### 4. Traversing the List (Tail to Head)
**Objective:** Test the ability to traverse the list from the tail to the head and display all elements.

**Procedure:**

1. Choose the option to traverse the list in reverse.
2. View the elements as they are printed from tail to head.

**Expected Result:** The list should be displayed in the correct reverse order, starting from the tail.

**Simulation**
```plaintext
Option 4 : (View List in Reverse)
Traversing from tail to head: 
Tail -> 66  <-->  55  <-->  33  <-->  22  <-->  11 <- Head 
```

### 5. Searching for Elements
   **Objective:** Test the ability to search for an element by value and return its index.

**Procedure:**

1. Choose the option to search for an element.
2. Enter the value of the element to search.

**Expected Result**: The index of the element is returned if it exists, or an appropriate message if it does not.

**Simulation:**

```plaintext
Option 5 : (View Index)
Enter the integer to search (returns the index): 22
The integer 22 is found at index 1
```

**Verification**
```plaintext
Option 3 : (View List)
Traversing from head to tail: 
Head -> 11  <-->  22  <-->  33  <-->  55  <-->  66 <- Tail
```
- Verify that element `22` is at index `1` in the list.

### 6. Accessing Elements by Index
**Objective**: Test the ability to access an element using its index.

**Procedure:**

1. Choose the option to get an element at a specific index.
2. Enter the index value.

**Expected Result:** The element at the specified index is returned, or an appropriate error message if the index is out of bounds.

**Simulation:**

```plaintext
Option 6 : (Search Element)
Enter the index: 4
The number at index 4 is 66
```

**Verification**
```plaintext
Option 3 : (View List)
Traversing from head to tail: 
Head -> 11  <-->  22  <-->  33  <-->  55  <-->  66 <- Tail
```

- Verify that index `4` is element `66`.
