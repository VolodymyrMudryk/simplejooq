package com.mudryk.simplejooq.businesslayer.businesscomponents.convertors;

import com.mudryk.simplejooq.businesslayer.businessentities.User;
import com.mudryk.simplejooq.businesslayer.util.DateUtils;
import com.mudryk.simplejooq.jooq.generated.tables.records.UserRecord;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
@Component
public class UserRecordConverter implements RecordConverter<User, UserRecord> {

    @Override
    public UserRecord entity2record(User entity) {
        requireNonNull(entity);
        UserRecord record = new UserRecord();
        updateRecord(entity, record);
        return record;
    }

    @Override
    public void updateRecord(User entity, UserRecord record) {
        requireNonNull(entity);
        requireNonNull(record);
        record.setId(entity.getId());
        record.setName(entity.getName());
        record.setCreateDate(DateUtils.jodaLocalDateTime2timestamp(entity.getCreateDate()));
    }

    @Override
    public User record2entity(UserRecord record) {
        requireNonNull(record);
        return new User(record.getId(),
                record.getName(),
                DateUtils.timestamp2jodaLocalDateTime(record.getCreateDate()));
    }
}
