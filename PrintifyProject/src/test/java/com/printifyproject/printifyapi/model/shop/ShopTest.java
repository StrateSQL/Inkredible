package com.printifyproject.printifyapi.model.shop;

import com.printifyproject.printifyapi.api.ApiShop;
import com.printifyproject.printifyapi.shop.Shop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopTest {
    List<Shop> shops;

    @BeforeEach
    void setUp() {
        Logger logger = LogManager.getLogger();
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