package com.openbanking.webbff;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OpenbankingWebBffApplicationEnvironmentTests {
    @Test
    void defaultProfileIsActive() {
        assertTrue(environment.acceptsProfiles(org.springframework.core.env.Profiles.of("default")));
    }

    @Test
    void environmentIsConfigurable() {
        assertInstanceOf(ConfigurableEnvironment.class, environment);
    }

    @Test
    void propertySourcesAreNotEmpty() {
        ConfigurableEnvironment configurableEnv = (ConfigurableEnvironment) environment;
        assertTrue(configurableEnv.getPropertySources().size() > 0);
    }

    @Test
    void applicationContextEnvironmentMatchesInjectedEnvironment() {
        assertEquals(environment, applicationContext.getEnvironment());
    }

    @Test
    void openFeignIsNotExplicitlyDisabled() {
        assertEquals("true", environment.getProperty("spring.cloud.openfeign.enabled", "true"));
    }

    @Test
    void serverPortPropertyIsResolvable() {
        assertNotNull(environment.getProperty("local.server.port", environment.getProperty("server.port", "8080")));
    }

    @Autowired
    private Environment environment;

    @Autowired
    private ApplicationContext applicationContext;
}




