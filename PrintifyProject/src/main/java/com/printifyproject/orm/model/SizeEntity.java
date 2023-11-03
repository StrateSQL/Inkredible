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
    private int id;

    @Column(name = "Size", length = 50)
    private String size;

    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BlueprintPrintProviderVariantEntity> blueprintPrintProviderVariants = new HashSet<>();

    public SizeEntity() {}

    public SizeEntity(String size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int sizeId) {
        this.id = sizeId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Set<BlueprintPrintProviderVariantEntity> getBlueprintPrintProviderVariants() {
        return blueprintPrintProviderVariants;
    }

    public void setBlueprintPrintProviderVariants(Set<BlueprintPrintProviderVariantEntity> blueprintPrintProviderVariants) {
        this.blueprintPrintProviderVariants = blueprintPrintProviderVariants;
    }

}
