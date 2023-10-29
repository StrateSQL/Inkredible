package com.printifyproject.printifyapi.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import java.util.List;

public class MockUpImage {
    @JsonProperty("src")
    private URI src;

    @JsonProperty("variant_ids")
    private List<Integer> variantIds;

    @JsonProperty("position")
    private String position;

    @JsonProperty("is_default")
    private boolean isDefault;

    public URI getSrc() {
        return src;
    }

    public void setSrc(URI src) {
        this.src = src;
    }

    public List<Integer> getVariantIds() {
        return variantIds;
    }

    public void setVariantIds(List<Integer> variantIds) {
        this.variantIds = variantIds;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
