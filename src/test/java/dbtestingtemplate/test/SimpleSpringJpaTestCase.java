package dbtestingtemplate.test;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * spring with test runner
 * @author "ali Benabdelaziz "
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring.xml" })
public class SimpleSpringJpaTestCase implements ApplicationContextAware {
	private static ClassPathXmlApplicationContext ctx;

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	@BeforeClass
	public static void init() throws FileNotFoundException, SQLException {
	}

	@Test
	public void testSimpleQuery() {
		assertThat(context).isNotNull();
		assertThat(em).isNotNull();
		List list = em.createNativeQuery("select * from user where firstname='toto' ").getResultList();
		assertThat(list).isNotEmpty();
	}

}
