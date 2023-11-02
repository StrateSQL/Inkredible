package com.printifyproject.orm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "blueprintprintprovidersizes", schema = "inkcredible")
public class BlueprintPrintProviderSizeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BlueprintPrintProviderSizeId", nullable = false)
    private int blueprintPrintProviderSizeId;

    @ManyToOne
    @JoinColumn(name = "BlueprintPrintProviderId")
    private BlueprintPrintProviderEntity blueprintPrintProvider;

    @ManyToOne
    @JoinColumn(name = "SizeId")
    private SizeEntity size;

    public BlueprintPrintProviderSizeEntity() {
    }

    public int getBlueprintPrintProviderSizeId() {
        return blueprintPrintProviderSizeId;
    }

    public void setBlueprintPrintProviderSizeId(int blueprintPrintProviderSizeId) {
        this.blueprintPrintProviderSizeId = blueprintPrintProviderSizeId;
    }

    public BlueprintPrintProviderEntity getBlueprintPrintProvider() {
        return blueprintPrintProvider;
    }

    public void setBlueprintPrintProvider(BlueprintPrintProviderEntity blueprintPrintProvider) {
        this.blueprintPrintProvider = blueprintPrintProvider;
    }

    public SizeEntity getSize() {
        return size;
    }

    public void setSize(SizeEntity size) {
        this.size = size;
    }
}
