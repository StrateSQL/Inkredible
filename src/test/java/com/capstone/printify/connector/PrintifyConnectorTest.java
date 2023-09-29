package com.capstone.printify.connector;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
class PrintifyConnectorTest {

    private PrintifyConnector connector;

    @BeforeEach
    void setUp() {
        connector = new PrintifyConnector();
    }
    
    @Test
    void testGetApiData() throws InterruptedException, ExecutionException, IOException {
        String expectedEndpoint = "shops.json";
        String expectedResponse = "{\"error\":\"Unauthenticated.\"}";
        CompletableFuture<String> responseFuture = connector.getApiData(expectedEndpoint);
    	String actualResponse = responseFuture.get();
    	assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void testGetApiDataWithInvalidEndpoint() {
        String invalidEndpoint = "shops.xml";
        CompletableFuture<String> responseFuture = connector.getApiData(invalidEndpoint);
        assertThrows(IOException.class, () -> responseFuture.get());
    }
}
