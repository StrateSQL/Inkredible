package com.printifyproject.printifyapi.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Variant {
    @JsonProperty("id")
    private int VariantKey;

    @JsonProperty("price")
    private int Price;

    @JsonProperty("cost")
    private int Cost;

    @JsonProperty("title")
    private String Title = "";

    @JsonProperty("sku")
    private String Sku = "";

    @JsonProperty("grams")
    private int Grams;

    @JsonProperty("is_enabled")
    private boolean IsEnabled;

    @JsonProperty("is_default")
    private boolean IsDefault;

    @JsonProperty("is_available")
    private boolean IsAvailable;

    @JsonProperty("is_printify_express_eligible")
    private boolean IsPrintifyExpressEligible;

    @JsonProperty("options")
    private List<Integer> Options;

    @JsonProperty("quantity")
    private int Quantity;

    public int getVariantKey() {
        return VariantKey;
    }

    public void setVariantKey(int variantKey) {
        this.VariantKey = variantKey;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        this.Price = price;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        this.Cost = cost;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getSku() {
        return Sku;
    }

    public void setSku(String sku) {
        this.Sku = sku;
    }

    public int getGrams() {
        return Grams;
    }

    public void setGrams(int grams) {
        this.Grams = grams;
    }

    public boolean isEnabled() {
        return IsEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.IsEnabled = isEnabled;
    }

    public boolean isDefault() {
        return IsDefault;
    }

    public void setDefault(boolean isDefault) {
        this.IsDefault = isDefault;
    }

    public boolean isAvailable() {
        return IsAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.IsAvailable = isAvailable;
    }

    public boolean isPrintifyExpressEligible() {
        return IsPrintifyExpressEligible;
    }

    public void setPrintifyExpressEligible(boolean isPrintifyExpressEligible) {
        this.IsPrintifyExpressEligible = isPrintifyExpressEligible;
    }

    public List<Integer> getOptions() {
        return Options;
    }

    public void setOptions(List<Integer> options) {
        this.Options = options;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }
}
