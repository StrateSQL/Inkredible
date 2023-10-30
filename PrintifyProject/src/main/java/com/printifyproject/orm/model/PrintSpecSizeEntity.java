package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "printspecsizes", schema = "inkcredible", catalog = "")
public class PrintSpecSizeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PrintSpecSizeId", nullable = false)
    private int printSpecSizeId;
    @Basic
    @Column(name = "PrintSpecId", nullable = true, insertable = false, updatable = false)
    private Integer printSpecId;
    @Basic
    @Column(name = "SizeId", nullable = true, insertable = false, updatable = false)
    private Integer sizeId;
    @ManyToOne
    @JoinColumn(name = "PrintSpecId")
    private PrintSpecEntity printSpec;
    @ManyToOne
    @JoinColumn(name = "SizeId")
    private SizeEntity sizeInPrintSpec;

    public int getPrintSpecSizeId() {
        return printSpecSizeId;
    }

    public void setPrintSpecSizeId(int printSpecSizeId) {
        this.printSpecSizeId = printSpecSizeId;
    }

    public Integer getPrintSpecId() {
        return printSpecId;
    }

    public void setPrintSpecId(Integer printSpecId) {
        this.printSpecId = printSpecId;
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
        PrintSpecSizeEntity that = (PrintSpecSizeEntity) o;
        return printSpecSizeId == that.printSpecSizeId && Objects.equals(printSpecId, that.printSpecId) && Objects.equals(sizeId, that.sizeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printSpecSizeId, printSpecId, sizeId);
    }

    public PrintSpecEntity getPrintSpec() {
        return printSpec;
    }

    public void setPrintSpec(PrintSpecEntity printspecsByPrintSpecId) {
        this.printSpec = printspecsByPrintSpecId;
    }

    public SizeEntity getSizeInPrintSpec() {
        return sizeInPrintSpec;
    }

    public void setSizeInPrintSpec(SizeEntity sizesBySizeId) {
        this.sizeInPrintSpec = sizesBySizeId;
    }
}
