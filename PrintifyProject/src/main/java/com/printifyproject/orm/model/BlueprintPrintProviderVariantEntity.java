package com.printifyproject.orm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "blueprintprintprovidervariants", schema = "inkcredible")
public class BlueprintPrintProviderVariantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BlueprintPrintProviderVariantId", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BlueprintPrintProviderId", nullable = false)
    private BlueprintPrintProviderEntity blueprintPrintProvider;

    @Column(name = "VariantKey", nullable = false)
    private int variantKey;

    @Column(name = "Title", nullable = false, length = 255)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SizeId")
    private SizeEntity size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ColorId")
    private ColorEntity color;

    public BlueprintPrintProviderVariantEntity() {}

    public BlueprintPrintProviderVariantEntity(SizeEntity size, BlueprintPrintProviderEntity blueprintPrintProvider) {
        this.blueprintPrintProvider = blueprintPrintProvider;
        this.size = size;
    }

    public BlueprintPrintProviderVariantEntity(BlueprintPrintProviderEntity blueprintPrintProvider, int variantKey, String title, SizeEntity size, ColorEntity color) {
        this.blueprintPrintProvider = blueprintPrintProvider;
        this.variantKey = variantKey;
        this.title = title;
        this.size = size;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int blueprintPrintProviderVariantId) {
        this.id = blueprintPrintProviderVariantId;
    }

    public BlueprintPrintProviderEntity getBlueprintPrintProvider() {
        return blueprintPrintProvider;
    }

    public void setBlueprintPrintProvider(BlueprintPrintProviderEntity blueprintPrintProvider) {
        this.blueprintPrintProvider = blueprintPrintProvider;
    }

    public int getVariantKey() {
        return variantKey;
    }

    public void setVariantKey(int variantKey) {
        this.variantKey = variantKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SizeEntity getSize() {
        return size;
    }

    public void setSize(SizeEntity size) {
        this.size = size;
    }

    public ColorEntity getColor() {
        return color;
    }

    public void setColor(ColorEntity color) {
        this.color = color;
    }
}
