package prelim.FixedArray;


/**
 * The Player class represents a basketball player and stores their
 * statistical performance, including points, rebounds, assists, steals, blocks, and more.
 * It also calculates the player's MVP score based on weighted statistics.
 */
public class Player implements Comparable<Player>{
    private String position;
    private byte jerseyNumber;
    private String lastName;
    private String firstName;
    private byte points;
    private byte rebounds;
    private byte assists;
    private byte steals;
    private byte blocks;
    private byte plusMinus; // Plus-Minus, the points of the team minus the points of the enemy team when he is on the floor
    private byte fGA = 0; // Field Goal Attempted
    private byte fGM = 0; // Field Goal Made
    private double fgPercentage;

    private double mvpScore;

    private static final double POINTS_WEIGHT = 2.0;         // Weight for Points Per Game (PPG)
    private static final double REBOUNDS_WEIGHT = 1.5;       // Weight for Rebounds Per Game (RPG)
    private static final double ASSISTS_WEIGHT = 1.5;        // Weight for Assists Per Game (APG)
    private static final double STEALS_WEIGHT = 1.0;         // Weight for Steals Per Game (SPG)
    private static final double BLOCKS_WEIGHT = 1.0;
    private static final double PLUS_MINUS_WEIGHT = 1.0;        // Weight for Plus/Minus
    private static final double FGM_WEIGHT = 1.0;               // Weight for Field Goals Made (FGM)
    private static final double FGA_WEIGHT = 0.5;               // Weight for Field Goals Attempted (FGA)
    private static final double FG_PERCENTAGE_WEIGHT = 1.0;     // Weight for Field Goal Percentage (FG%)




    /**
     * Constructs a Player object with specific performance stats.
     *
     * @param position The player's position on the court.
     * @param jerseyNumber The player's jersey number.
     * @param lastName The player's last name.
     * @param firstName The player's first name.
     * @param points The player's points scored.
     * @param rebounds The player's rebounds.
     * @param assists The player's assists.
     * @param steals The player's steals.
     * @param blocks The player's blocks.
     * @param plusMinus The player's plus-minus statistic.
     * @param fGA The player's field goals attempted.
     * @param fGM The player's field goals made.
     */
    public Player(String position, byte jerseyNumber, String lastName,
                  String firstName, byte points, byte rebounds, byte assists,
                  byte steals, byte blocks, byte plusMinus, byte fGA, byte fGM)
    {
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.plusMinus = plusMinus;
        this.fGA = fGA;
        this.fGM = fGM;
        this.fgPercentage = (double) fGM /fGA;

        // Calculate the mvp Score based on the weighted performance stats
        this.mvpScore = POINTS_WEIGHT * points + REBOUNDS_WEIGHT * rebounds + ASSISTS_WEIGHT * assists +
                STEALS_WEIGHT * steals + BLOCKS_WEIGHT * blocks + FG_PERCENTAGE_WEIGHT * fgPercentage + 
                PLUS_MINUS_WEIGHT *  + FGM_WEIGHT * fGM - FGA_WEIGHT * fGA;
    }

    /**
     * Default constructor for Player.
     */
    public Player()  {

    }


    // Getters and Setters for player properties
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(byte jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public byte getPoints() {
        return points;
    }

    public void setPoints(byte points) {
        this.points = points;
        mvpScore += POINTS_WEIGHT * points;
    }

    public byte getRebounds() {
        return rebounds;
    }

    public void setRebounds(byte rebounds) {
        this.rebounds = rebounds;
        mvpScore += REBOUNDS_WEIGHT * rebounds;
    }

    public byte getAssists() {
        return assists;
    }

    public void setAssists(byte assists) {
        this.assists = assists;
        mvpScore += ASSISTS_WEIGHT * assists;
    }

    public byte getSteals() {
        return steals;
    }

    public void setSteals(byte steals) {
        this.steals = steals;
        mvpScore += STEALS_WEIGHT * steals;
    }

    public byte getBlocks() {
        return blocks;
    }

    public void setBlocks(byte blocks) {
        this.blocks = blocks;
        mvpScore += BLOCKS_WEIGHT * blocks;
    }

    public byte getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(byte plusMinus) {
        this.plusMinus = plusMinus;
        mvpScore += PLUS_MINUS_WEIGHT * plusMinus;
    }

    public byte getfGA() {
        return fGA;
    }

    public void setfGA(byte fGA) {
        this.fGA = fGA;
        mvpScore += FGA_WEIGHT * fGA;

        if (fGM != 0) {
            fgPercentage = (double) fGM / fGA;
        }
    }

    public byte getfGM() {
        return fGM;
    }

    public void setfGM(byte fGM) {
        this.fGM = fGM;
        mvpScore += FGM_WEIGHT * fGM;

        if (fGA != 0) {
            fgPercentage = (double) fGM / fGA;
        }
    }


    public double getFgPercentage() {
        return fgPercentage;
    }

    public double getMvpScore() {
        return mvpScore;
    }


    /**
     * Compares this player to another player by their combined first and last names.
     *
     * @param otherPlayer The other player to compare with.
     * @return A negative integer, zero, or a positive integer if this player is less than,
     * equal to, or greater than the other player, respectively.
     */
    @Override
    public int compareTo(Player otherPlayer) {
        return (this.lastName + this.firstName).compareTo(otherPlayer.firstName + otherPlayer.lastName);
    }


    /**
     * Returns a string representation of the player.
     *
     * @return A formatted string with the player's details and MVP score.
     */
    @Override
    public String toString() {
        return "#" + jerseyNumber + "  " +  lastName + ", " + firstName + "\n" +
                position + "\n" +
                "Points : " + points + "\n" +
                "Rebounds : " + rebounds + "\n" +
                "Assists : " + assists + "\n" +
                "Steals : " + steals + "\n" +
                "Blocks : " + blocks + "\n" +
                "Plus/Minus : " + plusMinus + "\n" +
                String.format("FG%% : %.2f%%\n", fgPercentage * 100) + "\n" +
                "MVP WEIGHT: " + mvpScore;
    }


    /**
     * Checks if this player is equal to another object based on their first and last names.
     *
     * @param obj The object to compare with.
     * @return True if the object is equal to this player, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Check if both references are the same
        if (obj == null || getClass() != obj.getClass()) return false;  // Check if obj is null or of different class

        // Cast obj to the correct type and compare the first and last names
        Player other = (Player) obj;
        return firstName.equals(other.firstName) && lastName.equals(other.lastName);
    }

    /**
     * We override the 'equals' method, so we must also override the hashCode method
     *
     * @return The hash code value for this player.
     */
    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }



} // end of the player class
