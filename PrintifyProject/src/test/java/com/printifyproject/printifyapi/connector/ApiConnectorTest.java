package com.printifyproject.printifyapi.connector;

import com.printifyproject.printifyapi.model.catalog.Blueprint;
import com.printifyproject.printifyapi.model.catalog.PrintProvider;
import com.printifyproject.printifyapi.model.shop.Shop;
import okhttp3.Request;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApiConnectorTest {
    ApiConnector apiConnector;
    private final String BASE_URL = "https://api.printify.com/v1/";
    private final String SHOPS_URL = "shops.json";
    private final String BLUEPRINTS_URL = "catalog/blueprints.json";

    @BeforeEach
    void setUp() {
        Logger Logger = LoggerFactory.getLogger(ApiConnector.class);
        apiConnector = new ApiConnector(Logger);
    }

    @Test
    void sendRequest() {
        /* Test 1: Create request to Printify's base URL */
        Request baseRequest = apiConnector.createRequest("");
        assertEquals(404, apiConnector.sendRequest(baseRequest).code());

        /* Test 2: Create unauthenticated request to retrieve blueprints from catalog */
        Request unauthenticatedRequest = new Request.Builder()
                .url(BASE_URL + BLUEPRINTS_URL)
                .build();
        assertEquals(401, apiConnector.sendRequest(unauthenticatedRequest).code());

        /* Test 3: Create request to retrieve blueprints from catalog */
        Request blueprintsRequest = apiConnector.createRequest(BLUEPRINTS_URL);
        assertEquals(200, apiConnector.sendRequest(blueprintsRequest).code());
    }

    @Test
    void createRequest() {
        //Create request for shops
        Request request = apiConnector.createRequest(SHOPS_URL);
        assertEquals("GET", request.method());
        assertEquals(BASE_URL + SHOPS_URL, request.url().toString());

        //Create request for blueprints belonging to a catalog
        Request blueprintsRequest = apiConnector.createRequest(BLUEPRINTS_URL);
        assertEquals(BASE_URL + BLUEPRINTS_URL, blueprintsRequest.url().toString());

        //Create request for print providers
        Request printProvidersRequest = apiConnector.createRequest("catalog/print_providers.json");
        assertEquals(BASE_URL + "catalog/print_providers.json", printProvidersRequest.url().toString());
    }

    @Test
    void getObject() {
        //Get the Object shop
        Shop[] shops = apiConnector.getObject(SHOPS_URL, Shop[].class);
        Shop shop = shops[0];
        System.out.println(shop.getShopId() + shop.getTitle() + shop.getSalesChannel());

//        apiConnector.getObject(BLUEPRINTS_URL, PrintProvider[].class);
    }

    @Test
    void getList() {
        List<Shop> shopList = apiConnector.getList(SHOPS_URL, Shop.class);
        Shop shop = shopList.get(0);

        assertEquals(11996530, shop.getShopId());
        assertEquals("Capstone", shop.getTitle());
        assertEquals("disconnected", shop.getSalesChannel());

        List<PrintProvider> printProviders = apiConnector.getList("catalog/print_providers.json", PrintProvider.class);
        assertEquals("AVMM", printProviders.get(0).getTitle());
//        apiConnector.getList(BLUEPRINTS_URL, Blueprint.class);
    }

    @AfterEach
    void tearDown() {
        apiConnector = null;
    }
}