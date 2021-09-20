package com.cy.jt;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
public class TestMaven {
    @Test
    void testHello(){
        System.out.println("hello maven!");
    }
}
