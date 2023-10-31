package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "colors", schema = "inkcredible", catalog = "")
public class ColorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ColorId", nullable = false)
    private int colorId;
    @Basic
    @Column(name = "Color", nullable = true, length = 50)
    private String color;
    @Basic
    @Column(name = "Hex", nullable = true, length = 10)
    private String hex;
    @OneToMany(mappedBy = "colorInBlueprintPrintProvider")
    private Collection<BlueprintPrintProviderColorEntity> blueprintprintprovidercolorsByColorId;
    @OneToMany(mappedBy = "colorInPrintSpec")
    private Collection<PrintSpecColorEntity> printspeccolorsByColorId;

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColor() {
        return color;
    }

    public ColorEntity() {}

    public ColorEntity(String color, String hex) {
        this.color = color;
        this.hex = hex;
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
        ColorEntity that = (ColorEntity) o;
        return colorId == that.colorId && Objects.equals(color, that.color) && Objects.equals(hex, that.hex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorId, color, hex);
    }

    public Collection<BlueprintPrintProviderColorEntity> getBlueprintprintprovidercolorsByColorId() {
        return blueprintprintprovidercolorsByColorId;
    }

    public void setBlueprintprintprovidercolorsByColorId(Collection<BlueprintPrintProviderColorEntity> blueprintprintprovidercolorsByColorId) {
        this.blueprintprintprovidercolorsByColorId = blueprintprintprovidercolorsByColorId;
    }

    public Collection<PrintSpecColorEntity> getPrintspeccolorsByColorId() {
        return printspeccolorsByColorId;
    }

    public void setPrintspeccolorsByColorId(Collection<PrintSpecColorEntity> printspeccolorsByColorId) {
        this.printspeccolorsByColorId = printspeccolorsByColorId;
    }
}
