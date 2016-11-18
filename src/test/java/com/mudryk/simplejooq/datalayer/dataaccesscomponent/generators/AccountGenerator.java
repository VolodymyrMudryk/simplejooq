package com.mudryk.simplejooq.datalayer.dataaccesscomponent.generators;

import com.mudryk.simplejooq.businesslayer.businessentities.Account;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public class AccountGenerator extends BaseGenerator {

    public static Account generate() {
        return new Account(randomPositiveLong(), randomPositiveLong(),
                LOCAL_DATE_FORMATTER.parseLocalDateTime("2014-12-06 12:02:00.000"),
                random.nextBoolean());
    }
}
