package com.openbanking.webbff;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OpenbankingWebBffApplicationBeanTests {
    @Test
    void dispatcherServletBeanIsRegistered() {
        assertNotNull(applicationContext.getBean(DispatcherServlet.class));
    }

    @Test
    void applicationBeanIsSingleton() {
        OpenbankingWebBffApplication first = applicationContext.getBean(OpenbankingWebBffApplication.class);
        OpenbankingWebBffApplication second = applicationContext.getBean(OpenbankingWebBffApplication.class);
        assertEquals(first, second);
    }

    @Test
    void applicationContextHasBeansRegistered() {
        assertTrue(applicationContext.getBeanDefinitionCount() > 0);
    }

    @Test
    void applicationBeanIsRegisteredByClassName() {
        assertTrue(applicationContext.containsBean("openbankingWebBffApplication"));
    }

    @Autowired
    private ApplicationContext applicationContext;
}

