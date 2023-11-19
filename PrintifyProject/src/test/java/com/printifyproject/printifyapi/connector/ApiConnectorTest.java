package com.printifyproject.printifyapi.connector;

import com.printifyproject.printifyapi.api.ApiConnector;
import com.printifyproject.printifyapi.catalog.*;
import com.printifyproject.printifyapi.shop.Shop;
import okhttp3.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiConnectorTest {
    ApiConnector apiConnector;
    private final String BASE_URL = "https://api.printify.com/v1/";
    private final String SHOPS_URL = "shops.json";
    private final String BLUEPRINTS_URL = "catalog/blueprints.json";

    @BeforeEach
    void setUp() {
        Logger logger = LogManager.getLogger();
        apiConnector = new ApiConnector(logger);
    }

    @Test
    void sendRequest() {
        /* Create & send unauthenticated request to retrieve blueprints from catalog */
        Request unauthenticatedRequest = new Request.Builder()
                .url(BASE_URL + BLUEPRINTS_URL)
                .build();
        assertEquals(401, apiConnector.sendRequest(unauthenticatedRequest).code());

        /* Create & send request to Printify's base URL */
        Request baseRequest = apiConnector.createGetRequest("");
        assertEquals(404, apiConnector.sendRequest(baseRequest).code());

        /* Create & send request to retrieve blueprints from catalog */
        Request blueprintsRequest = apiConnector.createGetRequest(BLUEPRINTS_URL);
        assertEquals(200, apiConnector.sendRequest(blueprintsRequest).code());
    }

    @Test
    void createRequest() {
        //Create request for shops
        Request request = apiConnector.createGetRequest(SHOPS_URL);
        assertEquals("GET", request.method());
        assertEquals(BASE_URL + SHOPS_URL, request.url().toString());

        //Create request for blueprints belonging to a catalog
        Request blueprintsRequest = apiConnector.createGetRequest(BLUEPRINTS_URL);
        assertEquals(BASE_URL + BLUEPRINTS_URL, blueprintsRequest.url().toString());

        //Create request for print providers
        Request printProvidersRequest = apiConnector.createGetRequest("catalog/print_providers.json");
        assertEquals(BASE_URL + "catalog/print_providers.json", printProvidersRequest.url().toString());
    }

    @Test
    void getObject() {
        //Get the array of shops,
        Shop[] shops = apiConnector.getObject(SHOPS_URL, Shop[].class);
        assertEquals(1, shops.length);  //Only 1 shop to get

        Shop capstoneShop = shops[0];
        assertEquals(11996530, capstoneShop.getShopId());
        assertEquals("Capstone", capstoneShop.getTitle());
        assertEquals("disconnected", capstoneShop.getSalesChannel());


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


    }

    @AfterEach
    void tearDown() {
        apiConnector = null;
    }
}