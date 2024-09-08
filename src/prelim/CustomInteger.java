package prelim;

/**
 * Because Integer object's equals method compares addresses,
 * and the equals method is what is used in my linkedlist for searching for an element,
 * decided to implement a simple object
 */
public class CustomInteger {

    int integer;

    public CustomInteger(int integer) {
        this.integer = integer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomInteger that = (CustomInteger) o;

        return integer == that.integer;
    }

    @Override
    public int hashCode() {
        return integer;
    }

    @Override
    public String toString() {
        return String.valueOf(integer);
    }
}
