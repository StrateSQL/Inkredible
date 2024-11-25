package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "blueprints", schema = "inkcredible")
public class BlueprintEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BlueprintId", nullable = false)
    private int blueprintId;
    @Basic
    @Column(name = "BlueprintKey", nullable = true, unique = true)
    private Integer blueprintKey;
    @Basic
    @Column(name = "Title", nullable = true, length = 255, unique = true)
    private String title;
    @Basic
    @Column(name = "Model", nullable = true, length = 255)
    private String model;
    @Basic
    @Column(name = "Brand", nullable = true, length = 255)
    private String brand;
    @Basic
    @Column(name = "Description", nullable = true, length = -1)
    private String description;
    @OneToMany(mappedBy = "blueprint", cascade = CascadeType.ALL)
    private Collection<BlueprintPrintProviderEntity> blueprintPrintProviders;

    public int getBlueprintId() {
        return blueprintId;
    }

    public void setBlueprintId(int blueprintId) {
        this.blueprintId = blueprintId;
    }

    public Integer getBlueprintKey() {
        return blueprintKey;
    }

    public void setBlueprintKey(Integer blueprintKey) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlueprintEntity that = (BlueprintEntity) o;
        return blueprintId == that.blueprintId && Objects.equals(blueprintKey, that.blueprintKey) && Objects.equals(title, that.title) && Objects.equals(model, that.model) && Objects.equals(brand, that.brand) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blueprintId, blueprintKey, title, model, brand, description);
    }

    public Collection<BlueprintPrintProviderEntity> getBlueprintPrintProviders() {
        return blueprintPrintProviders;
    }

    public void setBlueprintPrintProviders(Collection<BlueprintPrintProviderEntity> blueprintprintprovidersByBlueprintId) {
        this.blueprintPrintProviders = blueprintprintprovidersByBlueprintId;
    }

}
