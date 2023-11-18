package com.printifyproject.printifyapi.api;

import com.printifyproject.printifyapi.product.Product;
import com.printifyproject.printifyapi.product.ProductSet;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

public class ApiProduct {

    private final ApiConnector apiConnector;

    public ApiProduct(Logger logger) {
        apiConnector = new ApiConnector(logger);
    }

    public Product getProduct(int shopId, String productId) {
        var endpoint = String.format("shops/%s/products/%s.json", shopId, productId);
        return apiConnector.getObject(endpoint, Product.class);
    }

    public ProductSet getProducts(int shopId) {
        return getProducts(shopId, 10, null);
    }

    public ProductSet getProducts(int shopId, @Nullable Integer limit){
        return getProducts(shopId, limit, null);
    }

    public ProductSet getProducts(int shopId, @Nullable Integer limit, @Nullable Integer page) {
        if (limit != null && limit > 100) {
            throw new IllegalArgumentException("Limit cannot be more than 100.");
        }

        String endpoint = "shops/" + shopId + "/products.json";

        if ((limit != null && limit != 10) || page != null) {
            endpoint += "?";
            if (limit != null && limit != 10) {
                endpoint += "limit=" + limit;
            }
            if (page != null) {
                if (limit != null && limit != 10) {
                    endpoint += "&";
                }
                endpoint += "page=" + page;
            }
        }

        return apiConnector.getObject(endpoint, ProductSet.class);
    }

    public Product CreateProduct(int shopId, Product product) {
        String endpoint = String.format("shops/%d/products.json", shopId);
        return apiConnector.postObject(endpoint, product, Product.class);
    }

    public void PublishProduct(int shopId, String productKey) {
        String endpoint = String.format("shops/%d/products/%s/publish.json", shopId, productKey);
        String message = """
                {
                    "title": true,
                    "description": true,
                    "images": true,
                    "variants": true,
                    "tags": true,
                    "keyFeatures": true,
                    "shipping_template": true
                }""";

        apiConnector.postObject(endpoint, message);
    }
}
