package prelim;

/**
 * Because Integer object's equals method compares addresses,
 *  * and the equals method is what is used in my linkedlist for searching for an element,
 *  * decided to implement a simple object
 */
public class CustomInteger {

    private final int integer;

    /**
     * Constructs a CustomInteger with the specified value.
     *
     * @param integer the integer value for this CustomInteger
     */
    public CustomInteger(int integer) {
        this.integer = integer;
    }

    /**
     * Compares this CustomInteger to the specified object for equality.
     *
     * @param o the object to compare to
     * @return true if the object is a CustomInteger with the same value; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomInteger that = (CustomInteger) o;

        return integer == that.integer;
    }

    /**
     * Returns a hash code for this CustomInteger.
     *
     * @return the hash code for this CustomInteger
     */
    @Override
    public int hashCode() {
        return integer;
    }

    /**
     * Returns a string representation of this CustomInteger.
     *
     * @return the string representation of this CustomInteger
     */
    @Override
    public String toString() {
        return String.valueOf(integer);
    }
}
