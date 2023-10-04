package com.capstone.printify.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class PrintifyConnector {
	private static final Logger logger = LoggerFactory.getLogger(PrintifyConnector.class);
    private static final String BASE_URL = "https://api.printify.com/v1/";
    private static final String CONTENT_TYPE = "application/json;charset=utf-8";

    private HttpClient httpClient;
    private HttpRequest httpRequest;

    private String authenticationToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIzN2Q0YmQzMDM1ZmUxMWU5YTgwM2FiN2VlYjNjY2M5NyIsImp0aSI6IjhmNzU2NWJlZjVjODk1YmU1ZWRkMGEzZDg4MjliZDM3M2YxY2IyNjEwZjdhOGZmYTJhYzc1NDNhZTQ0MWQ1N2IzNGEwOTc2MjRhOWY0NjA0IiwiaWF0IjoxNjk2MTgxNDA3LjgwMjE0LCJuYmYiOjE2OTYxODE0MDcuODAyMTQzLCJleHAiOjE3Mjc4MDM4MDcuNzk1NjY5LCJzdWIiOiIxNTM5OTUzMSIsInNjb3BlcyI6WyJzaG9wcy5tYW5hZ2UiLCJzaG9wcy5yZWFkIiwiY2F0YWxvZy5yZWFkIiwib3JkZXJzLnJlYWQiLCJvcmRlcnMud3JpdGUiLCJwcm9kdWN0cy5yZWFkIiwicHJvZHVjdHMud3JpdGUiLCJ3ZWJob29rcy5yZWFkIiwid2ViaG9va3Mud3JpdGUiLCJ1cGxvYWRzLnJlYWQiLCJ1cGxvYWRzLndyaXRlIiwicHJpbnRfcHJvdmlkZXJzLnJlYWQiXX0.AEe-eE9xNoS_3cvKntuIAwYNh-I8rdTXQ29gNPJFCFwvh5fKirxW2BMXwPq6MJ0iAu2CpvrnBYwm1778hpE";

    public PrintifyConnector() {
    	this.httpClient = HttpClient.newHttpClient();
    }

    public CompletableFuture<String> getApiData(String endpoint) {
        logger.info("Calling getApiData with endpoint: {}", endpoint);

        httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .header("Authorization", "Bearer " + authenticationToken)
                .header("Accept", CONTENT_TYPE)
                .build();

        try {
            return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                    .thenApply(response -> {
                        logger.info("Received response for endpoint: {}", endpoint);
                        return response.body();
                    });
        } catch (Exception e) {
            logger.error("Error while calling getApiData for endpoint: {}", endpoint, e);
            throw new RuntimeException("Failed to retrieve data from the API.", e);
        }
    }
}
