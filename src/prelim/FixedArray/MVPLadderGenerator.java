package prelim.FixedArray;

import prelim.ListOverflowException;
import java.io.*;


/**
 * The MVPLadderGenerator class generates an MVP ladder for basketball players
 * based on their performance in a single game.
 * The class allows users to input
 * player data, sort players by their MVP score, and save the data.
 */
public class MVPLadderGenerator implements Runnable{
    private static final String BOLD = "\033[1m";
    private static final String RESET = "\033[0m";
    private static MyFixedSizeArrayList<Player> players = new MyFixedSizeArrayList<>();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    /**
     * Main method to start the program. Initializes the MVPLadderGenerator and runs the thread.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        MVPLadderGenerator myProgram;
        try {
            myProgram = new MVPLadderGenerator();
            Thread thread = new Thread(myProgram);
            thread.start();
            thread.join();
            myProgram.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Starts the program, shows menu options, and handles user input to perform actions.
     */
    private void start() {
        pressEnter();
        readPlayers();
        System.out.println(BOLD + "GENERATION OF AN MVP LADDER BASED OFF 1 GAME. " + RESET);
        System.out.println("To generate an MVP ladder, you must complete 5 players. ");

        while (true) {
            byte choice = readChoice();
            switch (choice) {
                case 1 -> fillPlayers();
                case 2 -> add1Player();
                case 3 -> remove1Player();
                case 4 -> checkAPlayer();
                case 5 -> clearAllPlayers();
                case 6 -> showMVPLadder();
                case 7 -> System.exit(0);
                case 8 -> save();
            }
        }
    }


