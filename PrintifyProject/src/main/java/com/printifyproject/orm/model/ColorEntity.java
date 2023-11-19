package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "colors", schema = "inkcredible")
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ColorId", nullable = false)
    private int id;

    @Column(name = "Color", length = 50)
    private String color;

    @Column(name = "Hex", length = 10)
    private String hex;

    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BlueprintPrintProviderVariantEntity> blueprintPrintProviderVariants = new HashSet<>();

    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<PrintSpecColorEntity> printSpecColors = new HashSet<>();

    public ColorEntity() {}

    public ColorEntity(String color) {
        this.color = color;
    }

    public ColorEntity(String color, String hex) {
        this.color = color;
        this.hex = hex;
    }

    public int getId() {
        return id;
    }

    public void setId(int colorId) {
        this.id = colorId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public Set<BlueprintPrintProviderVariantEntity> getBlueprintPrintProviderVariants() {
        return blueprintPrintProviderVariants;
    }

    public void setBlueprintPrintProviderVariants(Set<BlueprintPrintProviderVariantEntity> blueprintPrintProviderVariants) {
        this.blueprintPrintProviderVariants = blueprintPrintProviderVariants;
    }

}
