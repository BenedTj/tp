package seedu.address.commons.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * Helper functions for handling dates.
 */
public class DateTimeUtil {
    /**
     * The date must follow the format yyyy-MM-dd
     * where yyyy is the 4-digit year, MM is the 2-digit month number,
     * and dd is the 2-digit date number.
     */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            .withResolverStyle(ResolverStyle.STRICT);

    /**
     * Returns true if a given string is a valid delivery date
     * in the valid format.
     */
    public static boolean isValidDeliveryDate(String test) {
        try {
            LocalDate.parse(test, DATE_FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Parses raw string dates into their corresponding LocalDate objects.
     */
    public static LocalDate parseDeliveryDate(String date) {
        return LocalDate.parse(date, DATE_FORMATTER);
    }


}
