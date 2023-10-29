package com.printifyproject.printifyapi.api;

import com.printifyproject.printifyapi.shop.Shop;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ApiShop {
    private final ApiConnector apiConnector;

    public ApiShop(Logger logger) {
        apiConnector = new ApiConnector(logger);
    }

    public List<Shop> getShops() {
        return apiConnector.getList("shops.json", Shop.class);
    }
}
