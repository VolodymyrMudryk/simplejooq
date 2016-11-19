package com.mudryk.simplejooq.datalayer.dataaccesscomponent;

import com.google.common.collect.Lists;
import com.mudryk.simplejooq.businesslayer.businessentities.Account;
import com.mudryk.simplejooq.datalayer.dataaccesscomponent.generators.AccountGenerator;
import com.mudryk.simplejooq.datalayer.dataaccesscomponent.generators.BaseGenerator;
import com.mudryk.simplejooq.jooq.generated.tables.daos.AccountDao;
import com.mudryk.simplejooq.jooq.generated.tables.records.AccountRecord;
import org.jooq.DSLContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public class AccountRepositoryTest extends JooqBaseRepositoryTest<Account, Long, AccountRecord> {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private DSLContext dslContext;

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
        return new Account(entity.getId(), BaseGenerator.randomPositiveLong(), entity.getCreateDate(), entity.isInvalid());
    }

    @Test
    public void testGetAllValidAccounts() {
        Account validAccount1 = AccountGenerator.generate(false);
        Account validAccount2 = AccountGenerator.generate(false);
        Account invalidAccount = AccountGenerator.generate(true);
        accountRepository.create(Lists.newArrayList(validAccount1, validAccount2, invalidAccount));
        assertThat(accountRepository.getAllValidAccounts(), containsInAnyOrder(validAccount1, validAccount2));
    }

    @Test
    public void testNewDao() {
        Account account = accountRepository.create(AccountGenerator.generate());
        com.mudryk.simplejooq.jooq.generated.tables.pojos.Account fetchedAccount = new AccountDao(dslContext.configuration()).fetchOneById(account.getId());
        int u = 1;
    }
}
