package com.openbanking.webbff;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OpenbankingWebBffApplicationAnnotationTests {
    @Test
    void applicationClassIsAnnotatedWithSpringBootApplication() {
        assertNotNull(OpenbankingWebBffApplication.class.getAnnotation(SpringBootApplication.class));
    }

    @Test
    void applicationClassIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(OpenbankingWebBffApplication.class.getModifiers()));
    }

    @Test
    void applicationClassDeclaresMainMethod() throws NoSuchMethodException {
        assertNotNull(OpenbankingWebBffApplication.class.getMethod("main", String[].class));
    }

    @Test
    void embeddedServerStartsOnRandomPort() {
        assertTrue(port > 0);
    }

    @Test
    void applicationContextLoadsInWebEnvironment() {
        assertNotNull(applicationContext);
    }

    @Test
    void serverPortIsWithinValidRange() {
        assertTrue(port > 0 && port <= 65535);
    }

    @LocalServerPort
    private int port;

    @Autowired
    private ApplicationContext applicationContext;
}
