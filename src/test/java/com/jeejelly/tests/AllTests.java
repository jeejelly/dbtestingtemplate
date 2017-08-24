package com.jeejelly.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.jeejelly.tests.rawjpa.RawJpaTestCase;
import com.jeejelly.tests.spring.SpringJpaTestCaseH2;
import com.jeejelly.tests.spring.oracle.SpringJpaTestCaseOracle;
import com.jeejelly.tests.spring.postgres.SpringJpaTestCasePostgreSQL;

@RunWith(Suite.class)
@SuiteClasses({ RawJpaTestCase.class, SpringJpaTestCaseH2.class, SpringJpaTestCaseOracle.class,
        SpringJpaTestCasePostgreSQL.class })

public class AllTests {

}
