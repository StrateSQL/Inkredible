package com.printifyproject.printifyapi.model.shop;

import com.printifyproject.printifyapi.connector.ApiShop;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    List<Shop> shops;

    @BeforeEach
    void setUp() {
        Logger logger = LoggerFactory.getLogger(Shop.class);
        OkHttpClient httpClient = new OkHttpClient();
        var apiShop = new ApiShop(logger);
        shops = apiShop.getShops();
    }

    @Test
    void getShopId() {
        var shop = shops.get(0);
        assertEquals(11996530,shop.getShopId());
    }

    @Test
    void getTitle() {
        var shop = shops.get(0);
        assertEquals("Capstone",shop.getTitle());
    }

    @Test
    void getSalesChannel() {
        var shop = shops.get(0);
        assertEquals("disconnected",shop.getSalesChannel());
    }

}