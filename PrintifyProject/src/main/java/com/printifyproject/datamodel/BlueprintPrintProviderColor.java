package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "BlueprintPrintProviderColors", schema = "dbo", catalog = "printify-db")
public class BlueprintPrintProviderColor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BlueprintPrintProviderColorId", nullable = false)
    private int blueprintPrintProviderColorId;
    @Basic
    @Column(name = "BlueprintPrintProviderId", nullable = true)
    private Integer blueprintPrintProviderId;
    @Basic
    @Column(name = "ColorId", nullable = true)
    private Integer colorId;
    @ManyToOne
    @JoinColumn(name = "BlueprintPrintProviderId", referencedColumnName = "BlueprintPrintProviderId")
    private BlueprintPrintProvider blueprintPrintProvidersByBlueprintPrintProviderId;
    @ManyToOne
    @JoinColumn(name = "ColorId", referencedColumnName = "ColorId")
    private Color colorsByColorId;

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
        BlueprintPrintProviderColor that = (BlueprintPrintProviderColor) o;
        return blueprintPrintProviderColorId == that.blueprintPrintProviderColorId && Objects.equals(blueprintPrintProviderId, that.blueprintPrintProviderId) && Objects.equals(colorId, that.colorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blueprintPrintProviderColorId, blueprintPrintProviderId, colorId);
    }

    public BlueprintPrintProvider getBlueprintPrintProvidersByBlueprintPrintProviderId() {
        return blueprintPrintProvidersByBlueprintPrintProviderId;
    }

    public void setBlueprintPrintProvidersByBlueprintPrintProviderId(BlueprintPrintProvider blueprintPrintProvidersByBlueprintPrintProviderId) {
        this.blueprintPrintProvidersByBlueprintPrintProviderId = blueprintPrintProvidersByBlueprintPrintProviderId;
    }

    public Color getColorsByColorId() {
        return colorsByColorId;
    }

    public void setColorsByColorId(Color colorsByColorId) {
        this.colorsByColorId = colorsByColorId;
    }
}
