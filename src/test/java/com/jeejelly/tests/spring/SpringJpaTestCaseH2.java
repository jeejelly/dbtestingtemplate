package com.jeejelly.tests.spring;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.test.templates.SimpleSpringJpaTestCase;

@Transactional
@ContextConfiguration(locations = { "classpath:/META-INF/spring_h2.xml" })
public class SpringJpaTestCaseH2 extends SimpleSpringJpaTestCase {

    @Test
    public void testSimpleQuery() {
        assertThat(em).isNotNull();
        String sql = "INSERT INTO user (EMAIL, FIRSTNAME, LASTNAME) VALUES( 'test@totoduchemin.com', 'toto', 'duchemin')";
        int nblignes = getEm().createNativeQuery(sql).executeUpdate();
        List list = getEm().createNativeQuery("select * from user where  firstname='toto' ").getResultList();
        assertThat(list).isNotEmpty();
    }

}
