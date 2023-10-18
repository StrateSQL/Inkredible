package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Blueprints")
public class Blueprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BlueprintId")
    private long blueprintId;

    @Column(name = "BlueprintKey")
    private int blueprintKey;

    @Column(name = "Title")
    private String title;

    @Column(name = "Model")
    private String model;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Description")
    private String description;

    private Collection<String> imageList;

    //Constructor for hibernate
    public Blueprint() { }

    public long getBlueprintId() {
        return blueprintId;
    }

    public void setBlueprintId(long blueprintId) {
        this.blueprintId = blueprintId;
    }

    public int getBlueprintKey() {
        return blueprintKey;
    }

    public void setBlueprintKey(int blueprintKey) {
        this.blueprintKey = blueprintKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<String> getImageList() {
        return imageList;
    }

    public void setImageList(Collection<String> imageList) {
        this.imageList = imageList;
    }
}

