package com.printifyproject.printifyapi.model.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PrintProvider {
    @JsonProperty("id")
    private int PrintProviderKey;

    @JsonProperty("location")
    private Location Location = new Location();

    @JsonProperty("title")
    private String Title = "";

    @JsonProperty("blueprints")
    private List<Blueprint> Blueprints = new ArrayList<>();

    public PrintProvider() {
    }

    public int getPrintProviderKey() {
        return PrintProviderKey;
    }

    public void setPrintProviderKey(int printProviderKey) {
        this.PrintProviderKey = printProviderKey;
    }

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location location) {
        this.Location = location;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public List<Blueprint> getBlueprints() {
        return Blueprints;
    }

    public void setBlueprints(List<Blueprint> blueprints) {
        Blueprints = blueprints;
    }
}
