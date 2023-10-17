package com.printifyproject.printifyapi.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PublishingProperty {
    @JsonProperty("images")
    private boolean Images = true;

    @JsonProperty("variants")
    private boolean Variants = true;

    @JsonProperty("title")
    private boolean Title = true;

    @JsonProperty("description")
    private boolean Description = true;

    @JsonProperty("tags")
    private boolean Tags = true;

    public boolean isImages() {
        return Images;
    }

    public void setImages(boolean images) {
        this.Images = images;
    }

    public boolean isVariants() {
        return Variants;
    }

    public void setVariants(boolean variants) {
        this.Variants = variants;
    }

    public boolean isTitle() {
        return Title;
    }

    public void setTitle(boolean title) {
        this.Title = title;
    }

    public boolean isDescription() {
        return Description;
    }

    public void setDescription(boolean description) {
        this.Description = description;
    }

    public boolean isTags() {
        return Tags;
    }

    public void setTags(boolean tags) {
        this.Tags = tags;
    }
}
