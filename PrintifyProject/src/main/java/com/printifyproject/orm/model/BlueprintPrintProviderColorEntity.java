package com.printifyproject.orm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "blueprintprintprovidercolors", schema = "inkcredible")
public class BlueprintPrintProviderColorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BlueprintPrintProviderColorId", nullable = false)
    private int blueprintPrintProviderColorId;

    @ManyToOne
    @JoinColumn(name = "BlueprintPrintProviderId")
    private BlueprintPrintProviderEntity blueprintPrintProvider;

    @ManyToOne
    @JoinColumn(name = "ColorId")
    private ColorEntity color;

    public BlueprintPrintProviderColorEntity() {
    }

    public int getBlueprintPrintProviderColorId() {
        return blueprintPrintProviderColorId;
    }

    public void setBlueprintPrintProviderColorId(int blueprintPrintProviderColorId) {
        this.blueprintPrintProviderColorId = blueprintPrintProviderColorId;
    }

    public BlueprintPrintProviderEntity getBlueprintPrintProvider() {
        return blueprintPrintProvider;
    }

    public void setBlueprintPrintProvider(BlueprintPrintProviderEntity blueprintPrintProvider) {
        this.blueprintPrintProvider = blueprintPrintProvider;
    }

    public ColorEntity getColor() {
        return color;
    }

    public void setColor(ColorEntity color) {
        this.color = color;
    }
}
