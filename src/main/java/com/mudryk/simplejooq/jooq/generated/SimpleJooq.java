/**
 * This class is generated by jOOQ
 */
package com.mudryk.simplejooq.jooq.generated;


import com.mudryk.simplejooq.jooq.generated.tables.Account;
import com.mudryk.simplejooq.jooq.generated.tables.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class SimpleJooq extends SchemaImpl {

    private static final long serialVersionUID = 30181621;

    /**
     * The reference instance of <code>simple_jooq</code>
     */
    public static final SimpleJooq SIMPLE_JOOQ = new SimpleJooq();

    /**
     * The table <code>simple_jooq.account</code>.
     */
    public final Account ACCOUNT = com.mudryk.simplejooq.jooq.generated.tables.Account.ACCOUNT;

    /**
     * The table <code>simple_jooq.user</code>.
     */
    public final User USER = com.mudryk.simplejooq.jooq.generated.tables.User.USER;

    /**
     * No further instances allowed
     */
    private SimpleJooq() {
        super("simple_jooq", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Account.ACCOUNT,
            User.USER);
    }
}
