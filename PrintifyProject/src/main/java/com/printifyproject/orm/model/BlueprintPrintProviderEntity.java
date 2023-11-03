package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "blueprintprintproviders", schema = "inkcredible")
public class BlueprintPrintProviderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BlueprintPrintProviderId", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "BlueprintId", nullable = false)
    private BlueprintEntity blueprint;

    @ManyToOne
    @JoinColumn(name = "PrintProviderId", nullable = false)
    private PrintProviderEntity printProvider;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "blueprintPrintProvider", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BlueprintPrintProviderVariantEntity> colors = new HashSet<>();

    public BlueprintPrintProviderEntity() {
    }

    public BlueprintPrintProviderEntity(BlueprintEntity blueprint, PrintProviderEntity printProvider) {
        this.blueprint = blueprint;
        this.printProvider = printProvider;
    }

    public int getId() {
        return id;
    }

    public void setId(int blueprintPrintProviderId) {
        this.id = blueprintPrintProviderId;
    }

    public BlueprintEntity getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(BlueprintEntity blueprint) {
        this.blueprint = blueprint;
    }

    public PrintProviderEntity getPrintProvider() {
        return printProvider;
    }

    public void setPrintProvider(PrintProviderEntity printProvider) {
        this.printProvider = printProvider;
    }

    public Set<BlueprintPrintProviderVariantEntity> getColors() {
        return colors;
    }

    public void setColors(Set<BlueprintPrintProviderVariantEntity> colors) {
        this.colors = colors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlueprintPrintProviderEntity that = (BlueprintPrintProviderEntity) o;
        return id == that.id && Objects.equals(blueprint, that.blueprint) && Objects.equals(printProvider, that.printProvider) && Objects.equals(colors, that.colors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, blueprint, printProvider, colors);
    }
}
