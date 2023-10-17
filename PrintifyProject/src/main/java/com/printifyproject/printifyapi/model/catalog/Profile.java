package com.printifyproject.printifyapi.model.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    @JsonProperty("variant_ids")
    private List<Integer> VariantIds = new ArrayList<>();

    @JsonProperty("first_item")
    private ProfileItem FirstItem = new ProfileItem();

    @JsonProperty("additional_items")
    private ProfileItem AdditionalItems = new ProfileItem();

    @JsonProperty("countries")
    private List<String> Countries = new ArrayList<>();

    public Profile() {
    }

    public List<Integer> getVariantIds() {
        return VariantIds;
    }

    public void setVariantIds(List<Integer> variantIds) {
        this.VariantIds = variantIds;
    }

    public ProfileItem getFirstItem() {
        return FirstItem;
    }

    public void setFirstItem(ProfileItem firstItem) {
        this.FirstItem = firstItem;
    }

    public ProfileItem getAdditionalItems() {
        return AdditionalItems;
    }

    public void setAdditionalItems(ProfileItem additionalItems) {
        this.AdditionalItems = additionalItems;
    }

    public List<String> getCountries() {
        return Countries;
    }

    public void setCountries(List<String> countries) {
        this.Countries = countries;
    }
}
