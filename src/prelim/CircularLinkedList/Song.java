package prelim.CircularLinkedList;

import java.util.Objects;

public class Song implements Comparable<Song> {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public Song() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (!Objects.equals(title, song.title)) return false;
        return Objects.equals(artist, song.artist);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Song other) {
        int difference = this.title.compareTo(other.title);
        if (difference == 0)
            return this.artist.compareTo(other.artist);
        else
            return difference;
    }

    @Override
    public String toString() {
        return title + " by " + artist;
    }
}
