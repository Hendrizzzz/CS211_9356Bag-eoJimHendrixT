package prelim.DynamicArray;

/**
 * Represents an account with email address, username, and password.
 */
public class Account implements Comparable<Account> {
    private String emailAddress;
    private String username;
    private String password;

    /**
     * Creates a new Account with the specified email address, username, and password.
     *
     * @param emailAddress The email address of the account.
     * @param username     The username of the account.
     * @param password     The password of the account.
     */
    public Account(String emailAddress, String username, String password) {
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
    }

    /**
     * Default constructor for creating an empty Account.
     */
    public Account() {

    }

    /**
     * Creates a new Account with the specified email address and username.
     *
     * @param email    The email address of the account.
     * @param username The username of the account.
     */
    public Account(String email, String username) {
        this.emailAddress = email;
        this.username = username;
    }

    /**
     * Gets the email address of the account.
     *
     * @return The email address of the account.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the email address of the account.
     *
     * @param emailAddress The new email address of the account.
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets the username of the account.
     *
     * @return The username of the account.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the account.
     *
     * @param username The new username of the account.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the account.
     *
     * @return The password of the account.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the account.
     *
     * @param password The new password of the account.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Compares this account with another account based on email address and username.
     *
     * @param another The account to compare with.
     * @return A negative integer, zero, or a positive integer as this account is less than,
     *         equal to, or greater than the specified account.
     */
    @Override
    public int compareTo(Account another) {
        return (this.emailAddress + this.username).compareTo(another.emailAddress + another.username);
    }

    /**
     * Checks if this account is equal to another object.
     *
     * @param another The object to compare with.
     * @return True if the object is an instance of Account and has the same username and email address; otherwise, false.
     */
    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || another.getClass() != this.getClass()) return false;

        Account account = (Account) another;
        return username.equals(account.getUsername()) && emailAddress.equals(account.getEmailAddress());
    }

    /**
     * Returns a hash code value for this account.
     *
     * @return The hash code value for this account.
     */
    @Override
    public int hashCode() {
        int result = (username != null) ? username.hashCode() : 0;
        result = 31 * result + ((emailAddress != null) ? emailAddress.hashCode() : 0);
        return result;
    }

    /**
     * Returns a string representation of the account with email address, username, and password.
     *
     * @return A string representation of the account.
     */
    @Override
    public String toString() {
        return "Email Address : " + emailAddress + "\n" +
                "Username : " + username + "\n" +
                "Password : " + password;
    }

    /**
     * Returns a string representation of the account with email address and username.
     *
     * @param b A boolean flag indicating whether to include the password in the string representation.
     * @return A string representation of the account.
     */
    public String toString(boolean b) {
        return "Email Address : " + emailAddress + "\n" +
                "Username : " + username;
    }

} // end of the class
