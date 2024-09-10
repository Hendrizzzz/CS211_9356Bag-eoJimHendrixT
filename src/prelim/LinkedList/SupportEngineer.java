package prelim.LinkedList;

import java.util.Objects;


/**
 * Represents a support engineer with personal details and credentials.
 */
public class SupportEngineer {
    private String name;
    private String id;
    private String password;
    private String email;

    /**
     * Constructs a SupportEngineer with the specified id and password.
     *
     * @param id       The ID of the support engineer.
     * @param password The password of the support engineer.
     */
    public SupportEngineer(String id, String password) {
        this.id = id;
        this.password = password;
    }

    /**
     * Compares this SupportEngineer to another object for equality.
     *
     * @param o The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupportEngineer that = (SupportEngineer) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(password, that.password);
    }

    /**
     * Returns a hash code value for this SupportEngineer.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    /**
     * Constructs a SupportEngineer with the specified name, id, password, and email.
     *
     * @param name     The name of the support engineer.
     * @param id       The ID of the support engineer.
     * @param password The password of the support engineer.
     * @param email    The email of the support engineer.
     */
    public SupportEngineer(String name, String id, String password, String email) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
    }

    /**
     * Returns the name of the support engineer.
     *
     * @return The name of the support engineer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the support engineer.
     *
     * @param name The new name of the support engineer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the ID of the support engineer.
     *
     * @return The ID of the support engineer.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the support engineer.
     *
     * @param id The new ID of the support engineer.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the password of the support engineer.
     *
     * @return The password of the support engineer.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the support engineer.
     *
     * @param password The new password of the support engineer.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the email of the support engineer.
     *
     * @return The email of the support engineer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the support engineer.
     *
     * @param email The new email of the support engineer.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
