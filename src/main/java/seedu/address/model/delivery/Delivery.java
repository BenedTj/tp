package seedu.address.model.delivery;

import seedu.address.commons.util.ToStringBuilder;

import java.util.Objects;

/**
 * Represents a Delivery in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Delivery {

    // Data fields
    private final StartDate startDate;
    private final EndDate endDate;
    private final Time time;

    /**
     * Every field must be present and not null.
     */
    public Delivery(StartDate startDate, EndDate endDate, Time time) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public EndDate getEndDate() {
        return endDate;
    }

    public Time getTime() {
        return time;
    }

    /**
     * Returns true if both deliveries have overlapping start and end dates.
     * This defines the notion of equality between two deliveries consistent
     * with the application logic.
     */
    public boolean isSameDelivery(Delivery otherDelivery) {
        if (otherDelivery == this) {
            return true;
        }

        return otherDelivery != null
                && (
                        otherDelivery.endDate.date.isAfter(startDate.date)
                                || endDate.date.isAfter(otherDelivery.startDate.date)
                );
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Delivery)) {
            return false;
        }

        Delivery otherDelivery = (Delivery) other;
        return startDate.equals(otherDelivery.startDate)
                && endDate.equals(otherDelivery.endDate)
                && time.equals(otherDelivery.time);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(startDate, endDate, time);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("start date", startDate)
                .add("end date", endDate)
                .add("time", time)
                .toString();
    }
}
