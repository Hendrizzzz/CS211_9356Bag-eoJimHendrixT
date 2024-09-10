package prelim.LinkedList;

import java.util.Objects;


/**
 * Represents a support ticket with details of the issue and the customer who submitted it.
 */
public class SupportTicket {

    private String title;
    private String issueDescription;
    private int ticketNumber;
    private String status;
    private Customer customer; // customer who submitted the issue

    /**
     * Constructs a default SupportTicket object.
     */
    public SupportTicket() {

    }

    /**
     * Constructs a SupportTicket object with the specified details.
     *
     * @param customer        The customer who submitted the ticket.
     * @param title           The title of the support ticket.
     * @param issueDescription The description of the issue.
     * @param ticketNumber    The ticket number.
     * @param status          The status of the ticket.
     */
    public SupportTicket(Customer customer, String title, String issueDescription, int ticketNumber, String status) {
        this.customer = customer;
        this.title = title;
        this.issueDescription = issueDescription;
        this.ticketNumber = ticketNumber;
        this.status = status;
    }

    /**
     * Returns the customer associated with this support ticket.
     *
     * @return The customer.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer for this support ticket.
     *
     * @param customer The customer to set.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Returns the title of this support ticket.
     *
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of this support ticket.
     *
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the issue description of this support ticket.
     *
     * @return The issue description.
     */
    public String getIssueDescription() {
        return issueDescription;
    }

    /**
     * Sets the issue description of this support ticket.
     *
     * @param issueDescription The issue description to set.
     */
    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    /**
     * Returns the ticket number of this support ticket.
     *
     * @return The ticket number.
     */
    public int getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Sets the ticket number of this support ticket.
     *
     * @param ticketNumber The ticket number to set.
     */
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    /**
     * Returns the status of this support ticket.
     *
     * @return The status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of this support ticket.
     *
     * @param status The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Compares this SupportTicket to another object for equality.
     *
     * @param o The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupportTicket that = (SupportTicket) o;

        if (ticketNumber != that.ticketNumber) return false;
        if (!Objects.equals(title, that.title)) return false;
        return Objects.equals(issueDescription, that.issueDescription);
    }

    /**
     * Returns a hash code value for this SupportTicket.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (issueDescription != null ? issueDescription.hashCode() : 0);
        result = 31 * result + ticketNumber;
        return result;
    }


    /**
     * Returns a string representation of this SupportTicket.
     *
     * @return A string representation of the support ticket.
     */
    @Override
    public String toString() {
        return "Customer: " + customer.getName() + "\n" +
                "Title: " + title + "\n" +
                "Issue Description: " + issueDescription + "\n" +
                "Ticket Number : " + ticketNumber + "\n" +
                "Status: " + status;
    }

} // end of the class
