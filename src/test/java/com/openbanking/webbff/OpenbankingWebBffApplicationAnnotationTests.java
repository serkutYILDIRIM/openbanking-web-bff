package com.openbanking.webbff;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

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
}
