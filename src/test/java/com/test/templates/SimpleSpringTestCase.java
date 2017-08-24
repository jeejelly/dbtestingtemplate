package com.test.templates;

import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring with test runner
 * 
 * @author "ali Benabdelaziz "
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleSpringTestCase implements ApplicationContextAware {

    @Autowired
    protected ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

}
