package ua.com.gfalcon.financier.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

/**
 * Tests of {@link DateUtils}.
 *
 * @author Oleksii Khalikov
 */
class DateUtilsTest {

    @Test
    void convertToDateFromLocalDate() {
        LocalDate date = LocalDate.now();
        assertNotNull(DateUtils.convertToDate(date));
    }

    @Test
    void convertToDateFromLocalDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        assertNotNull(DateUtils.convertToDate(dateTime));
    }

    @Test
    void convertToLocalDate() {
        Date date = new Date();
        assertNotNull(DateUtils.convertToLocalDate(date));
    }

    @Test
    void convertToLocalDateTime() {
        Date date = new Date();
        assertNotNull(DateUtils.convertToLocalDateTime(date));
    }
}