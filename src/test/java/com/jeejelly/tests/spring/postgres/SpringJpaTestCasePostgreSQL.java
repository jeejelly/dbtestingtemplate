package com.jeejelly.tests.spring.postgres;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jeejelly.tests.spring.SpringJpaTestCaseAgnostic;

@Transactional
@ContextConfiguration(locations = { "classpath:/META-INF/spring.postgresql.xml" })
public class SpringJpaTestCasePostgreSQL extends SpringJpaTestCaseAgnostic {

}
