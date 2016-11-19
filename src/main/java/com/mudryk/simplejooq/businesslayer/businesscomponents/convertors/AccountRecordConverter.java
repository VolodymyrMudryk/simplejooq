package com.mudryk.simplejooq.businesslayer.businesscomponents.convertors;

import com.mudryk.simplejooq.businesslayer.businessentities.Account;
import com.mudryk.simplejooq.businesslayer.util.DateUtils;
import com.mudryk.simplejooq.jooq.generated.tables.records.AccountRecord;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
@Component
public class AccountRecordConverter implements RecordConverter<Account, AccountRecord> {

    @Override
    public AccountRecord entity2record(Account entity) {
        requireNonNull(entity);
        AccountRecord record = new AccountRecord();
        updateRecord(entity, record);
        return record;
    }

    @Override
    public void updateRecord(Account entity, AccountRecord record) {
        requireNonNull(entity);
        requireNonNull(record);
        record.setId(entity.getId());
        record.setUserId(entity.getUserId());
        record.setCreateDate(DateUtils.jodaLocalDateTime2timestamp(entity.getCreateDate()));
        record.setInvalid(Boolean2ByteConverter.bool2byte(entity.isInvalid()));
    }

    @Override
    public Account record2entity(AccountRecord record) {
        requireNonNull(record);
        return new Account(record.getId(),
                record.getUserId(),
                DateUtils.timestamp2jodaLocalDateTime(record.getCreateDate()),
                Boolean2ByteConverter.byte2bool(record.getInvalid()));
    }
}
