package com.printifyproject.printifyapi.api;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class ApiConnector {
    private static final String BASE_URL = "https://api.printify.com/v1/";
    private static final String CONTENT_TYPE = "application/json;charset=utf-8";

    private final OkHttpClient httpClient;
    private final Logger logger;

    public ApiConnector(Logger logger) {
        this.httpClient = new OkHttpClient();
        this.logger = logger;
    }

    public Response sendRequest(Request request) {
        logger.info(String.format("Sending request to %s", request.url()));
        Response response = null;
        try {
            response = this.httpClient.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    public Request createRequest(String endpoint) {
        logger.info(String.format("Creating request to %s", endpoint));
        String authenticationToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIzN2Q0YmQzMDM1ZmUxMWU5YTgwM2FiN2VlYjNjY2M5NyIsImp0aSI6IjhmNzU2NWJlZjVjODk1YmU1ZWRkMGEzZDg4MjliZDM3M2YxY2IyNjEwZjdhOGZmYTJhYzc1NDNhZTQ0MWQ1N2IzNGEwOTc2MjRhOWY0NjA0IiwiaWF0IjoxNjk2MTgxNDA3LjgwMjE0LCJuYmYiOjE2OTYxODE0MDcuODAyMTQzLCJleHAiOjE3Mjc4MDM4MDcuNzk1NjY5LCJzdWIiOiIxNTM5OTUzMSIsInNjb3BlcyI6WyJzaG9wcy5tYW5hZ2UiLCJzaG9wcy5yZWFkIiwiY2F0YWxvZy5yZWFkIiwib3JkZXJzLnJlYWQiLCJvcmRlcnMud3JpdGUiLCJwcm9kdWN0cy5yZWFkIiwicHJvZHVjdHMud3JpdGUiLCJ3ZWJob29rcy5yZWFkIiwid2ViaG9va3Mud3JpdGUiLCJ1cGxvYWRzLnJlYWQiLCJ1cGxvYWRzLndyaXRlIiwicHJpbnRfcHJvdmlkZXJzLnJlYWQiXX0.AEe-eE9xNoS_3cvKntuIAwYNh-I8rdTXQ29gNPJFCFwvh5fKirxW2BMXwPq6MJ0iAu2CpvrnBYwm1778hpE";
        return new Request.Builder()
                .url(BASE_URL + endpoint)
                .get()
                .header("Accept", CONTENT_TYPE)
                .header("Authorization", "Bearer " + authenticationToken)
                .build();
    }

    public <T> T getObject(String endpoint, Class<T> type) {
        logger.info(String.format("GET: %s", endpoint));
        Request request = createRequest(endpoint);
        Response response = null;

        try {
            response = sendRequest(request);

            logger.trace(response.message());

            if (response.isSuccessful()) {
                ObjectMapper objectMapper = new ObjectMapper();
                String json = response.body().string();
                return objectMapper.readValue(json, type); // Deserialize to a single object
            } else {
                // Handle the unsuccessful response.
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> getList(String endpoint, Class<T> type) {
        logger.info(String.format("GET: %s", endpoint));
        Request request = createRequest(endpoint);
        Response response = null;

        try {
            response = sendRequest(request);

            logger.trace(response.message());

            if (response.isSuccessful()) {
                ObjectMapper objectMapper = new ObjectMapper();
                String json = response.body().string();
                JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, type);
                return objectMapper.readValue(json, javaType);
            } else {
                // Handle the unsuccessful response.
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
