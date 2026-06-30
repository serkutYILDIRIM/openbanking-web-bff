package com.openbanking.webbff;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OpenbankingWebBffApplicationLifecycleTests {
    @Test
    void applicationContextIsActiveAfterStartup() {
        assertInstanceOf(ConfigurableApplicationContext.class, applicationContext);
        assertTrue(((ConfigurableApplicationContext) applicationContext).isActive());
    }

    @Test
    void applicationContextHasPositiveStartupDate() {
        assertTrue(applicationContext.getStartupDate() > 0);
    }

    @Test
    void applicationContextHasAssignedId() {
        assertNotNull(applicationContext.getId());
    }

    @Test
    void applicationContextHasNoParentContext() {
        assertNull(applicationContext.getParent());
    }

    @Test
    void autowireCapableBeanFactoryIsAvailable() {
        assertNotNull(applicationContext.getAutowireCapableBeanFactory());
    }

    @Test
    void applicationContextIsRunningAfterStartup() {
        assertTrue(((ConfigurableApplicationContext) applicationContext).isRunning());
    }

    @Test
    void applicationContextIsNotClosedDuringTest() {
        assertFalse(((ConfigurableApplicationContext) applicationContext).isClosed());
    }

    @Test
    void applicationContextExposesDisplayName() {
        assertNotNull(applicationContext.getDisplayName());
        assertFalse(applicationContext.getDisplayName().isBlank());
    }

    @Test
    void applicationContextStartupDateIsNotInTheFuture() {
        assertTrue(applicationContext.getStartupDate() <= System.currentTimeMillis());
    }

    @Test
    void applicationContextBeanFactoryHasRegisteredSingletons() {
        assertTrue(((ConfigurableApplicationContext) applicationContext).getBeanFactory().getSingletonCount() > 0);
    }

    @Autowired
    private ApplicationContext applicationContext;
}

