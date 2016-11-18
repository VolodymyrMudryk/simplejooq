package com.mudryk.simplejooq.datalayer.dataaccesscomponent.generators;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Random;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public class BaseGenerator {

    protected static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss.sss");

    protected static final Random random = new Random();

    public static long randomPositiveLong() {
        return Math.abs(random.nextLong());
    }
}
