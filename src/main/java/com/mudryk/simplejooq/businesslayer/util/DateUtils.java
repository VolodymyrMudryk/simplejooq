package com.mudryk.simplejooq.businesslayer.util;

import org.joda.time.LocalDateTime;

import java.sql.Timestamp;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public class DateUtils {

    public static LocalDateTime timestamp2jodaLocalDateTime(Timestamp date) {
        return date != null ? LocalDateTime.fromDateFields(date) : null;
    }

    public static Timestamp jodaLocalDateTime2timestamp(LocalDateTime date) {
        return date != null ? new Timestamp(date.toDate().getTime()) : null;
    }
}
