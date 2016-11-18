package com.mudryk.simplejooq.datalayer.dataaccesscomponent;

import com.mudryk.simplejooq.businesslayer.businessentities.User;
import com.mudryk.simplejooq.jooq.generated.tables.records.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public class UserRepositoryTest extends JooqBaseRepositoryTest<User, Long, UserRecord> {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected BaseRepository<User, Long, UserRecord> getRepository() {
        return userRepository;
    }

    @Override
    protected User createEntity() {
        return null;
    }

    @Override
    protected User modifyEntity(User entity) {
        return null;
    }
}
