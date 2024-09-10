package prelim;

/**
 * Exception thrown when a list exceeds its allowed size.
 */
public class ListOverflowException extends Exception {
    /**
     * Constructs a new {@code ListOverflowException} with no detail message.
     */
    public ListOverflowException() {

    }

    /**
     * Constructs a new {@code ListOverflowException} with the specified detail message.
     *
     * @param message the detail message
     */
    public ListOverflowException(String message) {
        super(message);
    }
}
