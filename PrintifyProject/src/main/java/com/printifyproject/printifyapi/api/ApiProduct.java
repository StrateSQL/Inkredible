package com.printifyproject.printifyapi.api;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

    public void PublishProduct(int shopId, String productKey, boolean isUpdate) {
        String endpoint = String.format("shops/%d/products/%s/publish.json", shopId, productKey);
        String message = buildPublishCommand(isUpdate);
        apiConnector.postObject(endpoint, message);
    }

    private String buildPublishCommand(boolean isUpdate) {
        JsonNodeFactory factory = JsonNodeFactory.instance;

        ObjectNode rootNode = factory.objectNode();
        rootNode.put("title", true);
        rootNode.put("description", true);
        rootNode.put("images", !isUpdate);
        rootNode.put("variants", !isUpdate);
        rootNode.put("tags", !isUpdate);
        rootNode.put("keyFeatures", !isUpdate);
        rootNode.put("shipping_template", !isUpdate);

        return rootNode.toString();
    }

    public void ModifyProduct(int shopId, String jsonBody, String productKey) {
        String endpoint;

        endpoint = String.format("shops/%d/products/%s.json", shopId, productKey);
        apiConnector.putObject(endpoint, jsonBody);

        PublishProduct(shopId, productKey, true);
    }
}
