package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Colors", schema = "dbo", catalog = "printify-db")
public class Color {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ColorId", nullable = false)
    private int colorId;
    @Basic
    @Column(name = "Color", nullable = true, length = 2147483647)
    private String color;
    @Basic
    @Column(name = "Hex", nullable = true, length = 10)
    private String hex;
    @OneToMany(mappedBy = "colorsByColorId")
    private Collection<BlueprintPrintProviderColor> blueprintPrintProviderColorsByColorId;
    @OneToMany(mappedBy = "colorsByColorId")
    private Collection<PrintSpecColor> printSpecColorsByColorId;

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color1 = (Color) o;
        return colorId == color1.colorId && Objects.equals(color, color1.color) && Objects.equals(hex, color1.hex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorId, color, hex);
    }

    public Collection<BlueprintPrintProviderColor> getBlueprintPrintProviderColorsByColorId() {
        return blueprintPrintProviderColorsByColorId;
    }

    public void setBlueprintPrintProviderColorsByColorId(Collection<BlueprintPrintProviderColor> blueprintPrintProviderColorsByColorId) {
        this.blueprintPrintProviderColorsByColorId = blueprintPrintProviderColorsByColorId;
    }

    public Collection<PrintSpecColor> getPrintSpecColorsByColorId() {
        return printSpecColorsByColorId;
    }

    public void setPrintSpecColorsByColorId(Collection<PrintSpecColor> printSpecColorsByColorId) {
        this.printSpecColorsByColorId = printSpecColorsByColorId;
    }
}
