package com.printifyproject.printifyapi.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Blueprint {
    @JsonProperty("id")
    private int BlueprintKey;

    @NotNull
    @JsonProperty("title")
    private String Title = "";

    @NotNull
    @JsonProperty("description")
    private String Description = "";

    @NotNull
    @JsonProperty("brand")
    private String Brand = "";

    @NotNull
    @JsonProperty("model")
    private String Model = "";

    @NotNull
    @JsonProperty("images")
    private List<String> Images;

    private List<String> ImageList = new ArrayList<>();

    public Blueprint() {
    }

    public int getBlueprintKey() {
        return BlueprintKey;
    }

    public void setBlueprintKey(int blueprintKey) {
        this.BlueprintKey = blueprintKey;
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

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        this.Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        this.Model = model;
    }

    public List<String> getImages() {
        return Images;
    }

    public void setImages(List<String> images) {
        this.Images = images;
        //ImageList = convertImagesToList(images);
    }

    public List<String> getImageList() {
        return ImageList;
    }

    private List<String> convertImagesToList(String images) {
        List<String> imageList = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(images);

            if (root.isObject()) {
                root.fields().forEachRemaining(entry -> imageList.add(entry.getValue().asText()));
            } else if (root.isArray()) {
                root.elements().forEachRemaining(element -> imageList.add(element.asText()));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return imageList;
    }
}
