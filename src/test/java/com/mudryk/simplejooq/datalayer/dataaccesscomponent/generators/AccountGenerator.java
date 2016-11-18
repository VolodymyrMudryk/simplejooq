package com.mudryk.simplejooq.datalayer.dataaccesscomponent.generators;

import com.mudryk.simplejooq.businesslayer.businessentities.Account;
import org.joda.time.LocalDateTime;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public class AccountGenerator extends BaseGenerator {

    public static Account generate() {
        return new Account(randomPositiveLong(), randomPositiveLong(), new LocalDateTime(), random.nextBoolean());
    }
}
