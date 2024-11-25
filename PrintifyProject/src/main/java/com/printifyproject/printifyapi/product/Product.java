package com.printifyproject.printifyapi.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.Null;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    @JsonProperty("id")
    private String ProductKey;

    @JsonProperty("title")
    private String Title;

    @JsonProperty("description")
    private String Description;

    @JsonProperty("tags")
    private List<String> Tags = new ArrayList<>();

    @JsonProperty("options")
    private List<Option> Options = new ArrayList<>();

    @JsonProperty("variants")
    private List<Variant> Variants = new ArrayList<>();

    @JsonProperty("images")
    private List<Image> Images = new ArrayList<>();

    @JsonProperty("created_at")
    private String CreatedAt;

    @JsonProperty("updated_at")
    private String UpdatedAt;

    @JsonProperty("visible")
    private boolean Visible;

    @JsonProperty("blueprint_id")
    private int BlueprintKey;

    @JsonProperty("print_provider_id")
    private int PrintProviderKey;

    @JsonProperty("user_id")
    private int UserId;

    @JsonProperty("shop_id")
    private int ShopId;

    @JsonProperty("print_areas")
    private List<PrintArea> PrintAreas = new ArrayList<>();

    @JsonProperty("print_on_side")
    private String PrintOnSide;
    @Null
    @JsonProperty("external")
    private List<Option> External = new ArrayList<>();
    @Null
    @JsonProperty("is_locked")
    private boolean IsLocked;
    @Null
    @JsonProperty("font_color")
    private String FontColor;
    @Null
    @JsonProperty("font_family")
    private String FontFamily;

    @Null
    @JsonProperty("is_printify_express_enabled")
    private Boolean IsPrintifyExpressEligible;

    @Null
    @JsonProperty("sales_channel_properties")
    private List<String> SalesChannelProperties;

    @Null
    @JsonProperty("print_details")
    private List<JsonNode> PrintDetails = new ArrayList<>();

    public String getProductKey() {
        return ProductKey;
    }

    public void setProductKey(String productKey) {
        this.ProductKey = productKey;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public List<String> getTags() {
        return Tags;
    }

    public void setTags(List<String> tags) {
        this.Tags = tags;
    }

    public List<Option> getOptions() {
        return Options;
    }

    public void setOptions(List<Option> options) {
        this.Options = options;
    }

    public List<Variant> getVariants() {
        return Variants;
    }

    public void setVariants(List<Variant> variants) {
        this.Variants = variants;
    }

    public List<Image> getImages() {
        return Images;
    }

    public void setImages(List<Image> images) {
        this.Images = images;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        this.CreatedAt = createdAt;
    }

    public String getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.UpdatedAt = updatedAt;
    }

    public boolean isVisible() {
        return Visible;
    }

    public void setVisible(boolean visible) {
        this.Visible = visible;
    }

    public int getBlueprintKey() {
        return BlueprintKey;
    }

    public void setBlueprintKey(int blueprintKey) {
        this.BlueprintKey = blueprintKey;
    }

    public int getPrintProviderKey() {
        return PrintProviderKey;
    }

    public void setPrintProviderKey(int printProviderKey) {
        this.PrintProviderKey = printProviderKey;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        this.UserId = userId;
    }

    public int getShopId() {
        return ShopId;
    }

    public void setShopId(int shopId) {
        this.ShopId = shopId;
    }

    public List<PrintArea> getPrintAreas() {
        return PrintAreas;
    }

    public void setPrintAreas(List<PrintArea> printAreas) {
        this.PrintAreas = printAreas;
    }

    public String getPrintOnSide() {
        return PrintOnSide;
    }

    public void setPrintOnSide(String printOnSide) {
        this.PrintOnSide = printOnSide;
    }

    public boolean isIsLocked() {
        return IsLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.IsLocked = isLocked;
    }

    public String getFontColor() {
        return FontColor;
    }

    public void setFontColor(String fontColor) {
        this.FontColor = fontColor;
    }

    public String getFontFamily() {
        return FontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.FontFamily = fontFamily;
    }

    public Boolean getIsPrintifyExpressEligible() {
        return IsPrintifyExpressEligible;
    }

    public void setIsPrintifyExpressEligible(Boolean isPrintifyExpressEligible) {
        this.IsPrintifyExpressEligible = isPrintifyExpressEligible;
    }

    public List<String> getSalesChannelProperties() {
        return SalesChannelProperties;
    }

    public void setSalesChannelProperties(List<String> salesChannelProperties) {
        this.SalesChannelProperties = salesChannelProperties;
    }

    public List<Option> getExternal() {
        return External;
    }

    public void setExternal(List<Option> external) {
        External = external;
    }

    public List<JsonNode> getPrintDetails() {
        return PrintDetails;
    }

    public void setPrintDetails(List<JsonNode> printDetails) {
        PrintDetails = printDetails;
    }

    public boolean isLocked() {
        return IsLocked;
    }

    public void setLocked(boolean locked) {
        IsLocked = locked;
    }

    public Boolean getPrintifyExpressEligible() {
        return IsPrintifyExpressEligible;
    }

    public void setPrintifyExpressEligible(Boolean printifyExpressEligible) {
        IsPrintifyExpressEligible = printifyExpressEligible;
    }
}
