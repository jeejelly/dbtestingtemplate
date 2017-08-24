package com.jeejelly.tests.spring;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeejelly.utils.PropertyLoader;
import com.test.templates.SimpleSpringJpaTestCase;

public class SpringJpaTestCaseAgnostic extends SimpleSpringJpaTestCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyLoader.class);

    protected String  query;

    @Before
    public void init() {
        Properties prop = PropertyLoader.loadProperties("queries.inhouse.properties");
        assertThat(prop).isNotNull();
        query = prop.getProperty("selectadmin");
    }

    @Test
    public void testContext() {
        assertThat(query).isNotEmpty();
        assertThat(context).isNotNull();
        assertThat(context.containsBean("dataSource")).isTrue();
        assertThat(context.containsBean("transactionManager")).isTrue();
        assertThat(context.containsBean("entityManagerBean")).isTrue();
        assertThat(em).isNotNull();
    }

    @Test
    public void testSimpleQuery() {
        assertThat(query).isNotEmpty();
        LOGGER.info("query to test {}", query);
        assertThat(em).isNotNull();
        List list = getEm().createNativeQuery(query).getResultList();
        assertThat(list).isNotEmpty();
    }
}
