package com.jeejelly.tests.rawjpa;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.test.templates.SimpleJpaTestCase;

public class RawJpaTestCase extends SimpleJpaTestCase {
    @Test
    public void testSimpleQuery() {
        assertThat(em).isNotNull();
        List list = getEm().createNativeQuery("select * from user where firstname='toto' ").getResultList();
        assertThat(list).isNotEmpty();
        String sql = "INSERT INTO user (EMAIL, FIRSTNAME, LASTNAME) VALUES( 'test@totoduchemin.com', 'toto', 'duchemin')";
        getEm().getTransaction().begin();
        int nblignes = getEm().createNativeQuery(sql).executeUpdate();
        getEm().getTransaction().commit();
        list = getEm().createNativeQuery("select * from user where  firstname='toto' ").getResultList();
        assertThat(list).isNotEmpty();
    }
}
