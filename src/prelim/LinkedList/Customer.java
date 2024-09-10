package prelim.LinkedList;

import java.util.Objects;

/**
 * Represents a customer with personal details and a support ticket.
 */
public class Customer {
    private String name;
    private String id;
    private String password;
    private String email;
    private SupportTicket issue;

    /**
     * Constructs a default Customer object.
     */
    public Customer() {

    }

    /**
     * Constructs a Customer object with the specified ID and password.
     *
     * @param id       The ID of the customer.
     * @param password The password of the customer.
     */
    public Customer(String id, String password) {
        this.id = id;
        this.password = password;
    }

    /**
     * Compares this Customer to another object for equality.
     *
     * @param o The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!Objects.equals(id, customer.id)) return false;
        return Objects.equals(password, customer.password);
    }

    /**
     * Returns a hash code value for this Customer.
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
     * Constructs a Customer object with the specified name, ID, password, and email.
     *
     * @param name     The name of the customer.
     * @param id       The ID of the customer.
     * @param password The password of the customer.
     * @param email    The email of the customer.
     */
    public Customer(String name, String id, String password, String email) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
    }

    /**
     * Returns the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name The new name of the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the ID of the customer.
     *
     * @return The ID of the customer.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the customer.
     *
     * @param id The new ID of the customer.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the password of the customer.
     *
     * @return The password of the customer.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the customer.
     *
     * @param password The new password of the customer.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the email of the customer.
     *
     * @return The email of the customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the customer.
     *
     * @param email The new email of the customer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the support ticket issue of the customer.
     *
     * @return The support ticket issue.
     */
    public SupportTicket getIssue() {
        return issue;
    }

    /**
     * Sets the support ticket issue for the customer.
     *
     * @param issue The support ticket issue to set.
     */
    public void setIssue(SupportTicket issue) {
        this.issue = issue;
    }

    /**
     * Returns a string representation of the customer.
     *
     * @return A string representation of the customer.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", issue=" + issue +
                '}';
    }
}
