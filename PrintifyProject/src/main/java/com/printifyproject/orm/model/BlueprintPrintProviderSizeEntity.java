package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "blueprintprintprovidersizes", schema = "inkcredible")
public class BlueprintPrintProviderSizeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BlueprintPrintProviderSizeId", nullable = false)
    private int blueprintPrintProviderSizeId;
    @Basic
    @Column(name = "BlueprintPrintProviderId", nullable = true, insertable=false, updatable=false)
    private Integer blueprintPrintProviderId;
    @Basic
    @Column(name = "SizeId", nullable = true, insertable=false, updatable=false)
    private Integer sizeId;
    @ManyToOne
    @JoinColumn(name = "BlueprintPrintProviderId", referencedColumnName = "BlueprintPrintProviderId")
    private BlueprintPrintProviderEntity blueprintprintprovidersByBlueprintPrintProviderId;
    @ManyToOne
    @JoinColumn(name = "SizeId")
    private SizeEntity sizeInBlueprintPrintProvider;

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
        BlueprintPrintProviderSizeEntity that = (BlueprintPrintProviderSizeEntity) o;
        return blueprintPrintProviderSizeId == that.blueprintPrintProviderSizeId && Objects.equals(blueprintPrintProviderId, that.blueprintPrintProviderId) && Objects.equals(sizeId, that.sizeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blueprintPrintProviderSizeId, blueprintPrintProviderId, sizeId);
    }

    public BlueprintPrintProviderEntity getBlueprintprintprovidersByBlueprintPrintProviderId() {
        return blueprintprintprovidersByBlueprintPrintProviderId;
    }

    public void setBlueprintprintprovidersByBlueprintPrintProviderId(BlueprintPrintProviderEntity blueprintprintprovidersByBlueprintPrintProviderId) {
        this.blueprintprintprovidersByBlueprintPrintProviderId = blueprintprintprovidersByBlueprintPrintProviderId;
    }

    public SizeEntity getSizeInBlueprintPrintProvider() {
        return sizeInBlueprintPrintProvider;
    }

    public void setSizeInBlueprintPrintProvider(SizeEntity sizesBySizeId) {
        this.sizeInBlueprintPrintProvider = sizesBySizeId;
    }
}
