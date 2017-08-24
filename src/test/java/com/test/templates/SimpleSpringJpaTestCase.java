package com.test.templates;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * spring with test runner
 * @author "ali Benabdelaziz "
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class SimpleSpringJpaTestCase extends SimpleSpringTestCase {

	public EntityManager getEm() {
        return em;
    }
    @PersistenceContext
	protected EntityManager em;

	

}
