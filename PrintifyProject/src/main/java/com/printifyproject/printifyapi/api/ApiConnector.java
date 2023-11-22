package com.printifyproject.printifyapi.api;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApiConnector {
    private static final String BASE_URL = "https://api.printify.com/v1/";
    private static final String CONTENT_TYPE = "application/json;charset=utf-8";
    private static final int CONNECT_TIMEOUT_SECONDS = 30;
    private static final int READ_TIMEOUT_SECONDS = 60;

    private final OkHttpClient httpClient;
    private final Logger logger;

    public ApiConnector(Logger logger) {
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .build();
        this.logger = logger;
    }

    private String getAuthenticationToken() {
        return "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIzN2Q0YmQzMDM1ZmUxMWU5YTgwM2FiN2VlYjNjY2M5NyIsImp0aSI6ImZkNTg1ZDMyYTY5YTA0Yzg4MmNlM2EyMDg0ZTc3MTdmYmRkOTc1MDRmNDZhM2M2ZTVmYTJmNzdhMjFiM2U5YmNlZDhjY2E2YzQ4ZWJlNWRmIiwiaWF0IjoxNzAwNjEzMzM0LjgyNDYzOSwibmJmIjoxNzAwNjEzMzM0LjgyNDY0NCwiZXhwIjoxNzMyMjM1NzM0LjgwOTI1Nywic3ViIjoiMTUzOTk1MzEiLCJzY29wZXMiOlsic2hvcHMubWFuYWdlIiwic2hvcHMucmVhZCIsImNhdGFsb2cucmVhZCIsIm9yZGVycy5yZWFkIiwib3JkZXJzLndyaXRlIiwicHJvZHVjdHMucmVhZCIsInByb2R1Y3RzLndyaXRlIiwid2ViaG9va3MucmVhZCIsIndlYmhvb2tzLndyaXRlIiwidXBsb2Fkcy5yZWFkIiwidXBsb2Fkcy53cml0ZSIsInByaW50X3Byb3ZpZGVycy5yZWFkIl19.AFgjJnEh6byoERJ5icK0qDI6khmumr8RvGYt5BG66YjTLvDKNmnZnDV-fMyPVST1HVT9wNUO-N6-DBXqIdY";
    }

    public Request createGetRequest(String endpoint) {
        logger.info(String.format("Creating GET request to %s", endpoint));
        return new Request.Builder()
                .url(BASE_URL + endpoint)
                .header("Accept", CONTENT_TYPE)
                .header("Authorization", "Bearer " + getAuthenticationToken())
                .get()
                .build();
    }

    public Request createPostRequest(String endpoint) {
        logger.info(String.format("Creating POST request to %s", endpoint));
        return new Request.Builder()
                .url(BASE_URL + endpoint)
                .header("Accept", CONTENT_TYPE)
                .header("Authorization", "Bearer " + getAuthenticationToken())
                .build();
    }

    public Request createPostRequest(String endpoint, RequestBody requestBody) {
        logger.info(String.format("Creating POST request to %s", endpoint));
        return new Request.Builder()
                .url(BASE_URL + endpoint)
                .header("Accept", CONTENT_TYPE)
                .header("Authorization", "Bearer " + getAuthenticationToken())
                .post(requestBody)
                .build();
    }

    public Request createPutRequest(String endpoint, RequestBody requestBody) {
        logger.info(String.format("Creating PUT request to %s", endpoint));
        return new Request.Builder()
                .url(BASE_URL + endpoint)
                .header("Accept", CONTENT_TYPE)
                .header("Authorization", "Bearer " + getAuthenticationToken())
                .put(requestBody)
                .build();
    }

    public Response sendRequest(Request request) {
        try {
            logger.info(String.format("Sending request to %s", request.url()));
            return httpClient.newCall(request).execute();
        } catch (IOException e) {
            logger.error("Error during HTTP request: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public <T> T getObject(String endpoint, Class<T> type) {
        logger.info(String.format("GET: %s", endpoint));
        Request request = createGetRequest(endpoint);

        try (Response response = sendRequest(request)) {
            logger.trace(response.message());

            if (response.isSuccessful()) {
                ObjectMapper objectMapper = new ObjectMapper();
                String json = response.body().string();
                return objectMapper.readValue(json, type); // Deserialize to a single object
            } else {
                String errorMessage = String.format("Unsuccessful response for GET request to %s. HTTP Status: %d", endpoint, response.code());
                logger.error(errorMessage);
                throw new IllegalStateException(errorMessage);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> getList(String endpoint, Class<T> type) {
        logger.info(String.format("GET: %s", endpoint));
        Request request = createGetRequest(endpoint);

        try (Response response = sendRequest(request)) {
            logger.trace(response.message());

            if (response.isSuccessful()) {
                ObjectMapper objectMapper = new ObjectMapper();
                String json = response.body().string();
                JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, type);
                return objectMapper.readValue(json, javaType);
            } else {
                String errorMessage = String.format("Unsuccessful response for GET request to %s. HTTP Status: %d", endpoint, response.code());
                logger.error(errorMessage);
                throw new IllegalStateException(errorMessage);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void postObject(String endpoint) {
        logger.info(String.format("POST: %s", endpoint));
        Request request = createPostRequest(endpoint);

        try (Response response = sendRequest(request)) {
            if (response.isSuccessful()) {
                logger.trace(response.message());
            } else {
                String errorMessage = String.format("Unsuccessful response for POST request to %s. HTTP Status: %d", endpoint, response.code());
                logger.error(errorMessage);
                throw new IllegalStateException(errorMessage);
            }
        }
    }

    public void postObject(String endpoint, String json) {
        logger.info(String.format("POST: %s", endpoint));
        RequestBody requestBody = RequestBody.create(json, MediaType.parse("application/json"));
        Request request = createPostRequest(endpoint, requestBody);

        try (Response response = sendRequest(request)) {
            if (response.isSuccessful()) {
                logger.trace(response.message());
            } else {
                String errorMessage = String.format("Unsuccessful response for POST request to %s. HTTP Status: %d", endpoint, response.code());
                logger.error(errorMessage);
                throw new IllegalStateException(errorMessage);
            }
        }
    }

    public <T> T postObject(String endpoint, Object requestObject, Class<T> type) {
        ObjectMapper outboundMapper = new ObjectMapper();
        String jsonRequestBody;
        try {
            jsonRequestBody = outboundMapper.writeValueAsString(requestObject);
        } catch (IOException e) {
            logger.error("Error serializing request object: " + e.getMessage());
            return null;
        }

        RequestBody requestBody = RequestBody.create(jsonRequestBody, MediaType.parse("application/json"));
        Request request = createPostRequest(endpoint, requestBody);

        try (Response response = sendRequest(request)) {
            if (response.isSuccessful()) {
                ObjectMapper inboundMapper = new ObjectMapper();
                String json = response.body().string();
                return inboundMapper.readValue(json, type);
            } else {
                String errorMessage = String.format("Unsuccessful response for POST request to %s. HTTP Status: %d", endpoint, response.code());
                logger.error(errorMessage);
                throw new IllegalStateException(errorMessage);
            }
        } catch (IOException e) {
            logger.error("Error during POST request or response handling: " + e.getMessage());
            return null;
        }
    }

    public void putObject(String endpoint, String jsonBody) {
        logger.info(String.format("PUT: %s", endpoint));
        RequestBody requestBody = RequestBody.create(jsonBody, MediaType.parse("application/json"));
        Request request = createPutRequest(endpoint, requestBody);

        try (Response response = sendRequest(request)) {
            if (response.isSuccessful()) {
                logger.trace(response.message());
            } else {
                String errorMessage = String.format("Unsuccessful response for PUT request to %s. HTTP Status: %d", endpoint, response.code());
                logger.error(errorMessage);
                throw new IllegalStateException(errorMessage);
            }
        }
    }
}
