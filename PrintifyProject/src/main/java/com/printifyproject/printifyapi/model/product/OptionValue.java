package com.printifyproject.printifyapi.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class OptionValue {
    @JsonProperty("id")
    private int ProductOptionValueKey;

    @JsonProperty("title")
    private String Title;

    @JsonProperty("colors")
    private List<String> Colors;

    public int getProductOptionValueKey() {
        return ProductOptionValueKey;
    }

    public void setProductOptionValueKey(int productOptionValueKey) {
        this.ProductOptionValueKey = productOptionValueKey;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public List<String> getColors() {
        return Colors;
    }

    public void setColors(List<String> colors) {
        this.Colors = colors;
    }
}