    /**
     * Reads player data from a file and adds them to the player list.
     */
    private void readPlayers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/prelim/FixedArray/Players.txt"))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] playerData = line.split(",");
                 Player player = new Player();
                 player.setPosition(playerData[0]);
                 player.setJerseyNumber(Byte.parseByte(playerData[1]));
                 player.setLastName(playerData[2]);
                 player.setFirstName(playerData[3]);
                 player.setPoints(Byte.parseByte(playerData[4]));
                 player.setRebounds(Byte.parseByte(playerData[5]));
                 player.setAssists(Byte.parseByte(playerData[6]));
                 player.setSteals(Byte.parseByte(playerData[7]));
                 player.setBlocks(Byte.parseByte(playerData[8]));
                 player.setPlusMinus(Byte.parseByte(playerData[9]));
                 player.setfGA(Byte.parseByte(playerData[10]));
                 player.setfGM(Byte.parseByte(playerData[11]));
                 players.insert(player);
            }
        } catch (IOException | ListOverflowException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Reads user input for menu choice and validates it.
     *
     * @return The user's menu choice as a byte.
     */
    private byte readChoice() {
        showMenu();

        while (true) {
            try {
                byte choice = Byte.parseByte(reader.readLine());

                if (choice < 0 || choice > 8) {
                    System.out.println("Choice not found. Please select a choice from 1 - 8. ");
                    continue;
                }

                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please input a number. ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * Displays the menu options to the user.
     */
    private void showMenu() {
        System.out.println("""
                Choose an option:
                1. Complete 5 players
                2. Add 1 player
                3. Remove 1 player
                4. Check a Player
                5. Clear All Players
                6. Show MVP Ladder
                7. Don't Save And Quit
                8. Save and Quit
                """);
    }


    /**
     * Prompts the user to press Enter to continue.
     */
    private void pressEnter() {
        System.out.println("Press " + BOLD + "'Enter'" + RESET + " to continue. ");
        try {
            reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Reads player details from the user input and returns a Player object.
     *
     * @param i The index of the player being input.
     * @return The Player object created from the user input.
     */
    private Player readPlayer(int i) {
        System.out.println(BOLD + "\n\nPlayer " + i + ": " + RESET);

        Player player = new Player();

        System.out.print("Player's First Name : ");
        player.setFirstName(readString());
        System.out.print("Player's Last Name : ");
        player.setLastName(readString());
        System.out.print("Player's Position (1 - 5): ");
        player.setPosition(readPosition());
        System.out.print("Jersey Number : ");
        player.setJerseyNumber(readByte(true));
        System.out.print("Points : ");
        player.setPoints(readByte(true));
        System.out.print("Rebounds : ");
        player.setRebounds(readByte(true));
        System.out.print("Assists : ");
        player.setAssists(readByte(true));
        System.out.print("Steals : ");
        player.setSteals(readByte(true));
        System.out.print("Blocks : ");
        player.setBlocks(readByte(true));
        System.out.print("Plus/Minus : ");
        player.setPlusMinus(readByte(false));
        System.out.print("Field Goals Attempted : ");
        player.setfGA(readByte(true));
        System.out.print("Field Goals Made : ");
        player.setfGM(readByte(true));

        return player;
    }



    /**
     * Reads and validates the player's position input.
     *
     * @return The player's position as a string.
     */
    private String readPosition() {
        while (true) {
            try {
                byte position = Byte.parseByte(reader.readLine());

                if (position < 1 || position > 5) {
                    System.out.println("Invalid Position. Please choose from 1 - 5; 1 being a PG and 5 being a C.");
                    continue;
                }

                return switch (position) {
                    case 1 -> "Point Guard";
                    case 2 -> "Shooting Guard";
                    case 3 -> "Small Forward";
                    case 4 -> "Power Forward";
                    case 5 -> "Center";
                    default -> "";
                };

            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a number. ");
            }
        }
    }


    /**
     * Reads and validates a string input from the user.
     *
     * @return The user input as a string.
     */
    private String readString() {
        while (true) {

            try  {
                String name = reader.readLine().trim();

                if (name.isEmpty() || name.isBlank()) {
                    System.out.println("Name cannot be blank. ");
                    continue;
                }

                return name;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }


    /**
     * Reads and validates a byte input from the user, with an option to check for positive values.
     *
     * @param isStatPositive Indicates if the stat should be positive.
     * @return The byte value of the user input.
     */
    private byte readByte(boolean isStatPositive) {
        while (true) {
            try {
                byte stat = Byte.parseByte(reader.readLine());

                if (isStatPositive) {
                    if (stat < 0) {
                        System.out.println("This stat cannot be negative. Try again. ");
                        continue;
                    }
                }

                return stat;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. The stat is unusually high and not possible in a game or The input you entered is not an integer. ");
            }
        }
    }


    /**
     * Fills the player list with player data entered by the user.
     */
    private void fillPlayers() {
        System.out.println("\nEnter 5 players and their corresponding game stats. ");


        for (int i = players.getSize(); i < 5; i++){
            try {
                players.insert(readPlayer(i + 1));
            } catch (ListOverflowException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("\n");
    }

    /**
     * Adds one player to the player list based on user input.
     */
    private void add1Player() {
        int size = players.getSize();
        try {
            players.insert(readPlayer(size + 1));
        } catch (ListOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n");
    }


    /**
     * Removes a player from the player list based on user input.
     */
    private void remove1Player() {
        System.out.println("Enter the name of the Player you want to remove. ");
        Player player = formPlayer();

        boolean isDeleted = players.delete(player);

        if (isDeleted) {
            System.out.println("Player " + player.getLastName() + ", " + player.getFirstName() + " is removed from the list. ");
        } else {
            System.out.println("Player is not in the list. ");
        }
        System.out.println("\n");
    }


    /**
     * Forms a Player object based on user input for removal or search operations.
     *
     * @return The Player object with the user's input details.
     */
    private Player formPlayer() {
        System.out.print("Last Name : ");
        String lastName = readString();
        System.out.print("First Name : ");
        String firstName = readString();

        Player player = new Player();
        player.setFirstName(firstName);
        player.setLastName(lastName);

        return player;
    }


    /**
     * Displays the details of a player based on user input.
     */
    private void checkAPlayer() {
        System.out.println("Enter the name of the Player you want to check. ");
        Player player = formPlayer();

        int index = players.search(player);

        if (index != -1) {
            System.out.println("\n" + players.getElement(player));
        } else {
            System.out.println("Player is not in the list. ");
        }
        System.out.println("\n");
    }


    /**
     * Clears all players from the player list.
     */
    private void clearAllPlayers() {
        players = new MyFixedSizeArrayList<>();
    }


    /**
     * Sorts the players by their MVP score in descending order and displays the MVP ladder.
     */
    private void showMVPLadder() {
        sortPlayers();
        if (players.getSize() != 5){
            System.out.println("Please complete the 5 players first. \n\n");
            return;
        }
        System.out.println(BOLD + "MVP LADDER " + RESET);
        for (int i = 0; i < 5; i++){
            System.out.println(players.indexOf(i).toString() + "\n");
        }
    }


    /**
     * Sorts the players in descending order based on their MVP scores
     * using the selection sort algorithm.
     */
    private void sortPlayers() {
        for (int i = 0; i < players.getSize() - 1; i++) {
            // Assume the minimum element is at the current position
            int maxIndex = i;

            // Check the rest of the list for a greater element
            for (int j = i + 1; j < players.getSize(); j++) {
                if (players.indexOf(j).getMvpScore() > players.indexOf(maxIndex).getMvpScore()) {
                    maxIndex = j;
                }
            }

            // Swap the found maximum element with the element at the current position
            if (maxIndex != i) {
                Player temp = players.indexOf(i);
                players.set(i, players.indexOf(maxIndex));
                players.set(maxIndex, temp);
            }
        }
    }


    /**
     * Saves the player data to a file.
     */
    private void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/prelim/FixedArray/Players.txt"))) {
            for (int i = 0; i < players.getSize(); i++) {
                Player player = players.indexOf(i);
                writer.write(player.getPosition() + "," + player.getJerseyNumber() + "," + player.getLastName() + "," +
                                player.getFirstName() + "," + player.getPoints() + "," + player.getRebounds() + "," +
                                player.getAssists() + "," + player.getSteals() + "," + player.getBlocks() + "," +
                                player.getPlusMinus() + "," + player.getfGA() + "," + player.getfGM());
                writer.newLine();
            }
            System.exit(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Runs the program. This method is called when the thread starts.
     */
    @Override
    public void run() {
        try {
            System.out.println(BOLD + """
                        In basketball tournaments and leagues like the NBA, as well as in events such as
                    the Summer Olympics (Paris 2024), analysts and media often initiate "MVP Ladders" after
                    just a single game. They do this to create more fan engagement,
                    to make more views.
                    """);
            Thread.sleep(2500);

            System.out.println("""
                        Additionally, in smaller leagues, such as local Barangay leagues in the Philippines,
                    where schedules may be compressed and the championship might be decided in a single
                    game, MVP selection often relies heavily on the 1 game statistics. In these situations,
                    accurate and immediate statistical analysis is crucial for determining the most valuable
                    player based on their performance in the decisive game.
                    """);
            Thread.sleep(2500);

            System.out.println("""
                        This program mirrors these practices by calculating player statistics and generating an
                    MVP ladder or Finals MVP ranking based on the performance in a single game.
                    """ + RESET);
            Thread.sleep(2000);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

} // end of the program