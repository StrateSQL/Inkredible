package com.printifyproject.printifyapi.connector;

import com.printifyproject.printifyapi.api.ApiProduct;
import com.printifyproject.printifyapi.product.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApiProductTest {
    ApiProduct apiProduct;
    private final int shopId = 11996530;

    @BeforeEach
    void setUp() {
        Logger logger = LogManager.getLogger(ApiProduct.class);
        apiProduct = new ApiProduct(logger);
    }

    @Test
    void getProduct() {
        assertEquals(null, apiProduct.getProduct(shopId, ""));
        assertEquals(null, apiProduct.getProduct(shopId, "0"));
        assertEquals(null, apiProduct.getProduct(shopId, "Test"));
    }

    //getProducts method which only takes an argument of shop id
    @Test
    void getProducts() {
        ProductSet productSet = apiProduct.getProducts(shopId);
        assertEquals(1, apiProduct.getProducts(shopId).getCurrent_page());
        assertEquals(0, apiProduct.getProducts(shopId).getTotal());
    }

    //getProducts method that also takes 2nd argument of limit for max number of results
    @Test
    void testGetProducts() {
        ProductSet productSet = apiProduct.getProducts(shopId, 20);
        List<Product> productList = productSet.getProducts();
        assertEquals(0, productList.size());
        assertThrows(IllegalArgumentException.class, () -> apiProduct.getProducts(shopId, 101));
    }

    //getProducts method that takes a 3rd argument for the page desired to retrieve
    @Test
    void testGetProducts1() {
        assertEquals(0, apiProduct.getProducts(shopId, 10, 1).getProducts().size());
        assertEquals(0, apiProduct.getProducts(shopId, 1, 1).getProducts().size());
        assertThrows(IllegalArgumentException.class, () -> apiProduct.getProducts(shopId, 101, 1));
    }
}
