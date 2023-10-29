package com.printifyproject.printifyapi.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Image {
    private String Src;

    @JsonProperty("variant_ids")
    private List<Integer> VariantIds = new ArrayList<>();

    private String Position;

    @JsonProperty("is_default")
    private boolean IsDefault = false;

    @JsonProperty("is_selected_for_publishing")
    private boolean IsSelectedForPublishing = false;

    public String getSrc() {
        return Src;
    }

    public void setSrc(String src) {
        this.Src = src;
    }

    public List<Integer> getVariantIds() {
        return VariantIds;
    }

    public void setVariantIds(List<Integer> variantIds) {
        this.VariantIds = variantIds;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        this.Position = position;
    }

    public boolean isDefault() {
        return IsDefault;
    }

    public void setDefault(boolean isDefault) {
        this.IsDefault = isDefault;
    }

    public boolean isSelectedForPublishing() {
        return IsSelectedForPublishing;
    }

    public void setSelectedForPublishing(boolean isSelectedForPublishing) {
        this.IsSelectedForPublishing = isSelectedForPublishing;
    }
}
