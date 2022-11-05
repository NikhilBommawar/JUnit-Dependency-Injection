package com.ecommerce.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
 
@DisplayName("JUnit 5 Dependency Injection Example")
@RunWith(JUnitPlatform.class)
public class DependencyInjection {

        DependencyInjection(TestInfo testInfo) {
        	System.out.println(testInfo.getDisplayName()+" (1)");
        assertEquals("JUnit 5 Dependency Injection Example", testInfo.getDisplayName());
    }

    @BeforeEach
    void init(TestInfo testInfo) {
    	System.out.println(testInfo.getDisplayName()+" (2)");
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
      //  assertTrue(displayName.equals("TEST 1") || displayName.equals("TEST 2"));  line no 29 & 47
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my-tag")
    void test1(TestInfo testInfo) {
    	System.out.println(testInfo.getDisplayName()+" (3)");
    	System.out.println(testInfo.getDisplayName()+" (4)");
        assertEquals("TEST 1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my-tag"));
    }

    @Test
    void test2() {
    	System.out.println("In test2()");
    }
    
//@Test
//@DisplayName("TEST 2")
//    void test2() {
//    	System.out.println("In test2()");
//    }
//
//}

}