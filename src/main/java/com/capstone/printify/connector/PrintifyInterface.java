package com.capstone.printify.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class PrintifyInterface {

    private static final String BASE_URL = "https://api.printify.com/v1/";
    private static final String CONTENT_TYPE = "application/json;charset=utf-8";

    private HttpClient httpClient;
    private HttpRequest httpRequest;
    private Logger logger;

    private String authenticationToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIzN2Q0YmQzMDM1ZmUxMWU5YTgwM2FiN2VlYjNjY2M5NyIsImp0aSI6IjA2NTc1NzE4YjBkOTI1ZDNkZWFjZjNlMDhjNGZhNWQyMWExNjk4ZmVmYzVkNzMyNTYzM2NjNmJlMjFlZDUxYzczMWNkMGI2YWE3YzBlYjExIiwiaWF0IjoxNjkzMTA1MTQ5Ljg1MTM1NywibmJmIjoxNjkzMTA1MTQ5Ljg1MTM2LCJleHAiOjE3MjQ3Mjc1NDkuODQ1OTgsInN1YiI6IjEwMTI0ODA1Iiwic2NvcGVzIjpbInNob3BzLm1hbmFnZSIsInNob3BzLnJlYWQiLCJjYXRhbG9nLnJlYWQiLCJvcmRlcnMucmVhZCIsIm9yZGVycy53cml0ZSIsInByb2R1Y3RzLnJlYWQiLCJwcm9kdWN0cy53cml0ZSIsIndlYmhvb2tzLnJlYWQiLCJ3ZWJob29rcy53cml0ZSIsInVwbG9hZHMucmVhZCIsInVwbG9hZHMud3JpdGUiLCJwcmludF9wcm92aWRlcnMucmVhZCJdfQ.AmA2xf6psCM9knT3uFiNtD2mVa9CkUwzgkLR3nWwltCzw0-y38Tn-lVyzvCDnAiWaeUdqPM9PA2ZD0fEojs";

    public PrintifyInterface(Logger logger) {
    	this.httpClient = HttpClient.newHttpClient();
    	HttpRequest httpRequest = HttpRequest.newBuilder()
    	        .uri(URI.create(BASE_URL))
    	        .build();
    }

    public CompletableFuture<String> getApiData(String authenticationToken) {
        // Build the request with the "Authorization" header
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "endpoint"))  // Replace with your endpoint
                .header("Authorization", "Bearer " + authenticationToken)
                .header("Accept", CONTENT_TYPE)
                .build();

        // Send the request asynchronously
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }
}
