package com.mudryk.simplejooq.infra.platform;

import com.mudryk.simplejooq.jooq.generated.SimpleJooq;
import org.jooq.DSLContext;
import org.junit.After;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:spring/spring-context.xml",
        "classpath:spring/test-context.xml"
})
public class ApplicationContextTestBase {

    @Autowired
    private DSLContext dslContext;

    @After
    public void after() {
        SimpleJooq.SIMPLE_JOOQ.getTables().forEach(table -> dslContext.truncate(table).execute());
    }
}
