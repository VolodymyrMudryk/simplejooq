package com.mudryk.simplejooq.datalayer.dataaccesscomponent;

import com.mudryk.simplejooq.businesslayer.businesscomponents.convertors.RecordConverter;
import com.mudryk.simplejooq.businesslayer.businessentities.User;
import com.mudryk.simplejooq.jooq.generated.tables.records.UserRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import static com.mudryk.simplejooq.jooq.generated.Tables.USER;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
@Repository
public class UserRepository extends BaseRepository<User, Long, UserRecord> {

    @Autowired
    protected UserRepository(DSLContext dslContext, RecordConverter<User, UserRecord> recordConverter) {
        super(dslContext, recordConverter, USER);
    }

    @Override
    public Condition idEq(Long id) {
        return USER.ID.eq(id);
    }

    @Override
    public Condition idIn(Collection<Long> ids) {
        return USER.ID.in(ids);
    }
}
