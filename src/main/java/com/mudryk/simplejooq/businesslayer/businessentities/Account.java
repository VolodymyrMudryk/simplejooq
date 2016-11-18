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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (clientId != account.clientId) return false;
        if (invalid != account.invalid) return false;
        return createDate != null ? createDate.equals(account.createDate) : account.createDate == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (clientId ^ (clientId >>> 32));
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (invalid ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", createDate=" + createDate +
                ", invalid=" + invalid +
                '}';
    }
}
