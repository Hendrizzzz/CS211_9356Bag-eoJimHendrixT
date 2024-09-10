package prelim.CircularLinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * The MusicPlayer class manages a circular doubly linked list of songs and provides functionality
 * to add, delete, view, and play songs, as well as download stock songs and save data.
 */
public class MusicPlayer {

    // Circular linked-list of students
    private static final MyDoublyLinkedCircularList<Song> SONGS = new MyDoublyLinkedCircularList<>();


    /**
     * The main method initializes and runs the music player program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        try {
            MusicPlayer myProgram = new MusicPlayer();
            myProgram.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Manages the main menu and handles user input for various song operations.
     */
    private void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readData();

        while (true) {
            int choice = readChoice(reader);
            switch (choice) {
                case 1 -> createSong(reader);
                case 2 -> deleteSong(reader);
                case 3 -> viewSongList();
                case 4 -> downloadStockMusics();
                case 5 -> playSong(reader);
                case 6 -> playAllSongs(reader);
                case 7 -> {
                    saveData();
                    System.exit(0);
                }
            }
            System.out.println("\n"); // for formatting
        }
    }


    /**
     * Creates a new song by reading input from the user and adds it to the song list.
     *
     * @param reader the BufferedReader to read user input
     */
    private void createSong(BufferedReader reader) {
        System.out.println("Adding a song... ");
        Song song = readSong(reader);
        SONGS.insert(song);
        System.out.println(song + " is successfully added in the song list. ");
    }


    /**
     * Reads the song details from the user input.
     *
     * @param reader the BufferedReader to read user input
     * @return the created Song object
     */
    private Song readSong(BufferedReader reader) {
        String title = readString("Song title: ", reader);
        String artist = readString("Song Artist: ", reader);

        return new Song(title, artist);
    }


    /**
     * Deletes a song by reading the song details from the user and removing it from the song list.
     *
     * @param reader the BufferedReader to read user input
     */
    private void deleteSong(BufferedReader reader) {
        System.out.println("Deleting a song.... ");
        Song song = readSong(reader);
        if (SONGS.delete(song))
            System.out.println(song + " is successfully deleted!. ");
        else
            System.out.println(song + " is not in the song list. Song deletion status: FAIL. ");
    }


    /**
     * Displays the list of songs currently in the circular linked list.
     */
    private void viewSongList() {
        if (SONGS.getSize() == 0) {
            System.out.println("There no currently no SONGS in the list. ");
            return;
        }
        System.out.println("Song List.... ");
        System.out.printf("%-4s%-35s%-35s%n", "No.", "Title", "Artist");
        for (int i = 0; i < SONGS.getSize(); i++) {
            Song song = SONGS.get(i);
            System.out.printf("%-4d%-35s%-35s%n", i + 1, song.getTitle(), song.getArtist());
        }
    }

    /**
     * Downloads and adds stock songs from a file to the song list.
     */
    private void downloadStockMusics() {
        System.out.println("Downloading stocked musics... ");
        try (BufferedReader reader = new BufferedReader(new FileReader("src/prelim/CircularLinkedList/StockedSongs.txt"))) {
            String line = reader.readLine();
            if (line == null) {
                System.out.println("You have already downloaded the stock SONGS. ");
                return;
            }

            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                String title = attributes[0];
                String artist = attributes[1];

                Song song = new Song(title, artist);
                SONGS.insert(song);
            }
            Thread.sleep(4000);
            System.out.println("Download finished. ");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Plays a specific song by reading the song details from the user.
     *
     * @param reader the BufferedReader to read user input
     */
    private void playSong(BufferedReader reader) {
        Song song = readSong(reader);
        song = SONGS.getElement(song);

        if (song == null) {
            System.out.println(song + " is not in the list. ");
        } else
            song.playSong();
    }


    /**
     * Plays all songs in the song list in a loop. Asks the user if they want to continue after every iteration.
     *
     * @param reader the BufferedReader to read user input
     */
    private void playAllSongs(BufferedReader reader) {
        int j = 0;
        do {
            for (int i = 0; i < SONGS.getSize(); i++) {
                SONGS.get(i).playSong();
            }
            j++;
        } while (j % 2 == 1 || readString("Do you want to continue? (Y/N)", reader).
                equalsIgnoreCase("Y"));
    }


    /**
     * Reads a string input from the user.
     *
     * @param prompt the prompt message to display
     * @param reader the BufferedReader to read user input
     * @return the user input as a string
     */
    private String readString(String prompt, BufferedReader reader) {
        try {
            System.out.print(prompt);
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Displays the menu and reads the user's choice as an integer.
     *
     * @param reader the BufferedReader to read user input
     * @return the user's choice as an integer
     */
    private int readChoice(BufferedReader reader) {
        showMenu();

        while (true) {
            try {
                System.out.print("Choose: ");
                int choice = Integer.parseInt(reader.readLine());

                if (choice < 1 || choice > 7) {
                    System.out.println("Invalid: Choice must be between 1- 5.");
                    continue;
                }

                return choice;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                System.out.println("Invalid: Input is not an integer. ");
            }
        }
    }

    private void showMenu() {
        System.out.println("""
                1. Add song
                2. Delete song
                3. View song list
                4. Download stock SONGS
                5. Play a song
                6. Play song list
                7. Exit
                """);
    }

    /**
     * Reads the song data from a file and populates the song list.
     */
    private void readData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/prelim/CircularLinkedList/Songs.txt"))) {
            String line;

            while ( (line = reader.readLine()) != null) {
                Song song = new Song();
                String[] attributes = line.split(",");

                song.setTitle(attributes[0]);
                song.setArtist(attributes[1]);

                SONGS.insert(song);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Saves the current song list data to a file (functionality not yet implemented).
     */
    private void saveData() {
    }


}
