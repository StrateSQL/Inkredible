package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PrintSpecs", schema = "dbo", catalog = "printify-db")
public class PrintSpec {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PrintSpecId", nullable = false)
    private int printSpecId;
    @Basic
    @Column(name = "Name", nullable = true, length = 2147483647)
    private String name;
    @Basic
    @Column(name = "BlueprintPrintProviderId", nullable = true)
    private Integer blueprintPrintProviderId;
    @Basic
    @Column(name = "GossMargin", nullable = true, precision = 0)
    private Double gossMargin;
    @OneToMany(mappedBy = "printSpecsByPrintSpecId")
    private Collection<PrintSpecColor> printSpecColorsByPrintSpecId;
    @OneToMany(mappedBy = "printSpecsByPrintSpecId")
    private Collection<PrintSpecSize> printSpecSizesByPrintSpecId;
    @ManyToOne
    @JoinColumn(name = "BlueprintPrintProviderId", referencedColumnName = "BlueprintPrintProviderId")
    private BlueprintPrintProvider blueprintPrintProvidersByBlueprintPrintProviderId;
    @OneToMany(mappedBy = "printSpecsByPrintSpecId")
    private Collection<Product> productsByPrintSpecId;

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
        PrintSpec printSpec = (PrintSpec) o;
        return printSpecId == printSpec.printSpecId && Objects.equals(name, printSpec.name) && Objects.equals(blueprintPrintProviderId, printSpec.blueprintPrintProviderId) && Objects.equals(gossMargin, printSpec.gossMargin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printSpecId, name, blueprintPrintProviderId, gossMargin);
    }

    public Collection<PrintSpecColor> getPrintSpecColorsByPrintSpecId() {
        return printSpecColorsByPrintSpecId;
    }

    public void setPrintSpecColorsByPrintSpecId(Collection<PrintSpecColor> printSpecColorsByPrintSpecId) {
        this.printSpecColorsByPrintSpecId = printSpecColorsByPrintSpecId;
    }

    public Collection<PrintSpecSize> getPrintSpecSizesByPrintSpecId() {
        return printSpecSizesByPrintSpecId;
    }

    public void setPrintSpecSizesByPrintSpecId(Collection<PrintSpecSize> printSpecSizesByPrintSpecId) {
        this.printSpecSizesByPrintSpecId = printSpecSizesByPrintSpecId;
    }

    public BlueprintPrintProvider getBlueprintPrintProvidersByBlueprintPrintProviderId() {
        return blueprintPrintProvidersByBlueprintPrintProviderId;
    }

    public void setBlueprintPrintProvidersByBlueprintPrintProviderId(BlueprintPrintProvider blueprintPrintProvidersByBlueprintPrintProviderId) {
        this.blueprintPrintProvidersByBlueprintPrintProviderId = blueprintPrintProvidersByBlueprintPrintProviderId;
    }

    public Collection<Product> getProductsByPrintSpecId() {
        return productsByPrintSpecId;
    }

    public void setProductsByPrintSpecId(Collection<Product> productsByPrintSpecId) {
        this.productsByPrintSpecId = productsByPrintSpecId;
    }
}
