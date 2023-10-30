package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "printspeccolors", schema = "inkcredible", catalog = "")
public class PrintSpecColorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PrintSpecColorId", nullable = false)
    private int printSpecColorId;
    @Basic
    @Column(name = "PrintSpecId", nullable = true, insertable=false, updatable=false)
    private Integer printSpecId;
    @Basic
    @Column(name = "ColorId", nullable = true, insertable=false, updatable=false)
    private Integer colorId;
    @ManyToOne
    @JoinColumn(name = "PrintSpecId", referencedColumnName = "PrintSpecId")
    private PrintSpecEntity printspecsByPrintSpecId;
    @ManyToOne
    @JoinColumn(name = "ColorId")
    private ColorEntity colorInPrintSpec;

    public int getPrintSpecColorId() {
        return printSpecColorId;
    }

    public void setPrintSpecColorId(int printSpecColorId) {
        this.printSpecColorId = printSpecColorId;
    }

    public Integer getPrintSpecId() {
        return printSpecId;
    }

    public void setPrintSpecId(Integer printSpecId) {
        this.printSpecId = printSpecId;
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
        PrintSpecColorEntity that = (PrintSpecColorEntity) o;
        return printSpecColorId == that.printSpecColorId && Objects.equals(printSpecId, that.printSpecId) && Objects.equals(colorId, that.colorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printSpecColorId, printSpecId, colorId);
    }

    public PrintSpecEntity getPrintspecsByPrintSpecId() {
        return printspecsByPrintSpecId;
    }

    public void setPrintspecsByPrintSpecId(PrintSpecEntity printspecsByPrintSpecId) {
        this.printspecsByPrintSpecId = printspecsByPrintSpecId;
    }

    public ColorEntity getColorInPrintSpec() {
        return colorInPrintSpec;
    }

    public void setColorInPrintSpec(ColorEntity colorsByColorId) {
        this.colorInPrintSpec = colorsByColorId;
    }
}
