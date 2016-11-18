package com.mudryk.simplejooq.businesslayer.businessentities;

import org.joda.time.LocalDateTime;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public class User implements Entity<Long> {

    private final long id;
    private final String name;
    private final LocalDateTime createDate;

    public User(long id, String name, LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }
}
