package prelim.DoublyLinkedList;

import java.util.Date;

public class TextFile {
    private String title;
    private MyDoublyLinkedList<String> contents;
    private MyDoublyLinkedList<TextFile> versions;
    private Date lastModified;

    public TextFile() {
        this.contents = new MyDoublyLinkedList<>();
        this.versions = new MyDoublyLinkedList<>();
    }

    public TextFile(String title, MyDoublyLinkedList<String> contents) {
        this.title = title;
        this.contents = contents;
        this.versions = new MyDoublyLinkedList<>();
    }

    public TextFile (String title, Date creationDate) {
        this.contents = new MyDoublyLinkedList<>();
        this.title = title;
        this.lastModified = creationDate;
        this.versions = new MyDoublyLinkedList<>();
    }

    public TextFile(TextFile textFile) {
        this.title = textFile.title;
        this.contents = textFile.contents;
        this.versions = textFile.versions;
        this.lastModified = textFile.lastModified;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getStringContents() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < contents.getSize(); i++) {
            builder.append(contents.get(i)).append("\n");
        }
        return builder.toString();
    }

    public MyDoublyLinkedList<String> getContents() {
        return contents;
    }

    public void setContents(MyDoublyLinkedList<String> contents) {
        versions.insert(new TextFile(this)); // Make the current version a past version this.contents = contents; // Make changes
        this.lastModified = new Date();
        updatePastVersions();
    }

    public void setContents(String title, MyDoublyLinkedList<String> contents) {
        versions.insert(new TextFile(this)); // Make the current version a past version
        this.contents = contents; // Make changes
        this.title = title;
        this.lastModified = new Date();
        updatePastVersions();
    }


    public void setVersions(MyDoublyLinkedList<TextFile> versions) {
        this.versions = versions;
    }

    private void updatePastVersions() {
        int size = this.versions.getSize();

        // make the past versions have the same version set as this object
        MyDoublyLinkedList<TextFile> versionsToSet = versions.get(0).getVersions();
        for (int i = 0; i < size; i++) {
            versions.get(i).setVersions(versionsToSet);
        }
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public MyDoublyLinkedList<TextFile> getVersions() {
        return versions;
    }

    public String getFileInfo() {
        return String.format("%-7s%-20s%5s%-15s%s", "Title: ", this.title, "     ", "Last Modified: ", this.lastModified.toString());
    }

    @Override
    public String toString() {
        return "Title: " + this.title + "\n" +
                "Last Modified: " + this.lastModified + "\n" +
                getStringContents();

    }
}
