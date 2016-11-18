package com.mudryk.simplejooq.datalayer.dataaccesscomponent.generators;

import com.mudryk.simplejooq.businesslayer.businessentities.User;
import org.joda.time.LocalDateTime;

import java.util.UUID;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public class UserGenerator extends BaseGenerator {

    public static User generate() {
        return new User(randomPositiveLong(), UUID.randomUUID().toString(), new LocalDateTime());
    }
}
