package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "blueprintprintprovidercolors", schema = "inkcredible")
public class BlueprintPrintProviderColorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BlueprintPrintProviderColorId", nullable = false)
    private int blueprintPrintProviderColorId;
    @Basic
    @Column(name = "BlueprintPrintProviderId", nullable = true, insertable=false, updatable=false)
    private Integer blueprintPrintProviderId;
    @Basic
    @Column(name = "ColorId", nullable = true, insertable=false, updatable=false)
    private Integer colorId;
    @ManyToOne
    @JoinColumn(name = "BlueprintPrintProviderId", referencedColumnName = "BlueprintPrintProviderId")
    private BlueprintPrintProviderEntity blueprintprintprovidersByBlueprintPrintProviderId;
    @ManyToOne
    @JoinColumn(name = "ColorId")
    private ColorEntity colorInBlueprintPrintProvider;

    public int getBlueprintPrintProviderColorId() {
        return blueprintPrintProviderColorId;
    }

    public void setBlueprintPrintProviderColorId(int blueprintPrintProviderColorId) {
        this.blueprintPrintProviderColorId = blueprintPrintProviderColorId;
    }

    public Integer getBlueprintPrintProviderId() {
        return blueprintPrintProviderId;
    }

    public void setBlueprintPrintProviderId(Integer blueprintPrintProviderId) {
        this.blueprintPrintProviderId = blueprintPrintProviderId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlueprintPrintProviderColorEntity that = (BlueprintPrintProviderColorEntity) o;
        return blueprintPrintProviderColorId == that.blueprintPrintProviderColorId && Objects.equals(blueprintPrintProviderId, that.blueprintPrintProviderId) && Objects.equals(colorId, that.colorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blueprintPrintProviderColorId, blueprintPrintProviderId, colorId);
    }

    public BlueprintPrintProviderEntity getBlueprintprintprovidersByBlueprintPrintProviderId() {
        return blueprintprintprovidersByBlueprintPrintProviderId;
    }

    public void setBlueprintprintprovidersByBlueprintPrintProviderId(BlueprintPrintProviderEntity blueprintprintprovidersByBlueprintPrintProviderId) {
        this.blueprintprintprovidersByBlueprintPrintProviderId = blueprintprintprovidersByBlueprintPrintProviderId;
    }

    public ColorEntity getColorInBlueprintPrintProvider() {
        return colorInBlueprintPrintProvider;
    }

    public void setColorInBlueprintPrintProvider(ColorEntity colorsByColorId) {
        this.colorInBlueprintPrintProvider = colorsByColorId;
    }
}
