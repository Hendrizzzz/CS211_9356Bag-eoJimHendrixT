package prelim.DoublyLinkedList;

import java.util.Date;

/**
 * Represents a text file with a title, contents, version history, and last modified date.
 */
public class TextFile {
    private String title;
    private MyDoublyLinkedList<String> contents;
    private MyDoublyLinkedList<TextFile> versions;
    private Date lastModified;

    /**
     * Default constructor initializing an empty text file.
     */
    public TextFile() {
        this.contents = new MyDoublyLinkedList<>();
        this.versions = new MyDoublyLinkedList<>();
    }

    /**
     * Constructor initializing a text file with the given title and contents.
     *
     * @param title    The title of the text file.
     * @param contents The contents of the text file.
     */
    public TextFile(String title, MyDoublyLinkedList<String> contents) {
        this.title = title;
        this.contents = contents;
        this.versions = new MyDoublyLinkedList<>();
    }

    /**
     * Constructor initializing a text file with the given title and creation date.
     *
     * @param title        The title of the text file.
     * @param creationDate The creation date of the text file.
     */
    public TextFile(String title, Date creationDate) {
        this.contents = new MyDoublyLinkedList<>();
        this.title = title;
        this.lastModified = creationDate;
        this.versions = new MyDoublyLinkedList<>();
    }

    /**
     * Copy constructor creating a new text file based on an existing one.
     *
     * @param textFile The text file to copy.
     */
    public TextFile(TextFile textFile) {
        this.title = textFile.title;
        this.contents = textFile.contents;
        this.versions = textFile.versions;
        this.lastModified = textFile.lastModified;
    }

    /**
     * Returns the title of the text file.
     *
     * @return The title of the text file.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the text file.
     *
     * @param title The new title of the text file.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the contents of the text file as a formatted string.
     *
     * @return The contents of the text file as a string.
     */
    public String getStringContents() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < contents.getSize(); i++) {
            builder.append(contents.get(i)).append("\n");
        }
        return builder.toString();
    }

    /**
     * Returns the contents of the text file as a list.
     *
     * @return The contents of the text file.
     */
    public MyDoublyLinkedList<String> getContents() {
        return contents;
    }

    /**
     * Sets the contents of the text file and updates the version history.
     *
     * @param contents The new contents of the text file.
     */
    public void setContents(MyDoublyLinkedList<String> contents) {
        versions.insert(new TextFile(this)); // Make the current version a past version
        this.contents = contents; // Make changes
        this.lastModified = new Date();
        updatePastVersions();
    }

    /**
     * Sets the contents and title of the text file, updating the version history.
     *
     * @param title    The new title of the text file.
     * @param contents The new contents of the text file.
     */
    public void setContents(String title, MyDoublyLinkedList<String> contents) {
        versions.insert(new TextFile(this)); // Make the current version a past version
        this.contents = contents; // Make changes
        this.title = title;
        this.lastModified = new Date();
        updatePastVersions();
    }

    /**
     * Sets the version history of the text file.
     *
     * @param versions The version history to set.
     */
    public void setVersions(MyDoublyLinkedList<TextFile> versions) {
        this.versions = versions;
    }

    /**
     * Updates past versions to have the same version history as the current object.
     */
    private void updatePastVersions() {
        int size = this.versions.getSize();

        // Make the past versions have the same version set as this object
        MyDoublyLinkedList<TextFile> versionsToSet = versions.get(0).getVersions();
        for (int i = 0; i < size; i++) {
            versions.get(i).setVersions(versionsToSet);
        }
    }

    /**
     * Returns the last modified date of the text file.
     *
     * @return The last modified date.
     */
    public Date getLastModified() {
        return lastModified;
    }

    /**
     * Sets the last modified date of the text file.
     *
     * @param lastModified The new last modified date.
     */
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * Returns the version history of the text file.
     *
     * @return The version history.
     */
    public MyDoublyLinkedList<TextFile> getVersions() {
        return versions;
    }

    /**
     * Returns the formatted file information including title and last modified date.
     *
     * @return The file information as a string.
     */
    public String getFileInfo() {
        return String.format("%-7s%-20s%5s%-15s%s", "Title: ", this.title, "     ", "Last Modified: ", this.lastModified.toString());
    }

    /**
     * Returns the string representation of the text file, including title, last modified date, and contents.
     *
     * @return The string representation of the text file.
     */
    @Override
    public String toString() {
        return "Title: " + this.title + "\n" +
                "Last Modified: " + this.lastModified + "\n" +
                getStringContents();

    }
} // end of the class
