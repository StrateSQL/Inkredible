package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "PrintSpecColors", schema = "dbo", catalog = "printify-db")
public class PrintSpecColor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PrintSpecColorId", nullable = false)
    private int printSpecColorId;
    @Basic
    @Column(name = "PrintSpecId", nullable = true)
    private Integer printSpecId;
    @Basic
    @Column(name = "ColorId", nullable = true)
    private Integer colorId;
    @ManyToOne
    @JoinColumn(name = "PrintSpecId", referencedColumnName = "PrintSpecId")
    private PrintSpec printSpecsByPrintSpecId;
    @ManyToOne
    @JoinColumn(name = "ColorId", referencedColumnName = "ColorId")
    private Color colorsByColorId;

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
        PrintSpecColor that = (PrintSpecColor) o;
        return printSpecColorId == that.printSpecColorId && Objects.equals(printSpecId, that.printSpecId) && Objects.equals(colorId, that.colorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printSpecColorId, printSpecId, colorId);
    }

    public PrintSpec getPrintSpecsByPrintSpecId() {
        return printSpecsByPrintSpecId;
    }

    public void setPrintSpecsByPrintSpecId(PrintSpec printSpecsByPrintSpecId) {
        this.printSpecsByPrintSpecId = printSpecsByPrintSpecId;
    }

    public Color getColorsByColorId() {
        return colorsByColorId;
    }

    public void setColorsByColorId(Color colorsByColorId) {
        this.colorsByColorId = colorsByColorId;
    }
}
