package com.printifyproject.printifyapi.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class VariantSet {
    @JsonProperty("id")
    private int VariantKey;

    @JsonProperty("title")
    private String Title = "";

    @JsonProperty("variants")
    private List<Variant> Variants = new ArrayList<>();

    public VariantSet() {
    }

    public int getVariantKey() {
        return VariantKey;
    }

    public void setVariantKey(int variantKey) {
        this.VariantKey = variantKey;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public List<Variant> getVariants() {
        return Variants;
    }

    public void setVariants(List<Variant> variants) {
        this.Variants = variants;
    }
}
