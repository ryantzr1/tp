package connectify.model.person;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import connectify.commons.util.CollectionUtil;
import connectify.commons.util.ToStringBuilder;
import connectify.model.Entity;
import connectify.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person extends Entity {

    // Identity fields
    private final PersonName name;
    private final PersonPhone personPhone;
    private final PersonEmail personEmail;

    // Data fields
    private final PersonAddress personAddress;
    private final Set<Tag> tags = new HashSet<>();
    private final PersonNote note;
    private final PersonPriority priority;

    /**
     * Every field must be present and not null.
     */
    public Person(PersonName name, PersonPhone phone, PersonEmail email, PersonAddress address,
                  Set<Tag> tags, PersonNote note, PersonPriority priority) {
        CollectionUtil.requireAllNonNull(name, phone, email, address, note, tags, priority);
        this.name = name;
        this.personPhone = phone;
        this.personEmail = email;
        this.personAddress = address;
        this.note = note;
        this.tags.addAll(tags);
        this.priority = priority;
    }

    /**
     * Returns the name of the person.
     * @return Name of person
     */
    public PersonName getName() {
        return name;
    }

    /**
     * Returns the phone number of the person.
     * @return Phone number of person
     */
    public PersonPhone getPhone() {
        return personPhone;
    }

    /**
     * Returns the email of the person.
     * @return Email of person
     */
    public PersonEmail getEmail() {
        return personEmail;
    }

    /**
     * Returns the address of the person.
     * @return Address of person
     */
    public PersonAddress getAddress() {
        return personAddress;
    }

    public PersonPriority getPriority() {
        return priority;
    }

    /**
     * Returns the note associated with this person.
     * @return Note associated with this person
     */
    public PersonNote getNote() {
        return note;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && personPhone.equals(otherPerson.personPhone)
                && personEmail.equals(otherPerson.personEmail)
                && personAddress.equals(otherPerson.personAddress)
                && note.equals(otherPerson.note)
                && tags.equals(otherPerson.tags)
                && priority.equals(otherPerson.priority);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, personPhone, personEmail, personAddress, note, tags);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", personPhone)
                .add("email", personEmail)
                .add("address", personAddress)
                .add("note", note)
                .add("tags", tags)
                .add("priority", priority)
                .toString();
    }

    public int compareNameWith(Person o) {
        return this.getName().compareTo(o.getName());
    }

    public int rank() {
        return priority.getValue();
    }

}
