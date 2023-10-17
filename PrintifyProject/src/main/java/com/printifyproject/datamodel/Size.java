package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Sizes", schema = "dbo", catalog = "printify-db")
public class Size {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SizeId", nullable = false)
    private int sizeId;
    @Basic
    @Column(name = "Size", nullable = true, length = 2147483647)
    private String size;
    @OneToMany(mappedBy = "sizesBySizeId")
    private Collection<BlueprintPrintProviderSize> blueprintPrintProviderSizesBySizeId;
    @OneToMany(mappedBy = "sizesBySizeId")
    private Collection<PrintSpecSize> printSpecSizesBySizeId;

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size1 = (Size) o;
        return sizeId == size1.sizeId && Objects.equals(size, size1.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeId, size);
    }

    public Collection<BlueprintPrintProviderSize> getBlueprintPrintProviderSizesBySizeId() {
        return blueprintPrintProviderSizesBySizeId;
    }

    public void setBlueprintPrintProviderSizesBySizeId(Collection<BlueprintPrintProviderSize> blueprintPrintProviderSizesBySizeId) {
        this.blueprintPrintProviderSizesBySizeId = blueprintPrintProviderSizesBySizeId;
    }

    public Collection<PrintSpecSize> getPrintSpecSizesBySizeId() {
        return printSpecSizesBySizeId;
    }

    public void setPrintSpecSizesBySizeId(Collection<PrintSpecSize> printSpecSizesBySizeId) {
        this.printSpecSizesBySizeId = printSpecSizesBySizeId;
    }
}
