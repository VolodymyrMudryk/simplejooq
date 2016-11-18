package com.mudryk.simplejooq.infra.platform;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
@Ignore // Base class - do not run
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:spring/spring-context.xml",
        "classpath:spring/test-context.xml"
})
public class ApplicationContextTestBase {
}
