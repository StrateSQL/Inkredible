package com.printifyproject.printifyapi.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Shop {
    private static final Logger logger = LogManager.getLogger();

    @Id
    @JsonProperty("id")
    private int shopId;

    @NotBlank
    private String title = "";

    @NotBlank
    @JsonProperty("sales_channel")
    private String salesChannel = "disconnected";

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        logger.info("Title set for Shop with ID: {}", shopId);
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
        logger.info("Sales channel set for Shop with ID: {}", shopId);
    }
}
