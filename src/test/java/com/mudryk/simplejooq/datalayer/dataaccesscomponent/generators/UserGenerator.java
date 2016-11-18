package com.mudryk.simplejooq.datalayer.dataaccesscomponent.generators;

import com.mudryk.simplejooq.businesslayer.businessentities.User;

import java.util.UUID;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public class UserGenerator extends BaseGenerator {

    public static User generate() {
        return new User(randomPositiveLong(), UUID.randomUUID().toString(),
                LOCAL_DATE_FORMATTER.parseLocalDateTime("2014-12-06 12:02:00.000"));
    }
}
