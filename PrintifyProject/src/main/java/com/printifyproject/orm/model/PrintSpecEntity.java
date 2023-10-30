package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "printspecs", schema = "inkcredible", catalog = "")
public class PrintSpecEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PrintSpecId", nullable = false)
    private int printSpecId;
    @Basic
    @Column(name = "Name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "BlueprintPrintProviderId", nullable = true, insertable=false, updatable=false)
    private Integer blueprintPrintProviderId;
    @Basic
    @Column(name = "GossMargin", nullable = true, precision = 0)
    private Double gossMargin;
    @OneToMany(mappedBy = "printspecsByPrintSpecId")
    private Collection<PrintSpecColorEntity> printspeccolorsByPrintSpecId;
    @ManyToOne
    @JoinColumn(name = "BlueprintPrintProviderId", referencedColumnName = "BlueprintPrintProviderId")
    private BlueprintPrintProviderEntity blueprintprintprovidersByBlueprintPrintProviderId;
    @OneToMany(mappedBy = "printSpec")
    private Collection<PrintSpecSizeEntity> printspecsizesByPrintSpecId;
    @OneToMany(mappedBy = "printSpec")
    private Collection<ProductEntity> productsByPrintSpecId;

    public int getPrintSpecId() {
        return printSpecId;
    }

    public void setPrintSpecId(int printSpecId) {
        this.printSpecId = printSpecId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBlueprintPrintProviderId() {
        return blueprintPrintProviderId;
    }

    public void setBlueprintPrintProviderId(Integer blueprintPrintProviderId) {
        this.blueprintPrintProviderId = blueprintPrintProviderId;
    }

    public Double getGossMargin() {
        return gossMargin;
    }

    public void setGossMargin(Double gossMargin) {
        this.gossMargin = gossMargin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintSpecEntity that = (PrintSpecEntity) o;
        return printSpecId == that.printSpecId && Objects.equals(name, that.name) && Objects.equals(blueprintPrintProviderId, that.blueprintPrintProviderId) && Objects.equals(gossMargin, that.gossMargin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printSpecId, name, blueprintPrintProviderId, gossMargin);
    }

    public Collection<PrintSpecColorEntity> getPrintspeccolorsByPrintSpecId() {
        return printspeccolorsByPrintSpecId;
    }

    public void setPrintspeccolorsByPrintSpecId(Collection<PrintSpecColorEntity> printspeccolorsByPrintSpecId) {
        this.printspeccolorsByPrintSpecId = printspeccolorsByPrintSpecId;
    }

    public BlueprintPrintProviderEntity getBlueprintprintprovidersByBlueprintPrintProviderId() {
        return blueprintprintprovidersByBlueprintPrintProviderId;
    }

    public void setBlueprintprintprovidersByBlueprintPrintProviderId(BlueprintPrintProviderEntity blueprintprintprovidersByBlueprintPrintProviderId) {
        this.blueprintprintprovidersByBlueprintPrintProviderId = blueprintprintprovidersByBlueprintPrintProviderId;
    }

    public Collection<PrintSpecSizeEntity> getPrintspecsizesByPrintSpecId() {
        return printspecsizesByPrintSpecId;
    }

    public void setPrintspecsizesByPrintSpecId(Collection<PrintSpecSizeEntity> printspecsizesByPrintSpecId) {
        this.printspecsizesByPrintSpecId = printspecsizesByPrintSpecId;
    }

    public Collection<ProductEntity> getProductsByPrintSpecId() {
        return productsByPrintSpecId;
    }

    public void setProductsByPrintSpecId(Collection<ProductEntity> productsByPrintSpecId) {
        this.productsByPrintSpecId = productsByPrintSpecId;
    }
}
