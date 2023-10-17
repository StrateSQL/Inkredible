package com.printifyproject.printifyapi.model.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Variant {
    @JsonProperty("id")
    private int VariantKey;

    @JsonProperty("title")
    private String Title = "";

    @JsonProperty("options")
    private Option Options = new Option();

    @JsonProperty("placeholders")
    private List<Placeholder> Placeholders = new ArrayList<>();

    public Variant() {
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

    public Option getOptions() {
        return Options;
    }

    public void setOptions(Option options) {
        this.Options = options;
    }

    public List<Placeholder> getPlaceholders() {
        return Placeholders;
    }

    public void setPlaceholders(List<Placeholder> placeholders) {
        this.Placeholders = placeholders;
    }
}

