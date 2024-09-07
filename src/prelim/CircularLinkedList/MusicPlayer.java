package prelim.CircularLinkedList;

import prelim.DoublyLinkedNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MusicPlayer {

    // Circular linked-list of students
    private static final MyDoublyLinkedCircularList<Song> songs = new MyDoublyLinkedCircularList<>();

    public static void main(String[] args) {
        try {
            MusicPlayer myProgram = new MusicPlayer();
            myProgram.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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


    private void createSong(BufferedReader reader) {
        System.out.println("Adding a song... ");
        Song song = readSong(reader);
        songs.insert(song);
    }

    private Song readSong(BufferedReader reader) {
        String title = readString("Song title: ", reader);
        String artist = readString("Song Artist: ", reader);

        return new Song(title, artist);
    }


    private void deleteSong(BufferedReader reader) {
        Song song = readSong(reader);
        if (songs.delete(song))
            System.out.println(song + " is successfully deleted!. ");
        else
            System.out.println(song + " is not in the song list. Song deletion status: FAIL. ");
    }

    private void viewSongList() {
        System.out.println("Song List.... ");
        System.out.printf("%-4s%-20s%-20s%n", "No.", "Title", "Artist");
        for (int i = 0; i < songs.getSize(); i++) {
            Song song = songs.get(i);
            System.out.printf("%-4d%-20s%-20s%n", i + 1, song.getTitle(), song.getArtist());
        }
    }

    private void downloadStockMusics() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/prelim/CircularLinkedList/StockedSongs.txt"))) {
            String line = reader.readLine();
            if (line == null) {
                System.out.println("You have already downloaded the stock songs. ");
                return;
            }

            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                String title = attributes[0];
                String artist = attributes[1];

                Song song = new Song(title, artist);
                songs.insert(song);
            }
            Thread.sleep(4000);
            System.out.println("Download finished. ");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private void playSong(BufferedReader reader) {
        Song song = readSong(reader);
        song = songs.getElement(song);

        if (song == null) {
            System.out.println(song + " is not in the list. ");
        } else
            song.playSong();
    }

    private void playAllSongs(BufferedReader reader) {
        DoublyLinkedNode<Song> song = songs.getHead();
        do {
            song.getData().playSong();
            song = song.getNext();
        } while (song != songs.getHead() ||
                            readString("Do you want to continue? (Y/N)", reader).
                            equalsIgnoreCase("Y"));
    }


    private String readString(String prompt, BufferedReader reader) {
        try {
            System.out.print(prompt);
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


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
                4. Download stock songs
                5. Play a song
                6. Play song list
                7. Exit
                """);
    }

    private void readData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/prelim/CircularLinkedList/Songs.txt"))) {
            String line;

            while ( (line = reader.readLine()) != null) {
                Song song = new Song();
                String[] attributes = line.split(",");

                song.setTitle(attributes[0]);
                song.setArtist(attributes[1]);

                songs.insert(song);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveData() {
    }


}
