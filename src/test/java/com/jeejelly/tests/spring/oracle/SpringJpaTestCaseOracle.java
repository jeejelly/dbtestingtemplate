package com.jeejelly.tests.spring.oracle;

import org.springframework.test.context.ContextConfiguration;

import com.jeejelly.tests.spring.SpringJpaTestCaseAgnostic;

@ContextConfiguration(locations = { "classpath:/META-INF/spring.oracle.xml" })
public class SpringJpaTestCaseOracle extends SpringJpaTestCaseAgnostic {
   
}
