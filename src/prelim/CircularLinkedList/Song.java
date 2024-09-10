package prelim.CircularLinkedList;

import java.util.Objects;

/**
 * The Song class represents a musical song with a title and artist.
 * It implements Comparable to allow comparison based on title and artist.
 */
public class Song implements Comparable<Song> {
    private String title;
    private String artist;

    /**
     * Constructs a Song with the specified title and artist.
     *
     * @param title  the title of the song
     * @param artist the artist of the song
     */
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    /**
     * Default constructor for Song.
     */
    public Song() {

    }

    /**
     * Returns the title of the song.
     *
     * @return the title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the song.
     *
     * @param title the title of the song
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the artist of the song.
     *
     * @return the artist of the song
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the artist of the song.
     *
     * @param artist the artist of the song
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Simulates playing the song by printing a message and waiting for 5 seconds.
     * Throws NullPointerException if the title or artist is null.
     */
    public void playSong() {
        if (this.artist == null || this.title == null)
            throw new NullPointerException();
        else {
            System.out.println(this.toString() + " is playing.... ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Compares this song to another object for equality.
     *
     * @param o the object to compare
     * @return true if the songs have the same title and artist, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (!Objects.equals(title, song.title)) return false;
        return Objects.equals(artist, song.artist);
    }

    /**
     * Returns the hash code value for this song.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        return result;
    }

    /**
     * Compares this song with another song for order based on title and artist.
     *
     * @param other the song to compare with
     * @return a negative integer, zero, or a positive integer as this song is
     *         less than, equal to, or greater than the specified song
     */
    @Override
    public int compareTo(Song other) {
        int difference = this.title.compareTo(other.title);
        if (difference == 0)
            return this.artist.compareTo(other.artist);
        else
            return difference;
    }

    /**
     * Returns a string representation of the song.
     *
     * @return a string representing the song in the format "title by artist"
     */
    @Override
    public String toString() {
        return title + " by " + artist;
    }
}
