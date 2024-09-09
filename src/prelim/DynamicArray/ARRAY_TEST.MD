# Growing Array (ArrayList) Implementation Testing

This document provides a comprehensive guide to testing the functionality of the custom growing array (ArrayList) implementation. The features tested include adding elements, deleting elements, searching for elements by value, and accessing elements by index.

## Features Tested

1. **Adding Elements**
2. **Deleting Elements**
3. **Searching for Elements**
4. **Accessing Elements by Index**

## Testing Overview

### 1. Adding Elements

**Objective:** Test the ability to add multiple elements to the growing array.

**Procedure:**

1. Start the program.
2. Choose the option to add elements.
3. Input the number of elements to add.
4. Enter each element value.

**Expected Result:** Elements are added successfully, and the growing array accommodates the new elements.

**Example:**

```plaintext
Option: 1 (Add integer)
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
3
The list: 
1  2  3  4  5  6  7  8  9  10  
```
- We can check that the elements `1, 2, 3, 4, 5, 6, 7, 8, 9, and 10` are present in the `growing array`.


### 2. Deleting Elements
Procedure:

1. Choose the option to delete elements.
2. Enter the value of the element to delete.

**Expected Result**: The specified element is removed from the array if it exists

**Example:**
```plaintext
1. Add integer
2. Delete integer
3. Show List
4. Search for element's position
5. Get element at index
6. Quit

2
Integer to Delete: 7
Deletion Success.  
```

**Verification**

```plaintext
3
The list: 
1  2  3  4  5  6  8  9  10  
```
- Verify that element `7` has been removed from the array.


### 3. Searching for Elements
   - Goal: Test the ability to search for an element by value and return its index.

Procedure:

1. Choose the option to search for an element.
2. Enter the value of the element to search.

**Expected Result:** The index of the element is returned if it exists, or an appropriate message if it does not.

**Example:**
```plaintext
1. Add integer
2. Delete integer
3. Show List
4. Search for element's position
5. Get element at index
6. Quit

4
Enter the integer to search (returns the index): 8
The integer 8 is found at index 6 
```

**Verification:**
```plaintext
3
The list: 
1  2  3  4  5  6  8  9  10  
```
 - We can verify that `8` is found at index `6` in the list.


### 4. Accessing Elements by Index
   Goal: Test the ability to access an element using its index.

Procedure:

1. Choose the option to get an element at a specific index.
2. Enter the index value.

**Expected Result:** The element at the specified index is returned, or an appropriate error message if the index is out of bounds.

**Example:**
```plaintext
1. Add integer
2. Delete integer
3. Show List
4. Search for element's position
5. Get element at index
6. Quit

5
Enter the index: 2
The number at index 2 is 3
```

**Verification:**
```plaintext
3
The list: 
1  2  3  4  5  6  8  9  10  
```

- Verify that the element at index 2 is returned correctly.

