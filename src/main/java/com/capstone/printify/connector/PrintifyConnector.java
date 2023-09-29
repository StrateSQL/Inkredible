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

    private String authenticationToken = "password";

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
