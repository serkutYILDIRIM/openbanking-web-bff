package com.openbanking.webbff;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OpenbankingWebBffApplicationPropertyTests {
    @Test
    void applicationNamePropertyIsLoaded() {
        assertEquals("openbanking-web-bff", environment.getProperty("spring.application.name"));
    }

    @Test
    void environmentBeanIsAvailable() {
        assertNotNull(environment);
    }

    @Autowired
    private Environment environment;
}
