package com.printifyproject.orm.dto;

public class BlueprintPrintProviderVariantInfoDto {
    private int blueprintPrintProviderVariantId;
    private int variantKey;
    private String color;
    private String size;

    public BlueprintPrintProviderVariantInfoDto(int blueprintPrintProviderVariantId, int variantKey, String color, String size) {
        this.blueprintPrintProviderVariantId = blueprintPrintProviderVariantId;
        this.variantKey = variantKey;
        this.color = color;
        this.size = size;
    }

    public BlueprintPrintProviderVariantInfoDto() { }

    public int getBlueprintPrintProviderVariantId() {
        return blueprintPrintProviderVariantId;
    }

    public void setBlueprintPrintProviderVariantId(int blueprintPrintProviderVariantId) {
        this.blueprintPrintProviderVariantId = blueprintPrintProviderVariantId;
    }

    public int getVariantKey() {
        return variantKey;
    }

    public void setVariantKey(int variantKey) {
        this.variantKey = variantKey;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
