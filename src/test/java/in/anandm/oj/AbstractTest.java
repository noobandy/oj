package in.anandm.oj;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config\\root-context.xml" })
public class AbstractTest {

    private static String previousValue = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        previousValue = System.setProperty("spring.active.profile", "test");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

        if (previousValue != null) {
            System.setProperty("spring.active.profile", previousValue);
        }

    }
}
