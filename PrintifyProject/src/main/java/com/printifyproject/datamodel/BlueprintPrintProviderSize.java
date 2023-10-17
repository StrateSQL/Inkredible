package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "BlueprintPrintProviderSizes", schema = "dbo", catalog = "printify-db")
public class BlueprintPrintProviderSize {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BlueprintPrintProviderSizeId", nullable = false)
    private int blueprintPrintProviderSizeId;
    @Basic
    @Column(name = "BlueprintPrintProviderId", nullable = true)
    private Integer blueprintPrintProviderId;
    @Basic
    @Column(name = "SizeId", nullable = true)
    private Integer sizeId;
    @ManyToOne
    @JoinColumn(name = "BlueprintPrintProviderId", referencedColumnName = "BlueprintPrintProviderId")
    private BlueprintPrintProvider blueprintPrintProvidersByBlueprintPrintProviderId;
    @ManyToOne
    @JoinColumn(name = "SizeId", referencedColumnName = "SizeId")
    private Size sizesBySizeId;

    public int getBlueprintPrintProviderSizeId() {
        return blueprintPrintProviderSizeId;
    }

    public void setBlueprintPrintProviderSizeId(int blueprintPrintProviderSizeId) {
        this.blueprintPrintProviderSizeId = blueprintPrintProviderSizeId;
    }

    public Integer getBlueprintPrintProviderId() {
        return blueprintPrintProviderId;
    }

    public void setBlueprintPrintProviderId(Integer blueprintPrintProviderId) {
        this.blueprintPrintProviderId = blueprintPrintProviderId;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlueprintPrintProviderSize that = (BlueprintPrintProviderSize) o;
        return blueprintPrintProviderSizeId == that.blueprintPrintProviderSizeId && Objects.equals(blueprintPrintProviderId, that.blueprintPrintProviderId) && Objects.equals(sizeId, that.sizeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blueprintPrintProviderSizeId, blueprintPrintProviderId, sizeId);
    }

    public BlueprintPrintProvider getBlueprintPrintProvidersByBlueprintPrintProviderId() {
        return blueprintPrintProvidersByBlueprintPrintProviderId;
    }

    public void setBlueprintPrintProvidersByBlueprintPrintProviderId(BlueprintPrintProvider blueprintPrintProvidersByBlueprintPrintProviderId) {
        this.blueprintPrintProvidersByBlueprintPrintProviderId = blueprintPrintProvidersByBlueprintPrintProviderId;
    }

    public Size getSizesBySizeId() {
        return sizesBySizeId;
    }

    public void setSizesBySizeId(Size sizesBySizeId) {
        this.sizesBySizeId = sizesBySizeId;
    }
}
