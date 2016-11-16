/**
 * This class is generated by jOOQ
 */
package com.mudryk.simplejooq.jooq.generated.tables.records;


import com.mudryk.simplejooq.jooq.generated.tables.Account;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccountRecord extends UpdatableRecordImpl<AccountRecord> implements Record4<Long, Long, Timestamp, Byte> {

    private static final long serialVersionUID = -1587076069;

    /**
     * Setter for <code>simple_jooq.account.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>simple_jooq.account.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>simple_jooq.account.client_id</code>.
     */
    public void setClientId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>simple_jooq.account.client_id</code>.
     */
    public Long getClientId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>simple_jooq.account.create_date</code>.
     */
    public void setCreateDate(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>simple_jooq.account.create_date</code>.
     */
    public Timestamp getCreateDate() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>simple_jooq.account.invalid</code>.
     */
    public void setInvalid(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>simple_jooq.account.invalid</code>.
     */
    public Byte getInvalid() {
        return (Byte) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, Long, Timestamp, Byte> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, Long, Timestamp, Byte> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Account.ACCOUNT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return Account.ACCOUNT.CLIENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Account.ACCOUNT.CREATE_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field4() {
        return Account.ACCOUNT.INVALID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getClientId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getCreateDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value4() {
        return getInvalid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value2(Long value) {
        setClientId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value3(Timestamp value) {
        setCreateDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value4(Byte value) {
        setInvalid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord values(Long value1, Long value2, Timestamp value3, Byte value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AccountRecord
     */
    public AccountRecord() {
        super(Account.ACCOUNT);
    }

    /**
     * Create a detached, initialised AccountRecord
     */
    public AccountRecord(Long id, Long clientId, Timestamp createDate, Byte invalid) {
        super(Account.ACCOUNT);

        set(0, id);
        set(1, clientId);
        set(2, createDate);
        set(3, invalid);
    }
}
