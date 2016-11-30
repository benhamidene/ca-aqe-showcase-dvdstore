package info.novatec.testit.showcase.uitest.fixtures;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.lang3.time.DateUtils;


/**
 * Set of utility methods that can be used in fixtures.
 * 
 * @author Anis Ben Hamidene (NovaTec GmbH)
 */
public final class FixtureUtils {

    private static final String[] SPECIAL_CHARS = { "ü", "ö", "ä", "Ü", "Ö", "Ä", "ß", ".", ",", "-", "(", ")", "[", "]", "\ufffd" };

    private static final String[] SPECIAL_CHARS_REPLACEMENT = { "ue", "oe", "ae", "Ue", "Oe", "Ae", "ss", "", "", "", "", "", "", "", "" };

    private static final int COUNT_TIME_FORMAT = 16;

    private static final int COUNT_DAY_FORMAT = 10;

    /**
     * Private constructor because this is a utility class.
     */
    private FixtureUtils() {
    }

    /**
     * Checks that the given text is not empty. A text is not empty in a fixture if:
     * <ul>
     * <li>it is not empty according to {@link StringUtils#isNotEmpty(CharSequence)}</li>
     * <li>it doesn´t match "leer" or "null"</li>
     * </ul>
     * 
     * @param toTest
     *            text to check.
     * @return true if not empty.
     */
    public static boolean isNotEmpty(String toTest) {
        if (StringUtils.isNotEmpty(toTest)) {
            String trimmed = toTest.trim().toLowerCase();
            return !("leer".equals(trimmed) || "null".equals(trimmed) || "\ufffd".equals(trimmed));
        } else {
            return false;
        }
    }

    /**
     * Formats the list of texts as one text.
     * 
     * @param coll
     *            collection
     * @param detailed
     *            if true it will return a list of all values, otherwise it would return * if more than one result is found.
     * @return text.
     */
    public static String formatAsExpectationValue(Collection<String> coll, boolean detailed) {
        if (CollectionUtils.isEmpty(coll)) {
            return "";
        } else if (coll.size() == 1) {
            return coll.iterator().next();
        } else {
            return detailed ? ArrayUtils.toString(coll.toArray()) : "(" + coll.size() + ")";
        }
    }

    /**
     * Replaces all german and other special characters with ascii letters.
     * 
     * @param name
     *            to be converted
     * @return converted name.
     */
    public static String replaceUmlauteAndSpecialChars(String name) {
        String converted = StringUtils.replaceEachRepeatedly(name, SPECIAL_CHARS, SPECIAL_CHARS_REPLACEMENT);
        converted = WordUtils.capitalize(converted);
        converted = removeWhiteSpaces(converted);
        return converted;
    }

    /**
     * Removes all whitespaces from the given text.
     * 
     * @param orig
     *            text to be modified
     * @return modified text
     */
    public static String removeWhiteSpaces(String orig) {
        if (isNotEmpty(orig)) {
            return orig.replaceAll("\\s", "");
        } else {
            return null;
        }
    }

    /**
     * Parses the given text to a valid date.
     * 
     * @param value
     *            text
     * @return converted date.
     */
    public static Date parseDate(String value) {
        try {
            if (StringUtils.isEmpty(value)) {
                return null;
            } else {
                String dateString = value.trim();
                Date parsedDate = null;
                if (dateString.length() == COUNT_DAY_FORMAT) {
                    DateFormat germanDayFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY);

                    parsedDate = DateUtils.truncate(germanDayFormat.parse(dateString), Calendar.DAY_OF_MONTH);
                } else if (dateString.length() == COUNT_TIME_FORMAT) {
                    DateFormat germanTimeFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm", Locale.GERMANY);
                    parsedDate = DateUtils.truncate(germanTimeFormat.parse(dateString), Calendar.MINUTE);
                } else {
                    throw new IllegalArgumentException("Bitte ein gültiges Datum eingeben");
                }

                return parsedDate;
            }
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Bitte ein gültiges Datum eingeben", ex);
        }
    }

    /**
     * Formats the given date.
     * 
     * @param date
     *            date
     * @param isTime
     *            if time (minutes) should be included.
     * @return formatted date.
     */
    public static String format(Date date, boolean isTime) {
        DateFormat format = new SimpleDateFormat(isTime ? "dd.MM.yyyy hh:mm" : "dd.MM.yyyy", Locale.GERMANY);
        return format.format(date);
    }
}
