package com.printifyproject.printifyapi.connector;

import org.slf4j.Logger;
import java.util.List;
import com.printifyproject.printifyapi.model.shop.Shop;

public class ApiShop {
    private final ApiConnector apiConnector;

    public ApiShop(Logger logger) {
        apiConnector = new ApiConnector(logger);
    }

    public List<Shop> getShops() {
        return apiConnector.getList("shops.json", Shop.class);
    }
}
