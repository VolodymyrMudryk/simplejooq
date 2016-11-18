package com.mudryk.simplejooq.datalayer.dataaccesscomponent;

import com.mudryk.simplejooq.businesslayer.businessentities.Account;
import com.mudryk.simplejooq.datalayer.dataaccesscomponent.generators.AccountGenerator;
import com.mudryk.simplejooq.jooq.generated.tables.records.AccountRecord;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public class AccountRepositoryTest extends JooqBaseRepositoryTest<Account, Long, AccountRecord> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    protected BaseRepository<Account, Long, AccountRecord> getRepository() {
        return accountRepository;
    }

    @Override
    protected Account createEntity() {
        return AccountGenerator.generate();
    }

    @Override
    protected Account modifyEntity(Account entity) {
        return new Account(entity.getId(), entity.getClientId(), entity.getCreateDate(), entity.isInvalid());
    }
}
