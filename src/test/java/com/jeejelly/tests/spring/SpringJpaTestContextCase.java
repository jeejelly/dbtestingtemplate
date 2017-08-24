package com.jeejelly.tests.spring;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.test.templates.SimpleSpringJpaTestCase;

@Transactional
@ContextConfiguration(locations = { "classpath:/META-INF/spring.template.xml" })
public class SpringJpaTestContextCase extends SimpleSpringJpaTestCase {

    @Test
    public void testContext() {
        assertThat(context).isNotNull();
        assertThat(context.containsBean("dataSource")).isTrue();
        assertThat(context.containsBean("transactionManager")).isTrue();
        assertThat(context.containsBean("entityManagerBean")).isTrue();
    }
}
