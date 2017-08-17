package dbtestingtemplate.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ SimpleJpaTestCase.class, SimpleSpringJpaTestCase.class })
public class AllTests {

}
