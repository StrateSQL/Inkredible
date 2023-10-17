package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "PrintSpecSizes", schema = "dbo", catalog = "printify-db")
public class PrintSpecSize {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PrintSpecSizeId", nullable = false)
    private int printSpecSizeId;
    @Basic
    @Column(name = "PrintSpecId", nullable = true)
    private Integer printSpecId;
    @Basic
    @Column(name = "SizeId", nullable = true)
    private Integer sizeId;
    @ManyToOne
    @JoinColumn(name = "PrintSpecId", referencedColumnName = "PrintSpecId")
    private PrintSpec printSpecsByPrintSpecId;
    @ManyToOne
    @JoinColumn(name = "SizeId", referencedColumnName = "SizeId")
    private Size sizesBySizeId;

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
        PrintSpecSize that = (PrintSpecSize) o;
        return printSpecSizeId == that.printSpecSizeId && Objects.equals(printSpecId, that.printSpecId) && Objects.equals(sizeId, that.sizeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printSpecSizeId, printSpecId, sizeId);
    }

    public PrintSpec getPrintSpecsByPrintSpecId() {
        return printSpecsByPrintSpecId;
    }

    public void setPrintSpecsByPrintSpecId(PrintSpec printSpecsByPrintSpecId) {
        this.printSpecsByPrintSpecId = printSpecsByPrintSpecId;
    }

    public Size getSizesBySizeId() {
        return sizesBySizeId;
    }

    public void setSizesBySizeId(Size sizesBySizeId) {
        this.sizesBySizeId = sizesBySizeId;
    }
}
