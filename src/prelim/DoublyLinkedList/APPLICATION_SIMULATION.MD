# File Reader Application

This application provides a simple file management system allowing users to create, open, delete, and edit text files. It also supports version control, enabling users to view and restore previous versions of a file. Below is a comprehensive guide to the application’s features and usage.

## Menu Options

Upon launching the application, the user is presented with the following menu options:

1. **Create a New File**
2. **Open a File**
3. **Delete a File**
4. **Exit**

### Option 1: Create a New File

**Description:** This option allows users to create a new text file with a specified title.

**Steps:**
1. Choose the option to create a new file.
2. Enter the title for the new file.
3. The system confirms the successful creation of the file.

**Example:**
```plaintext
Creating a text file.... 
Title: File1 Title1
The file has been successfully created.
```

### Option 2: Open a File
**Description:** This option allows users to open an existing file for viewing, editing, or managing versions.

**Steps:**

1. Choose the option to open a file.
2. A list of all available files is displayed, including their titles and the last modified dates.
3. Select the file you wish to open.

**Example**
```plaintext
Opening a file.... 
File No. Title               Last Modified                 
1        File1 Title1        Mon Sep 09 19:36:46 PST 2024  
2        File2 Title1        Mon Sep 09 19:36:52 PST 2024  

File to Open: 1
```


- Once a file is opened, the user is presented with the following options:

1. **Edit File:** Allows users to modify the file's contents or update its title.
2. **See Past Versions:** Allows users to view and restore previous versions of the file.
3. **Exit:** Closes the file and returns to the main menu.
#### Editing a File
**Description:** This feature enables users to modify the title and contents of a file.

**Steps:**

1. Choose the "Edit File" option.
2. You can update the file's title (or leave it unchanged) and enter new content.
3. When finished, the user is prompted to save the changes.


**Example**
```plaintext
Editing file... 
New title (leave blank if keep the old title): File1 Title2
Please enter the new contents of the file.
Enter 'Quit101' to stop editing. 
Title2 Contents
22222222222222222
Scractch
Quit101
Save Changes? Yes(1) or No(2):  1
The file has been saved!
```

#### Viewing and Restoring Past Versions
**Description:** This feature allows users to see previous versions of a file and restore any of those versions.

**Steps:**

1. Choose the "See Past Versions" option.
2. A list of all past versions is displayed with their titles and last modified dates.
3. Select a version to view its contents.
4. If desired, restore the file to the selected version.

**Example**
```plaintext
Past versions of File1 Title4. 
Version No. Title               Last Modified                 
1           File1 Title1        Mon Sep 09 19:36:46 PST 2024  
2           File1 Title2        Mon Sep 09 19:37:25 PST 2024  
3           File1 Title3        Mon Sep 09 19:37:51 PST 2024  
Enter version number to Open: 2

Version No. 2
Title: File1 Title2
Last Modified: Mon Sep 09 19:37:25 PST 2024
Title2 Contents
22222222222222222
Scractch

Restore a previous version of this file? (Y/N): y
Restoration complete: The file has been reverted to the earlier version.
```
After restoring, the user must exit and reopen the file to see the restored contents.

### Option 3: Delete a File
**Description:** This option allows users to delete an existing file.

**Steps:**

1. Choose the option to delete a file.
2. A list of all files is displayed.
3. Select the file you want to delete.
4. Confirm the deletion.

### Option 4: Exit
Description: This option closes the application. Note that the saving of data is not yet implemented. 

# Notes
1. **Version Control:**  Each time the user edits a file, a new version is saved, enabling restoration to any previous state.
2. **Content Editing:** Users must explicitly save changes after editing; otherwise, the modifications will be discarded.
3. **File Deletion:** Once a file is deleted, it cannot be recovered.

