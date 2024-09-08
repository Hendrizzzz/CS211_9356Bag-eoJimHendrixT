package prelim.LinkedList.Objects;

import java.util.Objects;

public class SupportTicket {
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupportTicket that = (SupportTicket) o;

        if (ticketNumber != that.ticketNumber) return false;
        if (!Objects.equals(title, that.title)) return false;
        return Objects.equals(issueDescription, that.issueDescription);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (issueDescription != null ? issueDescription.hashCode() : 0);
        result = 31 * result + ticketNumber;
        return result;
    }

    private String title;
    private String issueDescription;
    private int ticketNumber;
    private String status;


    public SupportTicket() {

    }

    public SupportTicket(Customer customer, String title, String issueDescription, int ticketNumber, String status) {
        this.customer = customer;
        this.title = title;
        this.issueDescription = issueDescription;
        this.ticketNumber = ticketNumber;
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer: " + customer.getName() + "\n" +
                "Title: " + title + "\n" +
                "Issue Description: " + issueDescription + "\n" +
                "Ticket Number : " + ticketNumber + "\n" +
                "Status: " + status;
    }

}
