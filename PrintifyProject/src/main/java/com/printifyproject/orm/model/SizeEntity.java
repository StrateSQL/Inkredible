package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sizes", schema = "inkcredible")
public class SizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SizeId", nullable = false)
    private int sizeId;

    @Basic
    @Column(name = "Size", nullable = true, length = 50)
    private String size;

    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BlueprintPrintProviderSizeEntity> blueprintPrintProviderSizes = new HashSet<>();

    public SizeEntity() {}

    public SizeEntity(String size) {
        this.size = size;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Set<BlueprintPrintProviderSizeEntity> getBlueprintPrintProviderSizes() {
        return blueprintPrintProviderSizes;
    }

    public void addBlueprintPrintProviderSize(BlueprintPrintProviderSizeEntity blueprintPrintProviderSize) {
        blueprintPrintProviderSizes.add(blueprintPrintProviderSize);
        blueprintPrintProviderSize.setSize(this);
    }

    // Method to remove a BlueprintPrintProviderSizeEntity
    public void removeBlueprintPrintProviderSize(BlueprintPrintProviderSizeEntity blueprintPrintProviderSize) {
        blueprintPrintProviderSizes.remove(blueprintPrintProviderSize);
        blueprintPrintProviderSize.setSize(null);
    }
}
