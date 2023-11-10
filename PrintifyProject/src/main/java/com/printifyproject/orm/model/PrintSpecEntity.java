package com.printifyproject.orm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "printspecs", schema = "inkcredible")
public class PrintSpecEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PrintSpecId", nullable = false)
    private int printSpecId;

    @Column(name = "Name", nullable = false, length = 255, unique = true)
    @NotNull
    private String name;

    @Column(name = "GossMargin", precision = 0)
    private Double gossMargin;

    @ManyToOne
    @JoinColumn(name = "blueprintPrintProviderID", nullable = false)
    private BlueprintPrintProviderEntity blueprintPrintProvider;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "printSpec", cascade = CascadeType.ALL)
    private Set<PrintSpecColorEntity> colors = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "printSpec", cascade = CascadeType.ALL)
    private Collection<ProductEntity> products;

    public PrintSpecEntity() {
    }

    public PrintSpecEntity(String name, Double gossMargin, BlueprintPrintProviderEntity blueprintPrintProvider, Set<PrintSpecColorEntity> colors) {
        this.name = name;
        this.gossMargin = gossMargin;
        this.blueprintPrintProvider = blueprintPrintProvider;
        this.colors = colors;
    }

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

    public Double getGossMargin() {
        return gossMargin;
    }

    public void setGossMargin(Double gossMargin) {
        this.gossMargin = gossMargin;
    }

    public BlueprintPrintProviderEntity getBlueprintPrintProvider() {
        return blueprintPrintProvider;
    }

    public void setBlueprintPrintProvider(BlueprintPrintProviderEntity blueprintPrintProvider) {
        this.blueprintPrintProvider = blueprintPrintProvider;
    }

    public Set<PrintSpecColorEntity> getColors() {
        return colors;
    }

    public void setColors(Set<PrintSpecColorEntity> colors) {
        this.colors = colors;
    }

    public Collection<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Collection<ProductEntity> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintSpecEntity that = (PrintSpecEntity) o;
        return printSpecId == that.printSpecId && Objects.equals(name, that.name) && Objects.equals(gossMargin, that.gossMargin) && Objects.equals(blueprintPrintProvider, that.blueprintPrintProvider) && Objects.equals(colors, that.colors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printSpecId); // Use only the primary key field
    }
}
