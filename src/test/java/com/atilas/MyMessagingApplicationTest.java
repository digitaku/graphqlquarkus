package com.atilas;

import io.quarkus.test.junit.QuarkusTest;


import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class MyMessagingApplicationTest {

    @Inject
    MyMessagingApplication application;

    @Test
    void test() {
        //assertEquals("HELLO", application.toUpperCase(Message.of("Hello")).getPayload());
       // assertEquals("BONJOUR", application.toUpperCase(Message.of("bonjour")).getPayload());
    }
}
