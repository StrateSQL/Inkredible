package com.printifyproject.orm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "blueprintprintproviders", schema = "inkcredible")
public class BlueprintPrintProviderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BlueprintPrintProviderId", nullable = false)
    private int blueprintPrintProviderId;

    @ManyToOne
    @JoinColumn(name = "BlueprintId")
    private BlueprintEntity blueprint;

    @ManyToOne
    @JoinColumn(name = "PrintProviderId")
    private PrintProviderEntity printProvider;

    public BlueprintPrintProviderEntity() {
    }
    public BlueprintPrintProviderEntity(BlueprintEntity blueprint, PrintProviderEntity printProvider) {
        this.blueprint = blueprint;
        this.printProvider = printProvider;
    }

    public int getBlueprintPrintProviderId() {
        return blueprintPrintProviderId;
    }

    public void setBlueprintPrintProviderId(int blueprintPrintProviderId) {
        this.blueprintPrintProviderId = blueprintPrintProviderId;
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
}
