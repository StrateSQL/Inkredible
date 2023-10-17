package com.printifyproject.printifyapi.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Placeholder {
    @JsonProperty("position")
    private String Position;

    @JsonProperty("images")
    private List<PlaceholderImage> Images;

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        this.Position = position;
    }

    public List<PlaceholderImage> getImages() {
        return Images;
    }

    public void setImages(List<PlaceholderImage> images) {
        this.Images = images;
    }
}
