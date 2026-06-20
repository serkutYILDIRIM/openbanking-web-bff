package com.openbanking.webbff;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.web.SecurityFilterChain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OpenbankingWebBffApplicationContextTests {
    @Test
    void applicationContextContainsSecurityFilterChain() {
        assertNotNull(applicationContext.getBeansOfType(SecurityFilterChain.class));
        assertTrue(applicationContext.getBeansOfType(SecurityFilterChain.class).size() > 0);
    }

    @Test
    void applicationContextContainsApplicationBean() {
        assertNotNull(applicationContext.getBean(OpenbankingWebBffApplication.class));
    }

    @Autowired
    private ApplicationContext applicationContext;
}
