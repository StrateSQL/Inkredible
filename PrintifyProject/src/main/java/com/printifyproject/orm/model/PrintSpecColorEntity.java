package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "printspeccolors", schema = "inkcredible")
public class PrintSpecColorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PrintSpecColorId", nullable = false)
    private int printSpecColorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PrintSpecId", nullable = false)
    private PrintSpecEntity printSpec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ColorId", nullable = false)
    private ColorEntity color;

    public PrintSpecColorEntity() {
    }

    public PrintSpecColorEntity(PrintSpecEntity printSpec, ColorEntity color) {
        this.printSpec = printSpec;
        this.color = color;
    }

    public int getPrintSpecColorId() {
        return printSpecColorId;
    }

    public void setPrintSpecColorId(int printSpecColorId) {
        this.printSpecColorId = printSpecColorId;
    }

    public PrintSpecEntity getPrintSpec() {
        return printSpec;
    }

    public void setPrintSpec(PrintSpecEntity printSpec) {
        this.printSpec = printSpec;
    }

    public ColorEntity getColor() {
        return color;
    }

    public void setColor(ColorEntity color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintSpecColorEntity that = (PrintSpecColorEntity) o;
        return Objects.equals(printSpec, that.printSpec) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printSpecColorId); // Use only the primary key field
    }
}
