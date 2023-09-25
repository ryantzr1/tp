package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidRemark(String)}
 */
public class Remark {

    public static final String MESSAGE_CONSTRAINTS = "Remarks can take any values, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String remark_value;

    /**
     * Constructs a {@code Remark}.
     *
     * @param remark A valid remark.
     */
    public Remark(String remark) {
        requireNonNull(remark);
//        checkArgument(isValidRemark(remark), MESSAGE_CONSTRAINTS);
        remark_value = remark;
    }

    /**
     * Returns true if a given string is a valid remark.
     */
//    public static boolean isValidRemark(String test) {
//        return test.matches(VALIDATION_REGEX);
//    }

    @Override
    public String toString() {
        return remark_value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Remark)) {
            return false;
        }

        Remark otherRemark = (Remark) other;
        return remark_value.equals(otherRemark.remark_value);
    }

    @Override
    public int hashCode() {
        return remark_value.hashCode();
    }

}

