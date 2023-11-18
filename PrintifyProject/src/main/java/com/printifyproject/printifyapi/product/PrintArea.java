package com.printifyproject.printifyapi.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PrintArea {
    @JsonProperty("variant_ids")
    private List<Integer> variantIds;
    @JsonProperty("placeholders")
    private List<Placeholder> placeholders;

    public List<Integer> getVariantIds() {
        return variantIds;
    }

    public void setVariantIds(List<Integer> variantIds) {
        this.variantIds = variantIds;
    }

    public List<Placeholder> getPlaceholders() {
        return placeholders;
    }

    public void setPlaceholders(List<Placeholder> placeholders) {
        this.placeholders = placeholders;
    }
}