package com.mudryk.simplejooq.businesslayer.businessentities;

import org.joda.time.LocalDateTime;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public class Account implements Entity<Long> {

    private final long id;
    private final long clientId;
    private final LocalDateTime createDate;
    private final boolean invalid;

    public Account(long id, long clientId, LocalDateTime createDate, boolean invalid) {
        this.id = id;
        this.clientId = clientId;
        this.createDate = createDate;
        this.invalid = invalid;
    }

    @Override
    public Long getId() {
        return id;
    }

    public long getClientId() {
        return clientId;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public boolean isInvalid() {
        return invalid;
    }
}
