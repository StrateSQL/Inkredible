package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "sizes", schema = "inkcredible", catalog = "")
public class SizeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SizeId", nullable = false)
    private int sizeId;
    @Basic
    @Column(name = "Size", nullable = true, length = 50)
    private String size;
    @OneToMany(mappedBy = "sizeInBlueprintPrintProvider")
    private Collection<BlueprintPrintProviderSizeEntity> blueprintprintprovidersizesBySizeId;
    @OneToMany(mappedBy = "sizeInPrintSpec")
    private Collection<PrintSpecSizeEntity> printspecsizesBySizeId;

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
        SizeEntity that = (SizeEntity) o;
        return sizeId == that.sizeId && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeId, size);
    }

    public Collection<BlueprintPrintProviderSizeEntity> getBlueprintprintprovidersizesBySizeId() {
        return blueprintprintprovidersizesBySizeId;
    }

    public void setBlueprintprintprovidersizesBySizeId(Collection<BlueprintPrintProviderSizeEntity> blueprintprintprovidersizesBySizeId) {
        this.blueprintprintprovidersizesBySizeId = blueprintprintprovidersizesBySizeId;
    }

    public Collection<PrintSpecSizeEntity> getPrintspecsizesBySizeId() {
        return printspecsizesBySizeId;
    }

    public void setPrintspecsizesBySizeId(Collection<PrintSpecSizeEntity> printspecsizesBySizeId) {
        this.printspecsizesBySizeId = printspecsizesBySizeId;
    }
}
