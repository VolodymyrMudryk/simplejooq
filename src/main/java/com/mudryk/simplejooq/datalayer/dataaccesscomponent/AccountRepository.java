package com.mudryk.simplejooq.datalayer.dataaccesscomponent;

import com.mudryk.simplejooq.businesslayer.businesscomponents.convertors.Boolean2ByteConverter;
import com.mudryk.simplejooq.businesslayer.businesscomponents.convertors.RecordConverter;
import com.mudryk.simplejooq.businesslayer.businessentities.Account;
import com.mudryk.simplejooq.jooq.generated.tables.records.AccountRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

import static com.mudryk.simplejooq.jooq.generated.Tables.ACCOUNT;
import static com.mudryk.simplejooq.jooq.generated.Tables.USER;
import static java.util.stream.Collectors.toList;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
@Repository
public class AccountRepository extends BaseRepository<Account, Long, AccountRecord> {

    @Autowired
    protected AccountRepository(DSLContext dslContext, RecordConverter<Account, AccountRecord> recordConverter) {
        super(dslContext, recordConverter, ACCOUNT);
    }

    @Override
    public Condition idEq(Long id) {
        return ACCOUNT.ID.eq(id);
    }

    @Override
    public Condition idIn(Collection<Long> ids) {
        return ACCOUNT.ID.in(ids);
    }

    public List<Account> getAllValidAccounts() {
        return dslContext
                .selectFrom(ACCOUNT)
                .where(ACCOUNT.INVALID.eq(Boolean2ByteConverter.bool2byte(false)))
                .fetchInto(ACCOUNT)
                .stream()
                .map(recordConverter::record2entity)
                .collect(toList());
    }
}
