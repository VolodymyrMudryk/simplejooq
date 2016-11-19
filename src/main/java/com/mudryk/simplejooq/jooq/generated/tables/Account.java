/**
 * This class is generated by jOOQ
 */
package com.mudryk.simplejooq.jooq.generated.tables;


import com.mudryk.simplejooq.jooq.generated.Keys;
import com.mudryk.simplejooq.jooq.generated.SimpleJooq;
import com.mudryk.simplejooq.jooq.generated.tables.records.AccountRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Account extends TableImpl<AccountRecord> {

    private static final long serialVersionUID = -1707070883;

    /**
     * The reference instance of <code>simple_jooq.account</code>
     */
    public static final Account ACCOUNT = new Account();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AccountRecord> getRecordType() {
        return AccountRecord.class;
    }

    /**
     * The column <code>simple_jooq.account.id</code>.
     */
    public final TableField<AccountRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>simple_jooq.account.user_id</code>.
     */
    public final TableField<AccountRecord, Long> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>simple_jooq.account.create_date</code>.
     */
    public final TableField<AccountRecord, Timestamp> CREATE_DATE = createField("create_date", org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>simple_jooq.account.invalid</code>.
     */
    public final TableField<AccountRecord, Byte> INVALID = createField("invalid", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * Create a <code>simple_jooq.account</code> table reference
     */
    public Account() {
        this("account", null);
    }

    /**
     * Create an aliased <code>simple_jooq.account</code> table reference
     */
    public Account(String alias) {
        this(alias, ACCOUNT);
    }

    private Account(String alias, Table<AccountRecord> aliased) {
        this(alias, aliased, null);
    }

    private Account(String alias, Table<AccountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return SimpleJooq.SIMPLE_JOOQ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<AccountRecord, Long> getIdentity() {
        return Keys.IDENTITY_ACCOUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<AccountRecord> getPrimaryKey() {
        return Keys.KEY_ACCOUNT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<AccountRecord>> getKeys() {
        return Arrays.<UniqueKey<AccountRecord>>asList(Keys.KEY_ACCOUNT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account as(String alias) {
        return new Account(alias, this);
    }

    /**
     * Rename this table
     */
    public Account rename(String name) {
        return new Account(name, null);
    }
}
