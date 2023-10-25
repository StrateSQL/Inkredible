package com.printifyproject.printifyapi.connector;

import com.printifyproject.printifyapi.model.shop.Shop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApiShopTest {
    ApiShop apiShop;

    @BeforeEach
    void setUp() {
        Logger logger = LoggerFactory.getLogger(ApiShop.class);
        apiShop = new ApiShop(logger);
    }

    @Test
    void getShops() {
        List<Shop> shopList = apiShop.getShops();

        //Retrieve the only shop currently available
        Shop shop = shopList.get(0);

        assertEquals(11996530, shop.getShopId());
        assertEquals("Capstone", shop.getTitle());
        assertEquals("disconnected", shop.getSalesChannel());
    }
}