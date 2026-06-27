package com.openbanking.webbff;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OpenbankingWebBffApplicationComponentScanTests {
    @Test
    void applicationClassResidesInExpectedBasePackage() {
        assertEquals("com.openbanking.webbff", OpenbankingWebBffApplication.class.getPackage().getName());
    }

    @Test
    void applicationClassCanBeInstantiated() {
        assertNotNull(new OpenbankingWebBffApplication());
    }

    @Test
    void springApplicationCanBeConstructedFromMainClass() {
        assertNotNull(new SpringApplication(OpenbankingWebBffApplication.class));
    }

    @Test
    void componentScanRegistersBeansFromApplicationBasePackage() {
        assertTrue(applicationContext.getBeansWithAnnotation(SpringBootApplication.class).size() > 0);
    }

    @Test
    void applicationBeanIsLocatedInExpectedBasePackage() {
        assertEquals("com.openbanking.webbff",
                applicationContext.getBean(OpenbankingWebBffApplication.class).getClass().getPackage().getName());
    }

    @Autowired
    private ApplicationContext applicationContext;
}

