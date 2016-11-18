package com.mudryk.simplejooq.datalayer.dataaccesscomponent.generators;

import java.util.Random;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public class BaseGenerator {

    protected static final Random random = new Random();

    protected static long randomPositiveLong() {
        return Math.abs(random.nextLong());
    }
}
